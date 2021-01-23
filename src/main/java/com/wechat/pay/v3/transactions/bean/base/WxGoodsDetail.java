package com.wechat.pay.v3.transactions.bean.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 单品列表
 *
 * @author LYJ
 * @date 2021/1/22 10:07
 * @since 1.0
 */
public class WxGoodsDetail {

    /**
     * 商户侧商品编码
     * 必填；是
     */
    @JsonProperty("merchant_goods_id")
    @JSONField(name = "merchant_goods_id")
    private String merchantGoodsId;


    /**
     * 微信侧商品编码
     * 必填；否
     */
    @JsonProperty("wechatpay_goods_id")
    @JSONField(name = "wechatpay_goods_id")
    private String weChatPayGoodsId;

    /**
     * 商品名称
     * 必填；否
     */
    @JsonProperty("goods_name")
    @JSONField(name = "goods_name")
    private String goodsName;

    /**
     * 商品数量
     * 必填；是
     */
    @JsonProperty("quantity")
    @JSONField(name = "quantity")
    private String quantity;

    /**
     * 商品单价
     * 必填；是
     */
    @JsonProperty("unit_price")
    @JSONField(name = "unit_price")
    private String unitPrice;

    /**
     * 商品优惠金额
     */
    @JsonProperty("discount_amount")
    @JSONField(name = "discount_amount")
    private String discountAmount;

    /**
     * 商品备注
     */
    @JsonProperty("goods_remark")
    @JSONField(name = "goods_remark")
    private String goodsRemark;

    public String getMerchantGoodsId() {
        return merchantGoodsId;
    }

    public void setMerchantGoodsId(String merchantGoodsId) {
        this.merchantGoodsId = merchantGoodsId;
    }

    public String getWeChatPayGoodsId() {
        return weChatPayGoodsId;
    }

    public void setWeChatPayGoodsId(String weChatPayGoodsId) {
        this.weChatPayGoodsId = weChatPayGoodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getGoodsRemark() {
        return goodsRemark;
    }

    public void setGoodsRemark(String goodsRemark) {
        this.goodsRemark = goodsRemark;
    }

    @Override
    public String toString() {
        return "WxGoodsDetail{" +
                "merchantGoodsId='" + merchantGoodsId + '\'' +
                ", weChatPayGoodsId='" + weChatPayGoodsId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", quantity='" + quantity + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                ", discountAmount='" + discountAmount + '\'' +
                ", goodsRemark='" + goodsRemark + '\'' +
                '}';
    }
}
