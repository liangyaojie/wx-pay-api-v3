package com.wechat.pay.v3.applyment.factory;

import com.wechat.pay.v3.applyment.config.WxApiV3Config;
import com.wechat.pay.v3.applyment.service.ApiV3Service;
import com.wechat.pay.v3.applyment.service.impl.ApiV3ServiceImpl;

/**
 * @author LYJ
 * @date 2021/1/19 14:56
 * @since 1.0
 */
public  class ApiV3ServiceFactory {

    public static ApiV3Service apiV3Service;

    public static ApiV3Service getApiV3Service(WxApiV3Config wxApiV3Config) {
        synchronized (ApiV3ServiceFactory.class) {
            if (apiV3Service == null) {
                apiV3Service = new ApiV3ServiceImpl(wxApiV3Config);
            }
        }
        return apiV3Service;
    }

}
