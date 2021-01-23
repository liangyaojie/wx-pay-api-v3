package com.wechat.pay.v3.transactions.bean.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 优惠功能
 *
 * @author LYJ
 * @date 2021/1/22 10:03
 * @since 1.0
 */
public class WxDetail {


    /**
     * 订单原价
     * 必填：否
     */
    @JsonProperty("cost_price")
    @JSONField(name = "cost_price")
    private Integer costPrice;

    /**
     * 商品小票ID
     * 必填：否
     */
    @JsonProperty("invoice_id")
    @JSONField(name = "invoice_id")
    private String invoiceId;

    /**
     * 商品小票ID
     * 必填：否
     */
    @JsonProperty("goods_detail")
    @JSONField(name = "goods_detail")
    private List<WxGoodsDetail> goodsDetail;

    public Integer getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Integer costPrice) {
        this.costPrice = costPrice;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public List<WxGoodsDetail> getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(List<WxGoodsDetail> goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    @Override
    public String toString() {
        return "WxDetail{" +
                "costPrice=" + costPrice +
                ", invoiceId='" + invoiceId + '\'' +
                ", goodsDetail=" + goodsDetail +
                '}';
    }
}
