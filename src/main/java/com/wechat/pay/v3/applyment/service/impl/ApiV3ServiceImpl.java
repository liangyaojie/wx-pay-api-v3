package com.wechat.pay.v3.applyment.service.impl;

import com.wechat.pay.contrib.apache.httpclient.WechatPayHttpClientBuilder;
import com.wechat.pay.contrib.apache.httpclient.WechatPayUploadHttpPost;
import com.wechat.pay.contrib.apache.httpclient.auth.AutoUpdateCertificatesVerifier;
import com.wechat.pay.contrib.apache.httpclient.auth.PrivateKeySigner;
import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Credentials;
import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Validator;
import com.wechat.pay.contrib.apache.httpclient.util.PemUtil;
import com.wechat.pay.v3.applyment.bean.info.ApplymentInfo;
import com.wechat.pay.v3.applyment.bean.info.BankAccountInfo;
import com.wechat.pay.v3.applyment.config.WxApiV3Config;
import com.wechat.pay.v3.applyment.util.JsonUtils;
import com.wechat.pay.v3.applyment.bean.result.ApplymentStatusResult;
import com.wechat.pay.v3.applyment.bean.result.BankAccountResult;
import com.wechat.pay.v3.applyment.service.ApiV3Service;
import com.wechat.pay.v3.applyment.validator.FieldEncryptFormat;
import org.apache.commons.codec.Charsets;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URI;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.Objects;

import static com.wechat.pay.v3.applyment.validator.ApiV3Validator.validateAndFormat;

/**
 * @author LYJ
 * @date 2021/1/15 16:33
 * @since 1.0
 */
public class ApiV3ServiceImpl implements ApiV3Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiV3ServiceImpl.class);

    /**
     * 测试AutoUpdateCertificatesVerifier的verify方法参数
     */
    private CloseableHttpClient httpClient;
    private AutoUpdateCertificatesVerifier verifier;
    private static final String WE_CHAT_PAY_SERIAL = "Wechatpay-Serial";


    private WxApiV3Config wxApiV3Config;
    private X509Certificate certificate;
    private PrivateKey privateKey;


    public ApiV3ServiceImpl(WxApiV3Config wxApiV3Config) {
        this.wxApiV3Config = wxApiV3Config;
        httpClientBuilder();
    }

    /**
     * 提交申请单
     *
     * @param applymentInfo applymentInfo
     * @return
     * @throws Exception
     */
    @Override
    public Map<String,String> applyment(ApplymentInfo applymentInfo) throws Exception {
        if (Objects.nonNull(validateAndFormat(applymentInfo))) {
           throw  new RuntimeException(validateAndFormat(applymentInfo));
        }
        //敏感字段加密
        FieldEncryptFormat.encryptField(applymentInfo, certificate);
        HttpPost httpPost = new HttpPost(APPLYMENT_URL);
        // 设置请求头
        setPostHeader(httpPost);
        String submitJson = JsonUtils.toString(applymentInfo);
        LOGGER.info("submit applymentInfo json---->\n" + submitJson);
        //防止中文乱码
        httpPost.setEntity(new StringEntity(submitJson, "UTF-8"));
        HttpResponse response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        LOGGER.info(" result source->{}", result);
        if (response.getStatusLine().getStatusCode() == 200) {
            LOGGER.info("result---->" + result);
            Map<String, String> map = JsonUtils.toMap(result, String.class, String.class);

            return map;
        } else {
            LOGGER.warn("result error---->" + result);
            return null;
        }
    }


    /**
     * 查询申请单状态
     *
     * @param businessCode
     * @return
     * @throws IOException
     */
    @Override
    public ApplymentStatusResult applymentStatus(String businessCode) throws IOException {
        HttpGet httpGet = new HttpGet(SEARCH_APPLY_STATUS_URL.replace("{business_code}", businessCode));
        // 设置请求头
        httpGet.addHeader("Content-Type", "application/json");
        httpGet.addHeader("Accept", "application/json");
        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        LOGGER.info(" result source->{}", result);
        if (response.getStatusLine().getStatusCode() == 200) {
            LOGGER.info("result---->" + result);
            ApplymentStatusResult statusResult = JsonUtils.toBean(result, ApplymentStatusResult.class);

            return statusResult;
        } else {
            LOGGER.warn("result error---->" + result);
            return null;
        }
    }

    /**
     * 修改结算帐号
     *
     * @param subMchId
     * @param bankAccountInfo
     * @return
     * @throws IOException
     */
    @Override
    public boolean changeSubBank(String subMchId, BankAccountInfo bankAccountInfo) throws Exception {
        HttpPost httpPost = new HttpPost(CHANGE_SUB_MCH_BANK_URL.replace("{sub_mchid}", subMchId));
        // 设置请求头
        setPostHeader(httpPost);
        String submitJson = JsonUtils.toString(bankAccountInfo);
        LOGGER.info("submit applymentInfo json---->\n" + submitJson);
        //防止中文乱码
        httpPost.setEntity(new StringEntity(submitJson, "UTF-8"));
        HttpResponse response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        LOGGER.info(" result source->{}", result);
        if (response.getStatusLine().getStatusCode() == 200) {
            LOGGER.info("result---->" + result);
            String string = JsonUtils.toString(result);
            return true;
        } else {
            LOGGER.warn("result error---->" + result);
            return false;
        }
    }

    /**
     * 查询结算账户
     *
     * @param subMchId
     * @return
     * @throws IOException
     */
    @Override
    public BankAccountResult querySubMch(String subMchId) throws IOException {
        HttpGet httpGet = new HttpGet(QUERY_SUB_MCH_BANK_URL.replace("{sub_mchid}", subMchId));
        // 设置请求头
        httpGet.addHeader("Content-Type", "application/json");
        httpGet.addHeader("Accept", "application/json");
        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        LOGGER.info(" result source->{}", result);
        if (response.getStatusLine().getStatusCode() == 200) {
            LOGGER.info("result---->" + result);
            return JsonUtils.toBean(result, BankAccountResult.class);
        } else {
            LOGGER.warn("result error---->" + result);
            return null;
        }
    }


    /**
     * 图片上传接口实现
     *
     * @param filePath
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, String> upload(String filePath) throws Exception {
        httpClientBuilder();
        File file = new File(filePath);
        Map<String, String> map = null;
        try (FileInputStream s1 = new FileInputStream(new File(filePath))) {
            String sha256 = DigestUtils.sha256Hex(s1);
            try (InputStream s2 = new FileInputStream(file)) {
                WechatPayUploadHttpPost request = new WechatPayUploadHttpPost.Builder(new URI(UPLOAD_FILE_URL))
                        .withImage(file.getName(), sha256, s2)
                        .build();

                CloseableHttpResponse response = httpClient.execute(request);
                try {
                    HttpEntity entity = response.getEntity();
                    if (Objects.nonNull(entity)) {
                        String responseEntityStr = EntityUtils.toString(entity);
                        LOGGER.info(responseEntityStr);
                        LOGGER.info("Response content length: " + entity.getContentLength());
                        map = JsonUtils.toMap(responseEntityStr, String.class, String.class);
                    } else {
                        LOGGER.error("图片上传失败");
                    }
                } finally {
                    response.close();
                    httpClient.close();
                }
            }
        }
        return map;
    }



    private void setPostHeader(HttpPost httpPost) {
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.addHeader("Accept", "application/json");
        httpPost.addHeader(WE_CHAT_PAY_SERIAL, certificate.getSerialNumber().toString(16).toUpperCase());
        LOGGER.info(WE_CHAT_PAY_SERIAL+"--->" + certificate.getSerialNumber().toString(16).toUpperCase());
    }




    /**
     * 自动更新验证签名器获取httpClient
     *
     * @throws UnsupportedEncodingException
     */
    private void httpClient() throws UnsupportedEncodingException {
        PrivateKey merchantPrivateKey = null;
        try {
            merchantPrivateKey = PemUtil.loadPrivateKey(new FileInputStream(new File(wxApiV3Config.getMchPrivateKeyFilePath())));
        } catch (FileNotFoundException e) {
            LOGGER.error("私钥文件传读取异常", e);
            e.printStackTrace();
        }
        //使用自动更新的签名验证器，不需要传入证书
        verifier = new AutoUpdateCertificatesVerifier(
                new WechatPay2Credentials(wxApiV3Config.getMchId(), new PrivateKeySigner(wxApiV3Config.getMchSerialNo(), merchantPrivateKey)),
                wxApiV3Config.getApiV3Key().getBytes(Charsets.UTF_8));
        this.httpClient = WechatPayHttpClientBuilder.create()
                .withMerchant(wxApiV3Config.getMchId(), wxApiV3Config.getMchSerialNo(), merchantPrivateKey)
                .withValidator(new WechatPay2Validator(verifier))
                .build();
    }

    /**
     * 获取自动更新验证签名器httpClient
     */
    private void httpClientBuilder() {
        try {
            if (Objects.isNull(wxApiV3Config)) {
                throw new RuntimeException("wxApiV3Config配置为空");
            }
            if (Objects.isNull(wxApiV3Config.getMchId())) {
                throw new RuntimeException("请配置商户号");
            }
            if (Objects.isNull(wxApiV3Config.getMchSerialNo())) {
                throw new RuntimeException("请配置证书序列号");
            }
            if (Objects.isNull(wxApiV3Config.getApiV3Key())) {
                throw new RuntimeException("请配置ApiV3key");
            }
            if (Objects.isNull(wxApiV3Config.getWeChatPayCertificateFilePath())) {
                throw new RuntimeException("请配置微信平台证书路径");
            }
            if (Objects.isNull(wxApiV3Config.getMchPrivateKeyFilePath())) {
                throw new RuntimeException("请配置私钥文件路径");
            }
            this.certificate = PemUtil.loadCertificate(new FileInputStream(new File(wxApiV3Config.getWeChatPayCertificateFilePath())));
            this.privateKey = PemUtil.loadPrivateKey(new FileInputStream(new File(wxApiV3Config.getMchPrivateKeyFilePath())));
            verifier = new AutoUpdateCertificatesVerifier(
                    new WechatPay2Credentials(wxApiV3Config.getMchId(), new PrivateKeySigner(wxApiV3Config.getMchSerialNo(), this.privateKey)),
                    wxApiV3Config.getApiV3Key().getBytes("utf-8"));
            WechatPayHttpClientBuilder builder = WechatPayHttpClientBuilder.create()
                    .withMerchant(wxApiV3Config.getMchId(), wxApiV3Config.getMchSerialNo(), this.privateKey)
                    .withValidator(new WechatPay2Validator(verifier));
            // 通过WechatPayHttpClientBuilder构造的HttpClient，会自动的处理签名和验签，并进行证书自动更新
            this.httpClient = builder.build();
        } catch (Exception e) {
            LOGGER.error("构建httpClient出错", e);
            e.printStackTrace();
        }
    }



}
