package com.wechat.pay.v3.applyment.bean.info;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 公众号场景
 *
 * @author LYJ
 * @date 2021/1/15 15:26
 * @since 1.0
 */
public class MpInfo {

    /**
     * 服务商公众号APPID
     * 与商家公众号appId二选一
     */
    @JsonProperty("mp_appid")
    @JSONField(name = "mp_appid")
    private String mpAppId;

    /**
     * 商家公众号APPID
     * 与服务商公众号appId二选一
     */
    @JsonProperty("mp_sub_appid")
    @JSONField(name = "mp_sub_appid")
    private String mpSubAppId;

    /**
     * 条件选填
     * 公众号页面截图
     */
    @JsonProperty("mp_pics")
    @JSONField(name = "mp_pics")
    private List<String> mpPics;

    public String getMpAppId() {
        return mpAppId;
    }

    public void setMpAppId(String mpAppId) {
        this.mpAppId = mpAppId;
    }

    public String getMpSubAppId() {
        return mpSubAppId;
    }

    public void setMpSubAppId(String mpSubAppId) {
        this.mpSubAppId = mpSubAppId;
    }

    public List<String> getMpPics() {
        return mpPics;
    }

    public void setMpPics(List<String> mpPics) {
        this.mpPics = mpPics;
    }
}
