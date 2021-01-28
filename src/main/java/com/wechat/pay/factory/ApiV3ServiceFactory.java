package com.wechat.pay.factory;

import com.wechat.pay.utils.WxPayUtil;
import com.wechat.pay.v3.applyment.service.ApplymentService;
import com.wechat.pay.v3.applyment.service.impl.ApplymentServiceImpl;
import com.wechat.pay.v3.config.WxDirectlyApiV3Config;
import com.wechat.pay.v3.config.WxPartnerApiV3Config;
import com.wechat.pay.v3.transactions.service.directly.WxPayDirectlyV3Api;
import com.wechat.pay.v3.transactions.service.impl.WxPayDirectlyV3ApiImpl;
import com.wechat.pay.v3.transactions.service.impl.WxPayPartnerV3ApiImpl;
import com.wechat.pay.v3.transactions.service.partner.WxPayPartnerV3Api;

/**
 * @author LYJ
 * @date 2021/1/19 14:56
 * @since 1.0
 */
public class ApiV3ServiceFactory {

    /**
     * 特约商户进件服务对象
     */
    public static ApplymentService applymentService;

    /**
     * 服务商api服务对象
     */
    public static WxPayPartnerV3Api wxPayPartnerV3Api;

    /**
     * 直连商户api服务对象
     */
    public static WxPayDirectlyV3Api wxPayDirectlyV3Api;


    public static WxPayUtil wxPayUtil;


    /**
     * 获取商家进件applymentService
     *
     * @param wxPartnerApiV3Config wxPartnerApiV3Config
     * @return
     */
    public static ApplymentService getApplymentService(WxPartnerApiV3Config wxPartnerApiV3Config) {
        synchronized (ApiV3ServiceFactory.class) {
            if (applymentService == null) {
                wxPayUtil = new WxPayUtil();
                applymentService = new ApplymentServiceImpl(wxPartnerApiV3Config);
            }
        }
        return applymentService;
    }


    /**
     * 获取服务商微信支付WxPayPartnerV3Api
     *
     * @param wxPartnerApiV3Config wxPartnerApiV3Config
     * @return
     */
    public static WxPayPartnerV3Api getWxPayPartnerV3Api(WxPartnerApiV3Config wxPartnerApiV3Config) {
        synchronized (ApiV3ServiceFactory.class) {
            if (wxPayPartnerV3Api == null) {
                wxPayUtil = new WxPayUtil();
                wxPayPartnerV3Api = new WxPayPartnerV3ApiImpl(wxPartnerApiV3Config,wxPayUtil);

            }
        }
        return wxPayPartnerV3Api;
    }


    /**
     * 获取直连商户微信支付WxPayDirectlyV3Api
     *
     * @param wxDirectlyApiV3Config wxDirectlyApiV3Config
     * @return
     */
    public static WxPayDirectlyV3Api getWxPayDirectlyV3Api(WxDirectlyApiV3Config wxDirectlyApiV3Config) {
        synchronized (ApiV3ServiceFactory.class) {
            if (wxPayDirectlyV3Api == null) {
                wxPayUtil = new WxPayUtil();
                wxPayDirectlyV3Api = new WxPayDirectlyV3ApiImpl(wxDirectlyApiV3Config);
            }
        }
        return wxPayDirectlyV3Api;
    }


}
