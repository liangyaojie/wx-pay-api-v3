package com.wechat.pay.v3.applyment.bean.info;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wechat.pay.v3.applyment.anno.SpecEncrypt;
import com.wechat.pay.v3.applyment.bean.enumbean.SubjectType;

/**
 * 主体资料
 *
 * @author LYJ
 * @date 2021/1/15 13:49
 * @since 1.0
 */
public class SubjectInfo {

    /**
     * 主体类型
     * 必填
     */
    @JsonProperty("subject_type")
    @JSONField(name = "subject_type")
    private SubjectType subjectType;

    /**
     * 营业执照
     * 1、主体为个体户/企业，必填。
     * 2、请上传“营业执照”，需年检章齐全，当年注册除外。
     * 条件选填
     */
    @JsonProperty("business_license_info")
    @JSONField(name = "business_license_info")
    private BusinessLicenseInfo businessLicenseInfo;
    /**
     * 登记证书
     * 条件选填
     */
    @SpecEncrypt
    @JsonProperty("certificate_info")
    @JSONField(name = "certificate_info")
    private CertificateInfo certificateInfo;


    /**
     * 组织机构代码证
     * 条件选填
     */
    @JsonProperty("organization_info")
    @JSONField(name = "organization_info")
    private OrganizationInfo organizationInfo;


    /**
     * 单位证明函照片
     * 1、主体类型为党政、机关及事业单位选传;
     * （1）若上传，则审核通过后即可签约，无需汇款验证。
     * （2）若未上传，则审核通过后，需汇款验证。
     * 2、主体为个体户、企业、其他组织等，不需要上传本字段。
     * 条件选填
     */
    @JsonProperty("certificate_letter_copy")
    @JSONField(name = "certificate_letter_copy")
    private String certificateLetterCopy;

    /**
     * 经营者/法人身份证件
     * 必填
     */
    @SpecEncrypt
    @JsonProperty("identity_info")
    @JSONField(name = "identity_info")
    private IdentityInfo identityInfo;


    /**
     * 最终受益人信息(UBO)
     * 条件选填
     */
    @SpecEncrypt
    @JsonProperty("ubo_info")
    @JSONField(name = "ubo_info")
    private UboInfo uboInfo;

    public SubjectType getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(SubjectType subjectType) {
        this.subjectType = subjectType;
    }

    public BusinessLicenseInfo getBusinessLicenseInfo() {
        return businessLicenseInfo;
    }

    public void setBusinessLicenseInfo(BusinessLicenseInfo businessLicenseInfo) {
        this.businessLicenseInfo = businessLicenseInfo;
    }

    public CertificateInfo getCertificateInfo() {
        return certificateInfo;
    }

    public void setCertificateInfo(CertificateInfo certificateInfo) {
        this.certificateInfo = certificateInfo;
    }

    public OrganizationInfo getOrganizationInfo() {
        return organizationInfo;
    }

    public void setOrganizationInfo(OrganizationInfo organizationInfo) {
        this.organizationInfo = organizationInfo;
    }

    public String getCertificateLetterCopy() {
        return certificateLetterCopy;
    }

    public void setCertificateLetterCopy(String certificateLetterCopy) {
        this.certificateLetterCopy = certificateLetterCopy;
    }

    public IdentityInfo getIdentityInfo() {
        return identityInfo;
    }

    public void setIdentityInfo(IdentityInfo identityInfo) {
        this.identityInfo = identityInfo;
    }

    public UboInfo getUboInfo() {
        return uboInfo;
    }

    public void setUboInfo(UboInfo uboInfo) {
        this.uboInfo = uboInfo;
    }
}
