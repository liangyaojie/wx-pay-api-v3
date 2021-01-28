package com.wechat.pay.v3.applyment.bean.info;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    @JsonProperty("domain")
    @JSONField(name = "domain")
    private String domain;

    /**
     * 非必填
     * 网站授权函
     */
    @JsonProperty("web_authorisation")
    @JSONField(name = "web_authorisation")
    private String webAuthorisation;

    /**
     * 非必填
     * 互联网网站对应的商家APPID
     */
    @JsonProperty("web_appid")
    @JSONField(name = "web_appid")
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
