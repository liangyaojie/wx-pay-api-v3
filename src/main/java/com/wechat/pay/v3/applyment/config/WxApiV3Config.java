package com.wechat.pay.v3.applyment.config;

/**
 * @author LYJ
 * @date 2021/1/18 17:12
 * @since 1.0
 */
public class WxApiV3Config {
    /**
     * 服务商户号
     */
    private  String mchId ;
    /**
     * 商户证书序列号
     */
    private  String mchSerialNo;
    /**
     * apiV3密钥
     */
    private  String apiV3Key;


    /**
     * 证书文件路径 .p12
     */
    private String weChatPayCertificateFilePath;
    /**
     * 私钥文件路径  key.pem
     */
    private String mchPrivateKeyFilePath;


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
}
