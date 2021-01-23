package com.wechat.pay.v3.transactions.bean.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 订单金额
 *
 * @author LYJ
 * @date 2021/1/22 10:00
 * @since 1.0
 */
public class WxAmount {

    /**
     * 订单总金额，单位为分
     * 必填；是
     */
    @JsonProperty("total")
    @JSONField(name = "total")
    private Integer total;

    /**
     * 用户支付金额，单位为分
     * 必填；否
     */
    @JsonProperty("payer_total")
    @JSONField(name = "payer_total")
    private Integer payerTotal;

    /**
     * 货币类型
     * 必填；否
     */
    @JsonProperty("currency")
    @JSONField(name = "currency")
    private String currency;
    /**
     * 用户支付币种
     * 必填；否
     */
    @JsonProperty("payer_currency")
    @JSONField(name = "payer_currency")
    private String payerCurrency;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPayerTotal() {
        return payerTotal;
    }

    public void setPayerTotal(Integer payerTotal) {
        this.payerTotal = payerTotal;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPayerCurrency() {
        return payerCurrency;
    }

    public void setPayerCurrency(String payerCurrency) {
        this.payerCurrency = payerCurrency;
    }

    @Override
    public String toString() {
        return "WxAmount{" +
                "total=" + total +
                ", payerTotal=" + payerTotal +
                ", currency='" + currency + '\'' +
                ", payerCurrency='" + payerCurrency + '\'' +
                '}';
    }
}
