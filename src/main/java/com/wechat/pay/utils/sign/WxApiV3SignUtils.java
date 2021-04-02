package com.wechat.pay.utils.sign;

import com.wechat.pay.contrib.apache.httpclient.auth.AutoUpdateCertificatesVerifier;
import com.wechat.pay.contrib.apache.httpclient.auth.PrivateKeySigner;
import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Credentials;
import com.wechat.pay.contrib.apache.httpclient.util.PemUtil;
import com.wechat.pay.v3.config.WxPartnerApiV3Config;
import okhttp3.HttpUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Base64;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 微信API-V3签名工具
 *
 * @author LYJ
 * @date 2021/1/25 11:39
 * @since 1.0
 */
public class WxApiV3SignUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(WxApiV3SignUtils.class);

    //签名类型
    public static final String SIGN_TYPE = "SHA256withRSA";

    /**
     * The constant SCHEMA.
     */
    private static final String SCHEMA = "WECHATPAY2-SHA256-RSA2048 ";

    /**
     * The constant TOKEN_PATTERN.
     */
    public static final String TOKEN_PATTERN = "mchid=\"%s\",nonce_str=\"%s\",timestamp=\"%d\",serial_no=\"%s\",signature=\"%s\"";


    private static final String SYMBOLS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final Random RANDOM = new SecureRandom();

    private static final Map<String, X509Certificate> CERTIFICATE_MAP = new ConcurrentHashMap<String, X509Certificate>();


    /**
     * 获取 SCHEMA token
     *
     * @param method
     * @param urlStr
     * @param body
     * @param mchId      商户号
     * @param privateKey 商户证书私钥
     * @param serialNo   商户API证书序列号
     * @return
     * @throws Exception
     */
    public static String getToken(String method, String urlStr, String body, String mchId, PrivateKey privateKey, String serialNo) throws Exception {
        HttpUrl url = HttpUrl.parse(urlStr);
        String nonceStr = generateNonceStr();
        long timestamp = getCurrentTimestamp();
        String canonicalUrl = url.encodedPath();
        if (url.encodedQuery() != null) {
            canonicalUrl += "?" + url.encodedQuery();
        }
        //按微信要求传递字段数据
        String message = createMessage(method, canonicalUrl, String.valueOf(timestamp), nonceStr, body);
        String signature = sign(message, privateKey);
        // 生成token
        String token = String.format(TOKEN_PATTERN, mchId, nonceStr, timestamp, serialNo, signature);

        return SCHEMA.concat(token);
    }


    /**
     * 通过文件路径获取商户私钥
     *
     * @param mchPrivateKeyFilePath
     * @return
     * @throws Exception
     */
    public static PrivateKey getPrivateKey(String mchPrivateKeyFilePath) {
        try {
            return PemUtil.loadPrivateKey(new FileInputStream(new File(mchPrivateKeyFilePath)));
        } catch (FileNotFoundException e) {
            LOGGER.error("文件传输错误", e);
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 生成签名
     *
     * @param message
     * @param privateKey 商户私钥
     * @return
     */
    public static String sign(String message, PrivateKey privateKey) throws Exception {
        Signature sign = Signature.getInstance(SIGN_TYPE);
        sign.initSign(privateKey);
        sign.update(message.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(sign.sign());
    }


    /**
     * 构造签名字符串，按微信要求使用 "\n"连接
     * 请求时设置签名   字段
     *
     * @param fields fields
     * @return string string
     */
    public static String createMessage(String... fields) {
        //这里的坑有点深，微信要求每个字段后面加上字符串“\n”，由于'\'为转义符，在这里需要加双斜杠，要不字符串“\n”会自动去掉换行
        return Arrays.stream(fields)
                .collect(Collectors.joining("\\n", "", "\\n"));
    }


//    应答时间戳\n
//    应答随机串\n
//    应答报文主体\n


    /**
     * 构造验签字符串
     *
     * @param weChatPayTimestamp HTTP头 	weChatPay-Timestamp	中的应答时间戳
     * @param weChatPayNonce     HTTP头 	weChatPay-Nonce	中的应答随机串
     * @param body               响应体
     * @return String    验签名串
     */
    public static String responseSign(String weChatPayTimestamp, String weChatPayNonce, String body) {
        // 将参数末尾的空白字符\n等全部去掉，否则验签失败
        return Stream.of(weChatPayTimestamp.trim(), weChatPayNonce.trim(), body.trim())
                .collect(Collectors.joining("\\n", "", "\\n"));
    }


    /**
     * 使用微信平台证书对响应验签，和应答签名比较
     *
     * @param weChatPaySerial    response.headers['weChatPay-Serial']		当前使用的微信平台证书序列号
     * @param weChatPaySignature response.headers['weChatPay-Signature']		微信平台签名
     * @param weChatPayTimestamp response.headers['weChatPay-Timestamp']		微信服务器时间戳
     * @param weChatPayNonce     response.headers['weChatPay-Nonce']			微信服务器提供的随机串
     * @param body               response.headers['weChatPay-body'] 			微信服务器的响应体
     * @return boolean
     */
    public boolean responseSignVerify(String weChatPaySerial, String weChatPaySignature, String weChatPayTimestamp, String weChatPayNonce, String body) {
        LOGGER.info("WXPayUtil responseSignVerify start : weChatPaySerial = " + weChatPaySerial +
                ", weChatPaySignature = " + weChatPaySignature + ", weChatPayTimestamp = " + weChatPayTimestamp +
                ", weChatPayNonce = " + weChatPayNonce + ", body = " + body);

        // 自动更新证书
        if (CERTIFICATE_MAP.isEmpty() || !CERTIFICATE_MAP.containsKey(weChatPaySerial)) {
            refreshCertificate(wxPartnerApiV3Config);
        }

        X509Certificate certificate = CERTIFICATE_MAP.get(weChatPaySerial);
//		log.info("WXPayUtil responseSignVerify CERTIFICATE_MAP证书：certificate" + certificate);

        // 构造验签名串
        final String strSignature = responseSign(weChatPayTimestamp, weChatPayNonce, body);

        LOGGER.info("WXPayUtil responseSignVerify 构造验签名串 strSignature : " + strSignature);

        try {
            // 加载 SHA256withRSA 签名器
            Signature signer = Signature.getInstance(SIGN_TYPE);
            // 用微信平台公钥对签名器进行初始化
            signer.initVerify(certificate);
            // 将验签名串更新到签名器中
            signer.update(strSignature.getBytes(StandardCharsets.UTF_8));

            boolean ret = signer.verify(Base64.getDecoder().decode(weChatPaySignature));
            LOGGER.info("WXPayUtil responseSignVerify 验签结果 ret = " + ret);

            return ret;
        } catch (NoSuchAlgorithmException | SignatureException e) {
            // TODO Auto-generated catch block
            throw new IllegalStateException(e);
        } catch (InvalidKeyException e) {
            // TODO Auto-generated catch block
            throw new IllegalArgumentException(e);
        }
    }

    private WxPartnerApiV3Config wxPartnerApiV3Config;


    //TODO 自动获取平台证书，保存证书序列号和证书到  CERTIFICATE_MAP里

    /**
     * 证书动态刷新，将最新的证书放入Map中
     */
    public void refreshCertificate(WxPartnerApiV3Config wxPartnerApiV3Config) {

        //获取证书
        AutoUpdateCertificatesVerifier verifier = null;
        try {
            verifier = new AutoUpdateCertificatesVerifier(
                    new WechatPay2Credentials(wxPartnerApiV3Config.getSpMchId(), new PrivateKeySigner(wxPartnerApiV3Config.getMchSerialNo(), getPrivateKey(wxPartnerApiV3Config.getMchPrivateKeyFilePath()))),
                    wxPartnerApiV3Config.getApiV3Key().getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        X509Certificate certificate = verifier.getValidCertificate();
        LOGGER.info("NativeService-refreshCertificate x509Certificate 最近的证书为：" + certificate);
        try {
            String responseSerialNo = String.valueOf(certificate.getSerialNumber());
            System.out.println("NativeService-getConfigProperties 证书序列号为serial_no：" + responseSerialNo);
            // 清空HashMap()
            CERTIFICATE_MAP.clear();
            // 放入证书
            CERTIFICATE_MAP.put(responseSerialNo, certificate);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    /**
     * 获取随机字符串 Nonce Str
     *
     * @return String 随机字符串
     */
    public static String generateNonceStr() {
        char[] nonceChars = new char[32];
        for (int index = 0; index < nonceChars.length; ++index) {
            nonceChars[index] = SYMBOLS.charAt(RANDOM.nextInt(SYMBOLS.length()));
        }
        return new String(nonceChars);
    }


    /**
     * 获取当前时间戳，单位秒
     *
     * @return
     */
    public static long getCurrentTimestamp() {
        return System.currentTimeMillis() / 1000;
    }


}
