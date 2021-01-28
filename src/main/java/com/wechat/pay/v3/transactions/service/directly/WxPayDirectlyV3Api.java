package com.wechat.pay.v3.transactions.service.directly;

import com.wechat.pay.v3.transactions.bean.directly.WxDirectlyQueryResult;
import com.wechat.pay.v3.transactions.bean.directly.WxDirectlyRequest;

import java.io.IOException;
import java.util.Map;

/**
 * @author LYJ
 * @date 2021/1/28 8:50
 * @since 1.0
 */
public interface WxPayDirectlyV3Api {


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
     * 微信支付订单号查询订单请求url
     */
    public static final String QUERY_BY_TRANSACTION_ID_URL = "https://api.mch.weixin.qq.com/v3/pay/partner/transactions/id/{transaction_id}";


    /**
     * 商户订单号查询订单请求url
     */
    public static final String QUERY_BY_OUT_TRADE_NO_URL = "https://api.mch.weixin.qq.com/v3/pay/partner/transactions/out-trade-no/{out_trade_no}";

    /**
     * 关闭订单请求url
     */
    public static final String CLOSE_TRANSACTIONS_URL = "https://api.mch.weixin.qq.com/v3/pay/transactions/out-trade-no/{out_trade_no}/close";


    /**
     * APP下单
     *
     * @param wxRequest
     * @return
     */
    Map<String, String> payByApp(WxDirectlyRequest wxRequest) ;

    /**
     * JSAPI/小程序下单
     *
     * @param wxRequest
     * @return

     */
    Map<String, String> payByJsApi(WxDirectlyRequest wxRequest) ;

    /**
     * Native下单
     *
     * @param wxRequest
     * @return

     */
    Map<String, String> payByNative(WxDirectlyRequest wxRequest) ;

    /**
     * H5下单
     *
     * @param wxRequest
     * @return

     */
    Map<String, String> payByH5(WxDirectlyRequest wxRequest) ;


    /**
     * 通过微信订单号查询订单
     *
     * @param transactionId
     * @return
     * @throws IOException
     */
    WxDirectlyQueryResult queryByTransactionId(String transactionId) throws IOException;


    /**
     * 通过商户订单号查询订单
     *
     * @param outTradeNo
     * @return
     * @throws IOException
     */
    WxDirectlyQueryResult queryByOutTradeNo(String outTradeNo) throws IOException;


    /**
     * 直连商户
     * 关闭订单
     *
     * @param outTradeNo
     * @return
     * @throws IOException
     */
    Boolean closeTransactions(String outTradeNo) throws IOException;

    /**
     *
     * @param wxDirectlyRequest
     * @return
     */
    Map<String, String> getJsApiConfig(WxDirectlyRequest wxDirectlyRequest) ;
}
