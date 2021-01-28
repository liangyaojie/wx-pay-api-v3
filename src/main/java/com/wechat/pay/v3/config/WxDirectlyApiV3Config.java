package com.wechat.pay.v3.config;

/**
 * 直连商户微信支付信息配置
 *
 * @author LYJ
 * @date 2021/1/28 9:15
 * @since 1.0
 */
public class WxDirectlyApiV3Config {

    /**
     * 商户公众号ID
     */
    private String appId;
    /**
     * 商户号
     */
    private String mchId;

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


    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
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
