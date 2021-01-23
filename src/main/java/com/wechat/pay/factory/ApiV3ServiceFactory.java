package com.wechat.pay.factory;

import com.wechat.pay.v3.config.WxApiV3Config;
import com.wechat.pay.v3.applyment.service.ApplymentService;
import com.wechat.pay.v3.applyment.service.impl.ApplymentServiceImpl;
import com.wechat.pay.v3.transactions.service.WxPayV3Api;
import com.wechat.pay.v3.transactions.service.impl.WxPayV3ApiImpl;

/**
 * @author LYJ
 * @date 2021/1/19 14:56
 * @since 1.0
 */
public class ApiV3ServiceFactory {

    public static ApplymentService applymentService;

    public static WxPayV3Api wxPayV3Api;


    /**
     * 获取商家进件applymentService
     *
     * @param wxApiV3Config
     * @return
     */
    public static ApplymentService getApplymentService(WxApiV3Config wxApiV3Config) {
        synchronized (ApiV3ServiceFactory.class) {
            if (applymentService == null) {
                applymentService = new ApplymentServiceImpl(wxApiV3Config);
            }
        }
        return applymentService;
    }


    /**
     * 获取微信支付WxPayV3Api
     *
     * @param wxApiV3Config
     * @return
     */
    public static WxPayV3Api getWxPayV3Api(WxApiV3Config wxApiV3Config) {
        synchronized (ApiV3ServiceFactory.class) {
            if (wxPayV3Api == null) {
                wxPayV3Api = new WxPayV3ApiImpl(wxApiV3Config);
            }
        }
        return wxPayV3Api;
    }

}
