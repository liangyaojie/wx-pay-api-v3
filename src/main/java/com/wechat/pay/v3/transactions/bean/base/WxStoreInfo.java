package com.wechat.pay.v3.transactions.bean.base;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 商户门店信息
 *
 * @author LYJ
 * @date 2021/1/22 10:15
 * @since 1.0
 */
public class WxStoreInfo {


    /**
     * 门店编号
     * 必填：是
     */
    @JsonProperty("id")
    private String id;

    /**
     * 门店名称
     * 必填：否
     */
    @JsonProperty("name")
    private String name;

    /**
     * 地区编码
     * 必填：否
     */
    @JsonProperty("area_code")
    private String areaCode;

    /**
     * 详细地址
     * 必填：否
     */
    @JsonProperty("address")
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "WxStoreInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
