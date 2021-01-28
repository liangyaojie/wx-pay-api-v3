package com.wechat.pay.v3.applyment.bean.info;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wechat.pay.v3.applyment.anno.SpecEncrypt;

/**
 * 超级管理员信息
 *
 * @author LYJ
 * @date 2021/1/15 14:14
 * @since 1.0
 */
public class ContactInfo {

    /**
     * 超级管理员姓名
     * 必填
     */
    @SpecEncrypt
    @JsonProperty("contact_name")
    @JSONField(name = "contact_name")
    private String contactName;
    /**
     * 超级管理员身份证件号码
     * 与openId二选一
     */
    @SpecEncrypt
    @JsonProperty("contact_id_number")
    @JSONField(name = "contact_id_number")
    private String contactIdNumber;
    /**
     * 超级管理员微信openid
     * 与contactIdNumber二选一
     */
    @JsonProperty("openid")
    @JSONField(name = "openid")
    private String openId;
    /**
     * 联系手机
     * 必填
     */
    @SpecEncrypt
    @JsonProperty("mobile_phone")
    @JSONField(name = "mobile_phone")
    private String mobilePhone;
    /**
     * 联系邮箱
     * 必填
     */
    @SpecEncrypt
    @JsonProperty("contact_email")
    @JSONField(name = "contact_email")
    private String contactEmail;

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactIdNumber() {
        return contactIdNumber;
    }

    public void setContactIdNumber(String contactIdNumber) {
        this.contactIdNumber = contactIdNumber;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}
