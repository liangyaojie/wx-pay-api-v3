package com.wechat.pay.v3.applyment.bean.info;

/**
 * 互联网网站场景
 *
 * @author LYJ
 * @date 2021/1/15 15:34
 * @since 1.0
 */
public class WebInfo {

    /**
     * 必填
     * 互联网网站域名
     */
    private String domain;

    /**
     * 非必填
     * 网站授权函
     */
    private String webAuthorisation;

    /**
     * 非必填
     * 互联网网站对应的商家APPID
     */
    private String webAppId;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getWebAuthorisation() {
        return webAuthorisation;
    }

    public void setWebAuthorisation(String webAuthorisation) {
        this.webAuthorisation = webAuthorisation;
    }

    public String getWebAppId() {
        return webAppId;
    }

    public void setWebAppId(String webAppId) {
        this.webAppId = webAppId;
    }
}
