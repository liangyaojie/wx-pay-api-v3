package com.wechat.pay.v3.transactions.bean.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 结算信息
 *
 * @author LYJ
 * @date 2021/1/22 9:58
 * @since 1.0
 */
public class WxSettleInfo {

    /**
     * 是否指定分账
     */
    @JsonProperty("profit_sharing")
    @JSONField(name = "profit_sharing")
    private boolean profitSharing;
}
