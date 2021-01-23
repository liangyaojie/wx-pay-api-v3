package com.wechat.pay.v3.transactions.bean.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 场景信息
 *
 * @author LYJ
 * @date 2021/1/22 10:12
 * @since 1.0
 */
public class WxSceneInfo {


    /**
     * 用户终端IP
     * 必填：是
     */
    @JsonProperty("payer_client_ip")
    @JSONField(name = "payer_client_ip")
    private String payerClientIp;

    /**
     * 商户端设备号
     * 必填：否
     */
    @JsonProperty("device_id")
    @JSONField(name = "device_id")
    private WxSettleInfo deviceId;

    /**
     * 商户门店信息
     * 必填：否
     */
    @JsonProperty("store_info")
    @JSONField(name = "store_info")
    private WxStoreInfo storeInfo;

    /**
     * H5场景信息
     * 必填：否
     */
    @JsonProperty("h5_info")
    @JSONField(name = "h5_info")
    private WxH5Info h5Info;


    public String getPayerClientIp() {
        return payerClientIp;
    }

    public void setPayerClientIp(String payerClientIp) {
        this.payerClientIp = payerClientIp;
    }

    public WxSettleInfo getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(WxSettleInfo deviceId) {
        this.deviceId = deviceId;
    }

    public WxStoreInfo getStoreInfo() {
        return storeInfo;
    }

    public void setStoreInfo(WxStoreInfo storeInfo) {
        this.storeInfo = storeInfo;
    }

    public WxH5Info getH5Info() {
        return h5Info;
    }

    public void setH5Info(WxH5Info h5Info) {
        this.h5Info = h5Info;
    }

    @Override
    public String toString() {
        return "WxSceneInfo{" +
                "payerClientIp='" + payerClientIp + '\'' +
                ", deviceId=" + deviceId +
                ", storeInfo=" + storeInfo +
                ", h5Info=" + h5Info +
                '}';
    }
}
