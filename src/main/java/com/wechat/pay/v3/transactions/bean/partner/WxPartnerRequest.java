package com.wechat.pay.v3.transactions.bean.partner;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wechat.pay.v3.transactions.bean.base.WxBaseRequest;

/**
 * 服务商请求参数
 *
 * @author LYJ
 * @date 2021/1/22 9:46
 * @since 1.0
 */
public class WxPartnerRequest extends WxBaseRequest {


    /**
     * 服务商公众号ID
     * 必填：是
     */
    @JsonProperty("sp_appid")
    @JSONField(name = "sp_appid")
    private String spAppId;


    /**
     * 服务商户号
     * 必填：是
     */
    @JsonProperty("sp_mchid")
    @JSONField(name = "sp_mchid")
    private String spMchId;

    /**
     * 子商户公众号ID
     * 必填：否
     */
    @JsonProperty("sub_appid")
    @JSONField(name = "sub_appid")
    private String subAppId;

    /**
     * 子商户号
     * 必填：是
     */
    @JsonProperty("sub_mchid")
    @JSONField(name = "sub_mchid")
    private String subMchId;



    /**
     * 支付者
     * 必填：是
     */
    @JsonProperty("payer")
    @JSONField(name = "payer")
    private WxPartnerPayer payer;


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

    public WxPartnerPayer getPayer() {
        return payer;
    }

    public void setPayer(WxPartnerPayer payer) {
        this.payer = payer;
    }

    @Override
    public String toString() {
        return "WxPartnerRequest{" +
                "spAppId='" + spAppId + '\'' +
                ", spMchId='" + spMchId + '\'' +
                ", subAppId='" + subAppId + '\'' +
                ", subMchId='" + subMchId + '\'' +
                ", payer=" + payer +
                '}';
    }
}
