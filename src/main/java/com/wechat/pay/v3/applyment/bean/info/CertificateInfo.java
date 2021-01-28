package com.wechat.pay.v3.applyment.bean.info;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wechat.pay.v3.applyment.bean.enumbean.WxCertType;

/**
 * 登记证书
 *
 * @author LYJ
 * @date 2021/1/15 14:02
 * @since 1.0
 */
public class CertificateInfo {

    /**
     * 必填
     * 登记证书照片
     */
    @JsonProperty("cert_copy")
    @JSONField(name = "cert_copy")
    private String certCopy;

    /**
     * 必填
     * 登记证书类型
     */
    @JsonProperty("cert_type")
    @JSONField(name = "cert_type")
    private WxCertType certType;


    /**
     * 必填
     * 证书号
     */
    @JsonProperty("cert_number")
    @JSONField(name = "cert_number")
    private String certNumber;

    /**
     * 必填
     * 商户名称
     */
    @JsonProperty("merchant_name")
    @JSONField(name = "merchant_name")
    private String merchantName;

    /**
     * 必填
     * 注册地址
     */
    @JsonProperty("company_address")
    @JSONField(name = "company_address")
    private String companyAddress;

    /**
     * 必填
     * 法人姓名
     */
    @JsonProperty("legal_person")
    @JSONField(name = "legal_person")
    private String legalPerson;

    /**
     * 必填
     * 有效期限开始日期
     */
    @JsonProperty("legal_person")
    @JSONField(name = "legal_person")
    private String periodBegin;

    /**
     * 必填
     * 有效期限结束日期
     */
    @JsonProperty("period_end")
    @JSONField(name = "period_end")
    private String periodEnd;

    public String getCertCopy() {
        return certCopy;
    }

    public void setCertCopy(String certCopy) {
        this.certCopy = certCopy;
    }

    public WxCertType getCertType() {
        return certType;
    }

    public void setCertType(WxCertType certType) {
        this.certType = certType;
    }

    public String getCertNumber() {
        return certNumber;
    }

    public void setCertNumber(String certNumber) {
        this.certNumber = certNumber;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getPeriodBegin() {
        return periodBegin;
    }

    public void setPeriodBegin(String periodBegin) {
        this.periodBegin = periodBegin;
    }

    public String getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(String periodEnd) {
        this.periodEnd = periodEnd;
    }
}
