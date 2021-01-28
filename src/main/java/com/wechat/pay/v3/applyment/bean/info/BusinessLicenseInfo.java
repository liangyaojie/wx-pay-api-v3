package com.wechat.pay.v3.applyment.bean.info;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 营业执照
 *
 * @author LYJ
 * @date 2021/1/15 13:55
 * @since 1.0
 */
public class BusinessLicenseInfo {

    /**
     * 必填
     * 营业执照照片
     * 1、可上传1张图片，请填写通过图片上传接口生成好的MediaID。
     * 2、 请上传彩色照片or彩色扫描件or复印件（需加盖公章鲜章），可添加“微信支付”相关水印（如微信支付认证） 。
     */
    @JsonProperty("license_copy")
    @JSONField(name = "license_copy")
    private String licenseCopy;


    /**
     * 必填
     * 注册号/统一社会信用代码
     * 请填写营业执照上的营业执照注册号，注册号格式须为15位数字或18位数字|大写字母。
     */
    @JsonProperty("license_number")
    @JSONField(name = "license_number")
    private String licenseNumber;


    /**
     * 必填
     * 商户名称
     * 1、请填写营业执照上的商户名称，2~110个字符，支持括号。
     * 2、个体户，不能以“公司”结尾。
     * 3、个体户，若营业执照上商户名称为“空“或“无”时，填写"个体户+经营者姓名"，如“个体户张三”。
     */
    @JsonProperty("merchant_name")
    @JSONField(name = "merchant_name")
    private String merchantName;


    /**
     * 必填
     * 个体户经营者/法人姓名
     * 请填写营业执照的经营者/法定代表人姓名。
     */
    @JsonProperty("legal_person")
    @JSONField(name = "legal_person")
    private String legalPerson;

    public String getLicenseCopy() {
        return licenseCopy;
    }

    public void setLicenseCopy(String licenseCopy) {
        this.licenseCopy = licenseCopy;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }
}
