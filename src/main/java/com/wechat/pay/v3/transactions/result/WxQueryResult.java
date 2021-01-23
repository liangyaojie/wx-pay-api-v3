package com.wechat.pay.v3.transactions.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wechat.pay.v3.transactions.bean.base.WxAmount;
import com.wechat.pay.v3.transactions.bean.base.WxPayer;
import com.wechat.pay.v3.transactions.bean.base.WxPromotionDetail;
import com.wechat.pay.v3.transactions.bean.base.WxSceneInfo;

import java.util.List;

/**
 * 微信订单查询结果
 *
 * @author LYJ
 * @date 2021/1/23 9:46
 * @since 1.0
 */
public class WxQueryResult {


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
     * 商户订单号
     * 必填：是
     */
    @JsonProperty("out_trade_no")
    @JSONField(name = "out_trade_no")
    private String outTradeNo;

    /**
     * 微信支付订单号
     * 必填：否
     */
    @JsonProperty("transaction_id")
    @JSONField(name = "transaction_id")
    private String transactionId;


    /**
     * 交易类型
     * 必填：否
     */
    @JsonProperty("trade_type")
    @JSONField(name = "trade_type")
    private String tradeType;

    /**
     * 交易状态
     * 必填：是
     */
    @JsonProperty("trade_state")
    @JSONField(name = "trade_state")
    private String tradeState;

    /**
     * 交易状态描述
     * 必填：是
     */
    @JsonProperty("trade_state_desc")
    @JSONField(name = "trade_state_desc")
    private String tradeStateDesc;


    /**
     * 付款银行
     * 必填：否
     */
    @JsonProperty("bank_type")
    @JSONField(name = "bank_type")
    private String bankType;


    /**
     * 附加数据
     * 必填：否
     */
    @JsonProperty("attach")
    @JSONField(name = "attach")
    private String attach;


    /**
     * 支付完成时间
     * 必填：否
     */
    @JsonProperty("success_time")
    @JSONField(name = "success_time")
    private String successTime;


    /**
     * 支付者
     * 必填：是
     */
    @JsonProperty("payer")
    @JSONField(name = "payer")
    private WxPayer payer;


    /**
     * 订单金额
     * 必填：否
     */
    @JsonProperty("amount")
    @JSONField(name = "amount")
    private WxAmount amount;

    /**
     * 场景信息
     * 必填：否
     */
    @JsonProperty("scene_info")
    @JSONField(name = "scene_info")
    private WxSceneInfo sceneInfo;

    /**
     * 优惠功能
     * 必填：否
     */
    @JsonProperty("promotion_detail")
    @JSONField(name = "promotion_detail")
    private List<WxPromotionDetail> promotionDetail;


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
        return "WxQueryResult{" +
                "spAppId='" + spAppId + '\'' +
                ", spMchId='" + spMchId + '\'' +
                ", subAppId='" + subAppId + '\'' +
                ", subMchId='" + subMchId + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
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
