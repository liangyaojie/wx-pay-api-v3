package com.wechat.pay.v3.transactions.bean.directly;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 支付者信息
 *
 * @author LYJ
 * @date 2021/1/23 10:06
 * @since 1.0
 */
public class WxDirectlyPayer {



    /**
     * 用户服务标识
     */
    @JsonProperty("openid")
    @JSONField(name = "openid")
    private String openId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Override
    public String toString() {
        return "WxDirectlyPayer{" +
                "openId='" + openId + '\'' +
                '}';
    }
}
