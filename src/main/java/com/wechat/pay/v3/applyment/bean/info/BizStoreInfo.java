package com.wechat.pay.v3.applyment.bean.info;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 线下门店场景
 *
 * @author LYJ
 * @date 2021/1/15 15:14
 * @since 1.0
 */
public class BizStoreInfo {


    /**
     * 必填
     * 门店名称
     */
    @JsonProperty("biz_store_name")
    @JSONField(name = "biz_store_name")
    private String bizStoreName;

    /**
     * 必填
     * 门店省市编码
     */
    @JsonProperty("biz_address_code")
    @JSONField(name = "biz_address_code")
    private String bizAddressCode;

    /**
     * 必填
     * 门店地址
     */
    @JsonProperty("biz_store_address")
    @JSONField(name = "biz_store_address")
    private String bizStoreAddress;

    /**
     * 必填
     * 门店门头照片
     */
    @JsonProperty("store_entrance_pic")
    @JSONField(name = "store_entrance_pic")
    private String storeEntrancePic;

    /**
     * 必填
     * 店内环境照片
     */
    @JsonProperty("indoor_pic")
    @JSONField(name = "indoor_pic")
    private String indoorPic;

    /**
     * 必填
     * 线下场所对应的商家APPID
     */
    @JsonProperty("biz_sub_appid")
    @JSONField(name = "biz_sub_appid")
    private String bizSubAppId;

    public String getBizStoreName() {
        return bizStoreName;
    }

    public void setBizStoreName(String bizStoreName) {
        this.bizStoreName = bizStoreName;
    }

    public String getBizAddressCode() {
        return bizAddressCode;
    }

    public void setBizAddressCode(String bizAddressCode) {
        this.bizAddressCode = bizAddressCode;
    }

    public String getBizStoreAddress() {
        return bizStoreAddress;
    }

    public void setBizStoreAddress(String bizStoreAddress) {
        this.bizStoreAddress = bizStoreAddress;
    }

    public String getStoreEntrancePic() {
        return storeEntrancePic;
    }

    public void setStoreEntrancePic(String storeEntrancePic) {
        this.storeEntrancePic = storeEntrancePic;
    }

    public String getIndoorPic() {
        return indoorPic;
    }

    public void setIndoorPic(String indoorPic) {
        this.indoorPic = indoorPic;
    }

    public String getBizSubAppId() {
        return bizSubAppId;
    }

    public void setBizSubAppId(String bizSubAppId) {
        this.bizSubAppId = bizSubAppId;
    }
}
