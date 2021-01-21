package com.wechat.pay.v3.applyment.bean.info;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wechat.pay.v3.applyment.anno.SpecEncrypt;

/**
 * wx文档地址 https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/tool/applyment4sub/chapter3_1.shtml
 *
 * @author LYJ
 * @date 2021/1/15 13:46
 * @since 1.0
 */
public class ApplymentInfo {

    /**
     * 必填
     * 1、服务商自定义的唯一编号。
     * 2、每个编号对应一个申请单，每个申请单审核通过后会生成一个微信支付商户号。
     * 3、若申请单被驳回，可填写相同的“业务申请编号”，即可覆盖修改原申请单信息。
     */
    @JsonProperty("business_code")
    private String businessCode;

    /**
     * 必填
     * 超级管理员信息
     * 超级管理员需在开户后进行签约，并接收日常重要管理信息和进行资金操作，请确定其为商户法定代表人或负责人。
     */
    @SpecEncrypt
    @JsonProperty("contact_info")
    private ContactInfo contactInfo;

    /**
     * 必填
     * 主体资料
     */
    @SpecEncrypt
    @JsonProperty("subject_info")
    private SubjectInfo subjectInfo;

    /**
     * 必填
     * 经营资料
     */
    @JsonProperty("business_info")
    private BusinessInfo businessInfo;
    /**
     * 必填
     * 结算规则
     */
    @JsonProperty("settlement_info")
    private SettlementInfo settlementInfo;

    /**
     * 条件选填
     * 结算银行账户
     */
    @SpecEncrypt
    @JsonProperty("bank_account_info")
    private BankAccountInfo bankAccountInfo;

    /**
     * 非必填
     * 补充材料
     */
    @JsonProperty("addition_info")
    private AdditionInfo additionInfo;

    public AdditionInfo getAdditionInfo() {
        return additionInfo;
    }

    public void setAdditionInfo(AdditionInfo additionInfo) {
        this.additionInfo = additionInfo;
    }

    public BankAccountInfo getBankAccountInfo() {
        return bankAccountInfo;
    }

    public void setBankAccountInfo(BankAccountInfo bankAccountInfo) {
        this.bankAccountInfo = bankAccountInfo;
    }

    public SettlementInfo getSettlementInfo() {
        return settlementInfo;
    }

    public void setSettlementInfo(SettlementInfo settlementInfo) {
        this.settlementInfo = settlementInfo;
    }

    public SubjectInfo getSubjectInfo() {
        return subjectInfo;
    }

    public void setSubjectInfo(SubjectInfo subjectInfo) {
        this.subjectInfo = subjectInfo;
    }

    public BusinessInfo getBusinessInfo() {
        return businessInfo;
    }

    public void setBusinessInfo(BusinessInfo businessInfo) {
        this.businessInfo = businessInfo;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }
}

