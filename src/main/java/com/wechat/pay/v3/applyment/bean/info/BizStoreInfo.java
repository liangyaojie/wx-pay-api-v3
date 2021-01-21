package com.wechat.pay.v3.applyment.bean.info;

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
    private String bizStoreName;

    /**
     * 必填
     * 门店省市编码
     */
    private String bizAddressCode;

    /**
     * 必填
     * 门店地址
     */
    private String bizStoreAddress;

    /**
     * 必填
     * 门店门头照片
     */
    private String storeEntrancePic;

    /**
     * 必填
     * 店内环境照片
     */
    private String indoorPic;

    /**
     * 必填
     * 线下场所对应的商家APPID
     */
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
