package com.wechat.pay.v3.transactions.bean.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 微信支付通用请求参数
 *
 * @author LYJ
 * @date 2021/1/22 17:36
 * @since 1.0
 */
public class WxBaseRequest {

    /**
     * 商品描述
     * 必填：是
     */
    @JsonProperty("description")
    @JSONField(name = "description")
    private String description;

    /**
     * 商户订单号
     * 必填：是
     */
    @JsonProperty("out_trade_no")
    @JSONField(name = "out_trade_no")
    private String outTradeNo;

    /**
     * 交易结束时间
     * 必填：否
     */
    @JsonProperty("time_expire")
    @JSONField(name = "time_expire")
    private String timeExpire;

    /**
     * 附加数据
     * 必填：否
     */
    @JsonProperty("attach")
    @JSONField(name = "attach")
    private String attach;

    /**
     * 通知地址
     * 必填：是
     */
    @JsonProperty("notify_url")
    @JSONField(name = "notify_url")
    private String notifyUrl;

    /**
     * 订单优惠标记
     * 必填：否
     */
    @JsonProperty("goods_tag")
    @JSONField(name = "goods_tag")
    private String goodsTag;

    /**
     * 结算信息
     * 必填：否
     */
    @JsonProperty("settle_info")
    @JSONField(name = "settle_info")
    private WxSettleInfo settleInfo;

    /**
     * 订单金额
     * 必填：是
     */
    @JsonProperty("amount")
    @JSONField(name = "amount")
    private WxAmount amount;

    /**
     * 优惠功能
     * 必填：否
     */
    @JsonProperty("detail")
    @JSONField(name = "detail")
    private WxDetail detail;

    /**
     * 场景信息
     * 必填：是
     */
    @JsonProperty("scene_info")
    @JSONField(name = "scene_info")
    private WxSceneInfo sceneInfo;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTimeExpire() {
        return timeExpire;
    }

    public void setTimeExpire(String timeExpire) {
        this.timeExpire = timeExpire;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    public WxSettleInfo getSettleInfo() {
        return settleInfo;
    }

    public void setSettleInfo(WxSettleInfo settleInfo) {
        this.settleInfo = settleInfo;
    }

    public WxAmount getAmount() {
        return amount;
    }

    public void setAmount(WxAmount amount) {
        this.amount = amount;
    }

    public WxDetail getDetail() {
        return detail;
    }

    public void setDetail(WxDetail detail) {
        this.detail = detail;
    }

    public WxSceneInfo getSceneInfo() {
        return sceneInfo;
    }

    public void setSceneInfo(WxSceneInfo sceneInfo) {
        this.sceneInfo = sceneInfo;
    }

    @Override
    public String toString() {
        return "WxBaseRequest{" +
                "description='" + description + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", timeExpire='" + timeExpire + '\'' +
                ", attach='" + attach + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                ", goodsTag='" + goodsTag + '\'' +
                ", settleInfo=" + settleInfo +
                ", amount=" + amount +
                ", detail=" + detail +
                ", sceneInfo=" + sceneInfo +
                '}';
    }
}
