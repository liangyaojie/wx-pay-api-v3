package com.wechat.pay.v3.transactions.bean.directly;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wechat.pay.v3.transactions.bean.base.WxBaseResult;

/**
 * 直连商户微信订单查询结果
 *
 * @author LYJ
 * @date 2021/1/23 15:34
 * @since 1.0
 */
public class WxDirectlyQueryResult extends WxBaseResult {


    /**
     * 公众号ID
     * 必填：否
     */
    @JsonProperty("appid")
    @JSONField(name = "appid")
    private String appId;

    /**
     * 商户号
     * 必填：是
     */
    @JsonProperty("mchid")
    @JSONField(name = "mchid")
    private String mchId;

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

    @Override
    public String toString() {
        return "WxDirectlyQueryResult{" +
                "appId='" + appId + '\'' +
                ", mchId='" + mchId + '\'' +
                '}';
    }
}
