package com.wechat.pay.v3.transactions.service;

import com.wechat.pay.v3.transactions.bean.directly.WxDirectlyRequest;
import com.wechat.pay.v3.transactions.bean.partner.WxPartnerRequest;
import com.wechat.pay.v3.transactions.result.WxQueryResult;

import java.io.IOException;
import java.util.Map;

/**
 * 微信支付api
 *
 * @author LYJ
 * @date 2021/1/22 10:23
 * @since 1.0
 */
public interface WxPayV3Api {


    /**
     * APP下单请求url
     */
    public static final String APP_URL = "https://api.mch.weixin.qq.com/v3/pay/transactions/app";
    /**
     * JSAPI/小程序下单请求url
     */
    public static final String JSAPI_URL = "https://api.mch.weixin.qq.com/v3/pay/transactions/jsapi";

    /**
     * Native下单请求url
     */
    public static final String NATIVE_URL = "https://api.mch.weixin.qq.com/v3/pay/transactions/native";
    /**
     * H5下单请求url
     */
    public static final String H5_URL = "https://api.mch.weixin.qq.com/v3/pay/transactions/h5";


    /**
     * 服务商请求URL
     */
    public static class Partner {

        /**
         * APP下单请求url
         */
        public static final String APP_URL = "https://api.mch.weixin.qq.com/v3/pay/partner/transactions/app";


        /**
         * JSAPI/小程序下单请求url
         */
        public static final String JSAPI_URL = "https://api.mch.weixin.qq.com/v3/pay/partner/transactions/jsapi";


        /**
         * Native下单请求url
         */
        public static final String NATIVE_URL = "https://api.mch.weixin.qq.com/v3/pay/partner/transactions/native";


        /**
         * H5下单请求url
         */
        public static final String H5_URL = "https://api.mch.weixin.qq.com/v3/pay/partner/transactions/h5";


        /**
         * 微信支付订单号查询订单请求url
         */
        public static final String QUERY_BY_TRANSACTION_ID_URL = "https://api.mch.weixin.qq.com/v3/pay/partner/transactions/id/{transaction_id}";


        /**
         * 商户订单号查询订单请求url
         */
        public static final String QUERY_BY_OUT_TRADE_NO_URL = "https://api.mch.weixin.qq.com/v3/pay/partner/transactions/out-trade-no/{out_trade_no}";


        /**
         * 服务商关闭订单请求url
         */
        public static final String CLOSE_TRANSACTIONS_URL = "https://api.mch.weixin.qq.com/v3/pay/partner/transactions/out-trade-no/{out_trade_no}/close";
    }

    /**
     * 服务商APP下单
     *
     * @param wxRequest
     * @return
     * @throws IOException
     */
    Map<String, String> partnerPayByApp(WxPartnerRequest wxRequest) throws IOException;

    /**
     * 服务商JSAPI/小程序下单
     *
     * @param wxRequest
     * @return
     * @throws IOException
     */
    Map<String, String> partnerPayByJsApi(WxPartnerRequest wxRequest) throws IOException;

    /**
     * 服务商Native下单
     *
     * @param wxRequest
     * @return
     * @throws IOException
     */
    Map<String, String> partnerPayByNative(WxPartnerRequest wxRequest) throws IOException;

    /**
     * 服务商H5下单
     *
     * @param wxRequest
     * @return
     * @throws IOException
     */
    Map<String, String> partnerPayByH5(WxPartnerRequest wxRequest) throws IOException;


    /**
     * 服务商通过微信订单号查询订单
     *
     * @param transactionId
     * @return
     * @throws IOException
     */
    WxQueryResult queryPartnerByTransactionId(String transactionId) throws IOException;


    /**
     * 服务商通过商户订单号查询订单
     *
     * @param OutTradeNo
     * @return
     * @throws IOException
     */
    WxQueryResult queryPartnerByOutTradeNo(String OutTradeNo) throws IOException;


    /**
     * 服务商关闭订单
     *
     * @return
     * @throws IOException
     */
    Map<String, String> closePartnerTransactions() throws IOException;


    /**
     * APP下单
     *
     * @param wxRequest
     * @return
     * @throws IOException
     */
    Map<String, String> payByApp(WxDirectlyRequest wxRequest) throws IOException;

    /**
     * JSAPI/小程序下单
     *
     * @param wxRequest
     * @return
     * @throws IOException
     */
    Map<String, String> payByJsApi(WxDirectlyRequest wxRequest) throws IOException;

    /**
     * Native下单
     *
     * @param wxRequest
     * @return
     * @throws IOException
     */
    Map<String, String> payByNative(WxDirectlyRequest wxRequest) throws IOException;

    /**
     * H5下单
     *
     * @param wxRequest
     * @return
     * @throws IOException
     */
    Map<String, String> payByH5(WxDirectlyRequest wxRequest) throws IOException;


    /**
     * 查询订单
     *
     * @return
     * @throws IOException
     */
    Map<String, String> queryTransactions() throws IOException;


    /**
     * 关闭订单
     *
     * @return
     * @throws IOException
     */
    Map<String, String> closeTransactions() throws IOException;

}
