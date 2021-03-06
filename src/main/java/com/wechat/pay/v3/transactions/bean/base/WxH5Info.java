package com.wechat.pay.v3.transactions.bean.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * H5场景信息
 *
 * @author LYJ
 * @date 2021/1/22 10:18
 * @since 1.0
 */
public class WxH5Info {


    /**
     * 场景类型
     * 必填；是
     */
    @JsonProperty("type")
    @JSONField(name = "type")
    protected String type;

    /**
     * 应用名称
     * 必填；否
     */
    @JsonProperty("app_name")
    @JSONField(name = "app_name")
    protected String appName;

    /**
     * 网站URL
     * 必填；否
     */
    @JsonProperty("app_url")
    @JSONField(name = "app_url")
    protected String appUrl;

    /**
     * iOS平台BundleID
     * 必填；否
     */
    @JsonProperty("bundle_id")
    @JSONField(name = "bundle_id")
    protected String bundleId;

    /**
     * Android平台PackageName
     * 必填；否
     */
    @JsonProperty("package_name")
    @JSONField(name = "package_name")
    protected String packageName;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public String getBundleId() {
        return bundleId;
    }

    public void setBundleId(String bundleId) {
        this.bundleId = bundleId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    @Override
    public String toString() {
        return "WxH5Info{" +
                "type='" + type + '\'' +
                ", appName='" + appName + '\'' +
                ", appUrl='" + appUrl + '\'' +
                ", bundleId='" + bundleId + '\'' +
                ", packageName='" + packageName + '\'' +
                '}';
    }
}
