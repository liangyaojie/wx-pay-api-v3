package com.wechat.pay.v3.applyment.bean.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wechat.pay.v3.applyment.bean.enumbean.ApplymentStateType;

import java.util.List;

/**
 * 查询申请状态返回参数
 *
 * @author abel lee
 * @create 2020-06-03 12:01
 **/
public class ApplymentStatusResult {


    /**
     * 业务申请编号
     */
    @JsonProperty("business_code")
    private String businessCode;


    /**
     * 微信支付申请单号
     */
    @JsonProperty("applyment_id")
    private String applymentId;


    /**
     * 电商平台二级特约商户号
     */
    @JsonProperty("sub_mchid")
    private String subMchId;


    /**
     * 超级管理员签约链接
     */
    @JsonProperty("sign_url")
    private String signUrl;

    /**
     * 申请单状态
     */
    @JsonProperty("applyment_state")
    private String applymentState;

    /**
     * 申请状态描述
     */
    @JsonProperty("applyment_state_msg")
    private String applymentStateMsg;


    /**
     * 驳回原因详情
     */
    @JsonProperty("audit_detail")
    private List<AuditDetail> auditDetail;


    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getApplymentId() {
        return applymentId;
    }

    public void setApplymentId(String applymentId) {
        this.applymentId = applymentId;
    }

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
    }

    public String getSignUrl() {
        return signUrl;
    }

    public void setSignUrl(String signUrl) {
        this.signUrl = signUrl;
    }

    public String getApplymentState() {
        return applymentState;
    }

    public void setApplymentState(String applymentState) {
        this.applymentState = applymentState;
    }

    public String getApplymentStateMsg() {
        return applymentStateMsg;
    }

    public void setApplymentStateMsg(String applymentStateMsg) {
        this.applymentStateMsg = ApplymentStateType.valueOf(this.applymentState).getMessage();
    }

    public List<AuditDetail> getAuditDetail() {
        return auditDetail;
    }

    public void setAuditDetail(List<AuditDetail> auditDetail) {
        this.auditDetail = auditDetail;
    }


    @Override
    public String toString() {
        return "ApplymentStatusResult{" +
                "businessCode='" + businessCode + '\'' +
                ", applymentId='" + applymentId + '\'' +
                ", subMchId='" + subMchId + '\'' +
                ", signUrl='" + signUrl + '\'' +
                ", applymentState='" + applymentState + '\'' +
                ", applymentStateMsg='" + applymentStateMsg + '\'' +
                ", auditDetail=" + auditDetail +
                '}';
    }
}
