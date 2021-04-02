package com.wechat.pay.utils;

import com.alibaba.fastjson.JSON;
import com.wechat.pay.contrib.apache.httpclient.WechatPayHttpClientBuilder;
import com.wechat.pay.contrib.apache.httpclient.auth.AutoUpdateCertificatesVerifier;
import com.wechat.pay.contrib.apache.httpclient.auth.PrivateKeySigner;
import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Credentials;
import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Validator;
import com.wechat.pay.contrib.apache.httpclient.util.PemUtil;
import com.wechat.pay.utils.json.JsonUtils;
import com.wechat.pay.utils.sign.WxApiV3SignUtils;
import com.wechat.pay.v3.config.WxDirectlyApiV3Config;
import com.wechat.pay.v3.config.WxPartnerApiV3Config;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.Objects;

/**
 * @author LYJ
 * @date 2021/1/28 8:59
 * @since 1.0
 */
public class WxPayUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(WxPayUtil.class);

    private static final String WE_CHAT_PAY_SERIAL = "Wechatpay-Serial";


    /**
     * 测试AutoUpdateCertificatesVerifier的verify方法参数
     */
    public CloseableHttpClient httpClient;

    public AutoUpdateCertificatesVerifier verifier;

    public X509Certificate certificate;

    public PrivateKey privateKey;


    /**
     * 下单工具方法
     *
     * @param wxRequest
     * @param url
     * @return
     * @
     */
    public Map<String, String> payUtils(Object wxRequest, String url) {
        String result = "";
        try {
            HttpPost httpPost = new HttpPost(url);
            // 设置请求头
            setHeader(httpPost);
            String submitJson = JSON.toJSONString(wxRequest);
            LOGGER.info("submit  json---->\n" + submitJson);
            //防止中文乱码
            httpPost.setEntity(new StringEntity(submitJson, "UTF-8"));
            HttpResponse response = null;
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity);
            LOGGER.info(" result source->{}", result);
            if (response.getStatusLine().getStatusCode() == 200) {
                LOGGER.info("result---->" + result);
                Map<String, String> map = JsonUtils.toMap(result, String.class, String.class);
                return map;
            }
        } catch (IOException e) {
            LOGGER.warn("result error---->" + result);
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 设置请求头
     *
     * @param httpPost
     */
    public void setHeader(HttpRequestBase httpPost) {
        ;
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.addHeader("Accept", "application/json");
        httpPost.addHeader(WE_CHAT_PAY_SERIAL, certificate.getSerialNumber().toString(16).toUpperCase());
        LOGGER.info(WE_CHAT_PAY_SERIAL + "--->" + certificate.getSerialNumber().toString(16).toUpperCase());
    }


    /**
     * 服务商获取自动更新验证签名器httpClient
     */
    public void builderPartnerHttpClient(WxPartnerApiV3Config wxPartnerApiV3Config) {
        try {
            if (Objects.isNull(wxPartnerApiV3Config)) {
                throw new RuntimeException("wxApiV3Config配置为空");
            }
            if (Objects.isNull(wxPartnerApiV3Config.getSpMchId())) {
                throw new RuntimeException("请配置商户号");
            }
            if (Objects.isNull(wxPartnerApiV3Config.getMchSerialNo())) {
                throw new RuntimeException("请配置证书序列号");
            }
            if (Objects.isNull(wxPartnerApiV3Config.getApiV3Key())) {
                throw new RuntimeException("请配置ApiV3key");
            }
            if (Objects.isNull(wxPartnerApiV3Config.getWeChatPayCertificateFilePath())) {
                throw new RuntimeException("请配置微信平台证书路径");
            }
            if (Objects.isNull(wxPartnerApiV3Config.getMchPrivateKeyFilePath())) {
                throw new RuntimeException("请配置私钥文件路径");
            }
            this.certificate = PemUtil.loadCertificate(new FileInputStream(new File(wxPartnerApiV3Config.getWeChatPayCertificateFilePath())));
            this.privateKey = WxApiV3SignUtils.getPrivateKey(wxPartnerApiV3Config.getMchPrivateKeyFilePath());
            verifier = new AutoUpdateCertificatesVerifier(
                    new WechatPay2Credentials(wxPartnerApiV3Config.getSpMchId(), new PrivateKeySigner(wxPartnerApiV3Config.getMchSerialNo(), this.privateKey)),
                    wxPartnerApiV3Config.getApiV3Key().getBytes("utf-8"));
            WechatPayHttpClientBuilder builder = WechatPayHttpClientBuilder.create()
                    .withMerchant(wxPartnerApiV3Config.getSpMchId(), wxPartnerApiV3Config.getMchSerialNo(), this.privateKey)
                    .withValidator(new WechatPay2Validator(verifier));
            // 通过WechatPayHttpClientBuilder构造的HttpClient，会自动的处理签名和验签，并进行证书自动更新
            this.httpClient = builder.build();
        } catch (Exception e) {
            LOGGER.error("构建httpClient出错", e);
            e.printStackTrace();
        }
    }


    /**
     * 直连商户获取自动更新验证签名器httpClient
     */
    public void builderDirectlyHttpClient(WxDirectlyApiV3Config wxDirectlyApiV3Config) {
        try {
            if (Objects.isNull(wxDirectlyApiV3Config)) {
                throw new RuntimeException("wxApiV3Config配置为空");
            }
            if (Objects.isNull(wxDirectlyApiV3Config.getMchId())) {
                throw new RuntimeException("请配置商户号");
            }
            if (Objects.isNull(wxDirectlyApiV3Config.getMchSerialNo())) {
                throw new RuntimeException("请配置证书序列号");
            }
            if (Objects.isNull(wxDirectlyApiV3Config.getApiV3Key())) {
                throw new RuntimeException("请配置ApiV3key");
            }
            if (Objects.isNull(wxDirectlyApiV3Config.getWeChatPayCertificateFilePath())) {
                throw new RuntimeException("请配置微信平台证书路径");
            }
            if (Objects.isNull(wxDirectlyApiV3Config.getMchPrivateKeyFilePath())) {
                throw new RuntimeException("请配置私钥文件路径");
            }
            this.certificate = PemUtil.loadCertificate(new FileInputStream(new File(wxDirectlyApiV3Config.getWeChatPayCertificateFilePath())));
            this.privateKey = WxApiV3SignUtils.getPrivateKey(wxDirectlyApiV3Config.getMchPrivateKeyFilePath());
            verifier = new AutoUpdateCertificatesVerifier(
                    new WechatPay2Credentials(wxDirectlyApiV3Config.getMchId(), new PrivateKeySigner(wxDirectlyApiV3Config.getMchSerialNo(), this.privateKey)),
                    wxDirectlyApiV3Config.getApiV3Key().getBytes("utf-8"));
            WechatPayHttpClientBuilder builder = WechatPayHttpClientBuilder.create()
                    .withMerchant(wxDirectlyApiV3Config.getMchId(), wxDirectlyApiV3Config.getMchSerialNo(), this.privateKey)
                    .withValidator(new WechatPay2Validator(verifier));
            // 通过WechatPayHttpClientBuilder构造的HttpClient，会自动的处理签名和验签，并进行证书自动更新
            this.httpClient = builder.build();
        } catch (Exception e) {
            LOGGER.error("构建httpClient出错", e);
            e.printStackTrace();
        }
    }

}
