package com.wechat.pay.v3.applyment.bean.enumbean;

/**
 * 经营场景类型
 *
 * @author LYJ
 * @date 2021/1/15 15:12
 * @since 1.0
 */
public enum SalesScenesType {

    /**
     * 线下门店
     */
    SALES_SCENES_STORE("线下门店"),
    /**
     * 公众号
     */
    SALES_SCENES_MP("公众号"),
    /**
     * 小程序
     */
    SALES_SCENES_MINI_PROGRAM("小程序"),
    /**
     * 互联网
     */
    SALES_SCENES_WEB("互联网"),
    /**
     * APP
     */
    SALES_SCENES_APP("APP"),
    /**
     * 企业微信
     */
    SALES_SCENES_WE_WORK("企业微信");

    private String desc;

    private SalesScenesType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }

}
