package com.wechat.pay.v3.transactions.bean.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 支付者信息
 *
 * @author LYJ
 * @date 2021/1/23 10:06
 * @since 1.0
 */
public class WxPayer {

    /**
     * 用户服务标识
     */
    @JsonProperty("sp_openid")
    @JSONField(name = "sp_openid")
    private String spOpenId;

    /**
     * 用户子标识
     */
    @JsonProperty("sub_openid")
    @JSONField(name = "sub_openid")
    private String subOpenId;

    public String getSpOpenId() {
        return spOpenId;
    }

    public void setSpOpenId(String spOpenId) {
        this.spOpenId = spOpenId;
    }

    public String getSubOpenId() {
        return subOpenId;
    }

    public void setSubOpenId(String subOpenId) {
        this.subOpenId = subOpenId;
    }

    @Override
    public String toString() {
        return "WxPayer{" +
                "spOpenId='" + spOpenId + '\'' +
                ", subOpenId='" + subOpenId + '\'' +
                '}';
    }
}
