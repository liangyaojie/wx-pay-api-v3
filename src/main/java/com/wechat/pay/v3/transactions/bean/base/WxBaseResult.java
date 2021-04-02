package com.wechat.pay.v3.transactions.bean.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 微信订单查询结果基础信息
 *
 * @author LYJ
 * @date 2021/1/23 15:27
 * @since 1.0
 */
public class WxBaseResult {

    /**
     * 商户订单号
     * 必填：是
     */
    @JsonProperty("out_trade_no")
    @JSONField(name = "out_trade_no")
    protected String outTradeNo;

    /**
     * 微信支付订单号
     * 必填：否
     */
    @JsonProperty("transaction_id")
    @JSONField(name = "transaction_id")
    protected String transactionId;


    /**
     * 交易类型
     * 必填：否
     */
    @JsonProperty("trade_type")
    @JSONField(name = "trade_type")
    protected String tradeType;

    /**
     * 交易状态
     * 必填：是
     */
    @JsonProperty("trade_state")
    @JSONField(name = "trade_state")
    protected String tradeState;

    /**
     * 交易状态描述
     * 必填：是
     */
    @JsonProperty("trade_state_desc")
    @JSONField(name = "trade_state_desc")
    protected String tradeStateDesc;


    /**
     * 付款银行
     * 必填：否
     */
    @JsonProperty("bank_type")
    @JSONField(name = "bank_type")
    protected String bankType;


    /**
     * 附加数据
     * 必填：否
     */
    @JsonProperty("attach")
    @JSONField(name = "attach")
    protected String attach;


    /**
     * 支付完成时间
     * 必填：否
     */
    @JsonProperty("success_time")
    @JSONField(name = "success_time")
    protected String successTime;



    /**
     * 支付者
     * 必填：否
     */
    @JsonProperty("payer")
    @JSONField(name = "payer")
    protected WxPayer payer;


    /**
     * 订单金额
     * 必填：否
     */
    @JsonProperty("amount")
    @JSONField(name = "amount")
    protected WxAmount amount;

    /**
     * 场景信息
     * 必填：否
     */
    @JsonProperty("scene_info")
    @JSONField(name = "scene_info")
    protected WxSceneInfo sceneInfo;

    /**
     * 优惠功能
     * 必填：否
     */
    @JsonProperty("promotion_detail")
    @JSONField(name = "promotion_detail")
    protected List<WxPromotionDetail> promotionDetail;


    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getTradeState() {
        return tradeState;
    }

    public void setTradeState(String tradeState) {
        this.tradeState = tradeState;
    }

    public String getTradeStateDesc() {
        return tradeStateDesc;
    }

    public void setTradeStateDesc(String tradeStateDesc) {
        this.tradeStateDesc = tradeStateDesc;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(String successTime) {
        this.successTime = successTime;
    }


    public WxPayer getPayer() {
        return payer;
    }

    public void setPayer(WxPayer payer) {
        this.payer = payer;
    }

    public WxAmount getAmount() {
        return amount;
    }

    public void setAmount(WxAmount amount) {
        this.amount = amount;
    }

    public WxSceneInfo getSceneInfo() {
        return sceneInfo;
    }

    public void setSceneInfo(WxSceneInfo sceneInfo) {
        this.sceneInfo = sceneInfo;
    }

    public List<WxPromotionDetail> getPromotionDetail() {
        return promotionDetail;
    }

    public void setPromotionDetail(List<WxPromotionDetail> promotionDetail) {
        this.promotionDetail = promotionDetail;
    }

    @Override
    public String toString() {
        return "WxBaseResult{" +
                "outTradeNo='" + outTradeNo + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", tradeType='" + tradeType + '\'' +
                ", tradeState='" + tradeState + '\'' +
                ", tradeStateDesc='" + tradeStateDesc + '\'' +
                ", bankType='" + bankType + '\'' +
                ", attach='" + attach + '\'' +
                ", successTime='" + successTime + '\'' +
                ", payer=" + payer +
                ", amount=" + amount +
                ", sceneInfo=" + sceneInfo +
                ", promotionDetail=" + promotionDetail +
                '}';
    }
}
