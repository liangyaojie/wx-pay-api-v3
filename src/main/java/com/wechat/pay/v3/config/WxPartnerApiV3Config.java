package com.wechat.pay.v3.config;

/**
 * @author LYJ
 * @date 2021/1/18 17:12
 * @since 1.0
 */
public class WxPartnerApiV3Config {
    /**
     * 服务商公众号ID
     */
    private String spAppId;

    /**
     * 服务商户号
     */
    private String spMchId;
    /**
     * 子商户公众号ID
     */
    private String subAppId;
    /**
     * 子商户号
     */
    private String subMchId;
    /**
     * 商户证书序列号
     */
    private String mchSerialNo;
    /**
     * apiV3密钥
     */
    private String apiV3Key;

    /**
     * 证书文件路径 .p12
     */
    private String weChatPayCertificateFilePath;
    /**
     * 私钥文件路径  key.pem
     */
    private String mchPrivateKeyFilePath;

    /**
     * 微信回调地址notifyUrl
     */
    private String notifyUrl;


    public String getSpAppId() {
        return spAppId;
    }

    public void setSpAppId(String spAppId) {
        this.spAppId = spAppId;
    }

    public String getSpMchId() {
        return spMchId;
    }

    public void setSpMchId(String spMchId) {
        this.spMchId = spMchId;
    }

    public String getSubAppId() {
        return subAppId;
    }

    public void setSubAppId(String subAppId) {
        this.subAppId = subAppId;
    }

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
    }

    public String getMchSerialNo() {
        return mchSerialNo;
    }

    public void setMchSerialNo(String mchSerialNo) {
        this.mchSerialNo = mchSerialNo;
    }

    public String getApiV3Key() {
        return apiV3Key;
    }

    public void setApiV3Key(String apiV3Key) {
        this.apiV3Key = apiV3Key;
    }

    public String getWeChatPayCertificateFilePath() {
        return weChatPayCertificateFilePath;
    }

    public void setWeChatPayCertificateFilePath(String weChatPayCertificateFilePath) {
        this.weChatPayCertificateFilePath = weChatPayCertificateFilePath;
    }

    public String getMchPrivateKeyFilePath() {
        return mchPrivateKeyFilePath;
    }

    public void setMchPrivateKeyFilePath(String mchPrivateKeyFilePath) {
        this.mchPrivateKeyFilePath = mchPrivateKeyFilePath;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
}
