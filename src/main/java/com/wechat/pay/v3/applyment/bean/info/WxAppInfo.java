package com.wechat.pay.v3.applyment.bean.info;

import java.util.List;

/**
 * APP场景
 *
 * @author LYJ
 * @date 2021/1/15 15:31
 * @since 1.0
 */
public class WxAppInfo {

    /**
     * 服务商应用APPID
     * 与商家应用appId二选一
     */
    private String appAppId;


    /**
     * 商家应用APPID
     * 与服务商应用appId二选一
     */
    private String appSubAppId;


    /**
     * 必填
     * APP截图
     * 1、请提供APP首页截图、尾页截图、应用内截图、支付页截图各1张。
     * 2、请填写通过《图片上传API》预先上传图片生成好的MediaID。
     * 示例值：0P3ng6KTIW4-Q_l2FjmFJBZR9FwczhJehHhAZN6BKXQPcs-VvdSo
     */
    private List<String> appPics;

    public String getAppAppId() {
        return appAppId;
    }

    public void setAppAppId(String appAppId) {
        this.appAppId = appAppId;
    }

    public String getAppSubAppId() {
        return appSubAppId;
    }

    public void setAppSubAppId(String appSubAppId) {
        this.appSubAppId = appSubAppId;
    }

    public List<String> getAppPics() {
        return appPics;
    }

    public void setAppPics(List<String> appPics) {
        this.appPics = appPics;
    }
}
