package com.wechat.pay.v3.transactions.bean.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 优惠功能，享受优惠时返回字段
 *
 * @author LYJ
 * @date 2021/1/23 10:32
 * @since 1.0
 */
public class WxPromotionDetail {

    /**
     * 券ID
     */
    @JsonProperty("coupon_id")
    @JSONField(name = "coupon_id")
    private String couponId;

    /**
     * 优惠名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    private String name;

    /**
     * 优惠范围
     */
    @JsonProperty("scope")
    @JSONField(name = "scope")
    private String scope;

    /**
     * 优惠类型
     */
    @JsonProperty("type")
    @JSONField(name = "type")
    private String type;

    /**
     * 优惠券面额
     */
    @JsonProperty("amount")
    @JSONField(name = "amount")
    private Integer amount;

    /**
     * 活动ID
     */
    @JsonProperty("stock_id")
    @JSONField(name = "stock_id")
    private String stockId;

    /**
     * 微信出资
     */
    @JsonProperty("wechatpay_contribute")
    @JSONField(name = "wechatpay_contribute")
    private Integer weChatPayContribute;

    /**
     * 商户出资
     */
    @JsonProperty("merchant_contribute")
    @JSONField(name = "merchant_contribute")
    private Integer merchantContribute;

    /**
     * 其他出资
     */
    @JsonProperty("other_contribute")
    @JSONField(name = "other_contribute")
    private Integer otherContribute;


    /**
     * 单品列表
     */
    @JsonProperty("goods_detail")
    @JSONField(name = "goods_detail")
    private List<WxGoodsDetail> goodsDetail;


    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public Integer getWeChatPayContribute() {
        return weChatPayContribute;
    }

    public void setWeChatPayContribute(Integer weChatPayContribute) {
        this.weChatPayContribute = weChatPayContribute;
    }

    public Integer getMerchantContribute() {
        return merchantContribute;
    }

    public void setMerchantContribute(Integer merchantContribute) {
        this.merchantContribute = merchantContribute;
    }

    public Integer getOtherContribute() {
        return otherContribute;
    }

    public void setOtherContribute(Integer otherContribute) {
        this.otherContribute = otherContribute;
    }

    public List<WxGoodsDetail> getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(List<WxGoodsDetail> goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    @Override
    public String toString() {
        return "WxPromotionDetail{" +
                "couponId='" + couponId + '\'' +
                ", name='" + name + '\'' +
                ", scope='" + scope + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", stockId='" + stockId + '\'' +
                ", weChatPayContribute=" + weChatPayContribute +
                ", merchantContribute=" + merchantContribute +
                ", otherContribute=" + otherContribute +
                ", goodsDetail=" + goodsDetail +
                '}';
    }
}
