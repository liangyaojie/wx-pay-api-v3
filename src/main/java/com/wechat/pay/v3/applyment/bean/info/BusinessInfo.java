package com.wechat.pay.v3.applyment.bean.info;

import com.fasterxml.jackson.annotation.JsonProperty;

/**经营资料
 * @author LYJ
 * @date 2021/1/15 13:50
 * @since 1.0
 */
public class BusinessInfo {


    /**必填
     * 商户简称
     */
    @JsonProperty("merchant_shortname")
    private String merchantShortName;

    /**必填
     * 客服电话
     */
    @JsonProperty("service_phone")
    private String servicePhone;

    /**必填
     * 经营场景
     */
    @JsonProperty("sales_info")
    private SalesInfo salesInfo;

    public String getMerchantShortName() {
        return merchantShortName;
    }

    public void setMerchantShortName(String merchantShortName) {
        this.merchantShortName = merchantShortName;
    }

    public String getServicePhone() {
        return servicePhone;
    }

    public void setServicePhone(String servicePhone) {
        this.servicePhone = servicePhone;
    }

    public SalesInfo getSalesInfo() {
        return salesInfo;
    }

    public void setSalesInfo(SalesInfo salesInfo) {
        this.salesInfo = salesInfo;
    }
}
