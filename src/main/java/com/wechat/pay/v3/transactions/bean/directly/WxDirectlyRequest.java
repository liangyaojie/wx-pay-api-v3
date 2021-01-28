package com.wechat.pay.v3.transactions.bean.directly;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wechat.pay.v3.transactions.bean.base.WxBaseRequest;

/**
 * 直连商户支付请求参数
 *
 * @author LYJ
 * @date 2021/1/22 17:33
 * @since 1.0
 */
public class WxDirectlyRequest extends WxBaseRequest {

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


    /**
     * 支付者
     * 必填：是
     */
    @JsonProperty("payer")
    @JSONField(name = "payer")
    private WxDirectlyPayer payer;

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

    public WxDirectlyPayer getPayer() {
        return payer;
    }

    public void setPayer(WxDirectlyPayer payer) {
        this.payer = payer;
    }

    @Override
    public String toString() {
        return "WxDirectlyRequest{" +
                "appId='" + appId + '\'' +
                ", mchId='" + mchId + '\'' +
                ", payer=" + payer +
                '}';
    }
}
