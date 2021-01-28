package com.wechat.pay.v3.applyment.bean.info;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wechat.pay.v3.applyment.bean.enumbean.SalesScenesType;

import java.util.List;

/**
 * 经营场景
 *
 * @author LYJ
 * @date 2021/1/15 15:08
 * @since 1.0
 */
public class SalesInfo {


    /**
     * 必填
     * 经营场景类型
     */
    @JsonProperty("sales_scenes_type")
    @JSONField(name = "sales_scenes_type")
    private List<SalesScenesType> salesScenesType;


    /**
     * 条件选填
     * 线下门店场景
     */
    @JsonProperty("biz_store_info")
    @JSONField(name = "biz_store_info")
    private BizStoreInfo bizStoreInfo;

    /**
     * 条件选填
     * 公众号场景
     */
    @JsonProperty("mp_info")
    @JSONField(name = "mp_info")
    private MpInfo mpInfo;

    /**
     * 条件选填
     * 小程序场景
     */
    @JsonProperty("mini_program_info")
    @JSONField(name = "mini_program_info")
    private MiniProgramInfo miniProgramInfo;

    /**
     * 条件选填
     * APP场景
     */
    @JsonProperty("app_info")
    @JSONField(name = "app_info")
    private WxAppInfo appInfo;

    /**
     * 条件选填
     * 互联网网站场景
     */
    @JsonProperty("web_info")
    @JSONField(name = "web_info")
    private WebInfo webInfo;

    /**
     * 条件选填
     * 企业微信场景
     */
    @JsonProperty("wework_info")
    @JSONField(name = "wework_info")
    private WeWorkInfo weworkInfo;

    public List<SalesScenesType> getSalesScenesType() {
        return salesScenesType;
    }

    public void setSalesScenesType(List<SalesScenesType> salesScenesType) {
        this.salesScenesType = salesScenesType;
    }

    public MiniProgramInfo getMiniProgramInfo() {
        return miniProgramInfo;
    }

    public void setMiniProgramInfo(MiniProgramInfo miniProgramInfo) {
        this.miniProgramInfo = miniProgramInfo;
    }

    public BizStoreInfo getBizStoreInfo() {
        return bizStoreInfo;
    }

    public void setBizStoreInfo(BizStoreInfo bizStoreInfo) {
        this.bizStoreInfo = bizStoreInfo;
    }

    public MpInfo getMpInfo() {
        return mpInfo;
    }

    public void setMpInfo(MpInfo mpInfo) {
        this.mpInfo = mpInfo;
    }

    public WxAppInfo getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(WxAppInfo appInfo) {
        this.appInfo = appInfo;
    }

    public WebInfo getWebInfo() {
        return webInfo;
    }

    public void setWebInfo(WebInfo webInfo) {
        this.webInfo = webInfo;
    }

    public WeWorkInfo getWeworkInfo() {
        return weworkInfo;
    }

    public void setWeworkInfo(WeWorkInfo weworkInfo) {
        this.weworkInfo = weworkInfo;
    }
}
