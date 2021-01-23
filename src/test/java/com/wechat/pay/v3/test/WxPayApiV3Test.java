package com.wechat.pay.v3.test;

import com.wechat.pay.v3.config.WxApiV3Config;
import com.wechat.pay.factory.ApiV3ServiceFactory;
import com.wechat.pay.v3.transactions.bean.base.WxAmount;
import com.wechat.pay.v3.transactions.bean.directly.WxDirectlyRequest;
import com.wechat.pay.v3.transactions.bean.partner.WxPartnerRequest;
import com.wechat.pay.v3.transactions.result.WxQueryResult;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * @author LYJ
 * @date 2021/1/22 10:53
 * @since 1.0
 */
public class WxPayApiV3Test {


    private WxApiV3Config wxApiV3Config;

    @Before
    public void setWxConfig() {
        this.wxApiV3Config = new WxApiV3Config();
        //设置服务商公众号ID
        wxApiV3Config.setSpAppId("wx29898d6eb7c232aa");
        //设置服务商商户号
        wxApiV3Config.setSpMchId("1612389358");
        //设置特约商公众号ID
        wxApiV3Config.setSubAppId("wxb565f9bdde94d878");
        //设置特约商商户号
        wxApiV3Config.setSubMchId("1602956773");
        //设置apiV3key
        wxApiV3Config.setApiV3Key("sdfdgdfabcvvdgs24365cdsgsdg325gs");
        //设置商户证书序列号
        wxApiV3Config.setMchSerialNo("4FE3512F2FE44A01D2040B5E0E5A6474A2F29B77");
        //设置私钥文件路径
        wxApiV3Config.setMchPrivateKeyFilePath("D:/Desktop/apiclient_key.pem");
        //设置平台证书文件路径
        wxApiV3Config.setWeChatPayCertificateFilePath("D:/wx/wechatpay_288DBF1A320CE05945995870D22D8B81CC43C18E.pem");
        wxApiV3Config.setNotifyUrl("http://v1.dotcanting.com/order/pay/wx/notify");
    }


    /**
     * 服务商APP下单测试
     *
     * @throws Exception
     */
    @Test
    public void partnerPayByAppTest() throws Exception {
        Map<String, String> map = ApiV3ServiceFactory.getWxPayV3Api(wxApiV3Config).partnerPayByApp(creatWxPartnerRequest());
        System.out.println(map);
    }

    /**
     * 服务商JSAPI/小程序下单
     *
     * @throws Exception
     */
    @Test
    public void partnerPayByJsApiTest() throws Exception {
        Map<String, String> map = ApiV3ServiceFactory.getWxPayV3Api(wxApiV3Config).partnerPayByJsApi(creatWxPartnerRequest());
        System.out.println(map);
    }

    /**
     * 服务商Native下单测试
     *
     * @throws Exception
     */
    @Test
    public void partnerPayByNativeTest() throws Exception {
        Map<String, String> map = ApiV3ServiceFactory.getWxPayV3Api(wxApiV3Config).partnerPayByNative(creatWxPartnerRequest());
        System.out.println(map);
    }

    /**
     * 服务商H5下单测试
     *
     * @throws Exception
     */
    @Test
    public void partnerPayByH5Test() throws Exception {
        Map<String, String> map = ApiV3ServiceFactory.getWxPayV3Api(wxApiV3Config).partnerPayByH5(creatWxPartnerRequest());
        System.out.println(map);
    }

    /**
     * 服务商微信订单号查询订单测试
     *
     * @throws Exception
     */
    @Test
    public void queryPartnerByTransactionIdTest() throws Exception {
        WxQueryResult wxQueryResult = ApiV3ServiceFactory.getWxPayV3Api(wxApiV3Config).queryPartnerByTransactionId("4200000914202012318603543644");
        System.out.println(wxQueryResult);

    }

    /**
     * 服务商商家订单号查询订单测试
     *
     * @throws Exception
     */
    @Test
    public void queryPartnerTransactionsTest() throws Exception {
        WxQueryResult wxQueryResult = ApiV3ServiceFactory.getWxPayV3Api(wxApiV3Config).queryPartnerByOutTradeNo("MWEB39186496498044928");
        System.out.println(wxQueryResult);

    }


    /**
     * 服务商关闭订单测试
     *
     * @throws Exception
     */
    @Test
    public void closePartnerTransactionsTest() throws Exception {
    }


    /**
     * APP下单测试
     *
     * @throws Exception
     */
    @Test
    public void payByAppTest() throws Exception {
        Map<String, String> map = ApiV3ServiceFactory.getWxPayV3Api(wxApiV3Config).payByApp(creatWxDirectlyRequest());
        System.out.println(map);
    }

    /**
     * JSAPI/小程序下单
     *
     * @throws Exception
     */
    @Test
    public void payByJsApiTest() throws Exception {
        Map<String, String> map = ApiV3ServiceFactory.getWxPayV3Api(wxApiV3Config).payByJsApi(creatWxDirectlyRequest());
        System.out.println(map);
    }

    /**
     * Native下单测试
     *
     * @throws Exception
     */
    @Test
    public void payByNativeTest() throws Exception {
        Map<String, String> map = ApiV3ServiceFactory.getWxPayV3Api(wxApiV3Config).payByNative(creatWxDirectlyRequest());
        System.out.println(map);
    }

    /**
     * H5下单测试
     *
     * @throws Exception
     */
    @Test
    public void payByH5Test() throws Exception {
        Map<String, String> map = ApiV3ServiceFactory.getWxPayV3Api(wxApiV3Config).payByH5(creatWxDirectlyRequest());
        System.out.println(map);
    }

    /**
     * 查询订单测试
     *
     * @throws Exception
     */
    @Test
    public void queryTransactionsTest() throws Exception {
    }


    /**
     * 关闭订单测试
     *
     * @throws Exception
     */
    @Test
    public void closeTransactionsTest() throws Exception {
    }


    /**
     * 创建服务商支付请求参数
     *
     * @return
     */
    WxPartnerRequest creatWxPartnerRequest() {
        WxPartnerRequest wxRequest = new WxPartnerRequest();
        wxRequest.setSpAppId(wxApiV3Config.getSpAppId());
        wxRequest.setSpMchId(wxApiV3Config.getSpMchId());
        wxRequest.setSubAppId(wxApiV3Config.getSubAppId());
        wxRequest.setSubMchId(wxApiV3Config.getSubMchId());
        wxRequest.setAttach("接口测试");
        wxRequest.setGoodsTag("WXG");
        wxRequest.setTimeExpire("2021-01-22T15:29:35+08:00");
        wxRequest.setDescription("apiV3接口测试");
        wxRequest.setOutTradeNo("apiV3test001");
        wxRequest.setNotifyUrl(wxApiV3Config.getNotifyUrl());
        WxAmount wxAmount = new WxAmount();
        wxAmount.setTotal(1);
        wxAmount.setCurrency("CNY");
        wxRequest.setAmount(wxAmount);
        System.out.println(wxRequest);
        return wxRequest;
    }


    /**
     * 创建直连商户支付请求参数
     *
     * @return
     */
    WxDirectlyRequest creatWxDirectlyRequest() {
        WxDirectlyRequest wxRequest = new WxDirectlyRequest();
        wxRequest.setAppId(wxApiV3Config.getSubAppId());
        wxRequest.setMchId(wxApiV3Config.getSubMchId());
        wxRequest.setAttach("接口测试");
        wxRequest.setGoodsTag("WXG");
        wxRequest.setTimeExpire("2021-01-22T15:29:35+08:00");
        wxRequest.setDescription("apiV3接口测试");
        wxRequest.setOutTradeNo("apiV3test001");
        wxRequest.setNotifyUrl(wxApiV3Config.getNotifyUrl());
        WxAmount wxAmount = new WxAmount();
        wxAmount.setTotal(1);
        wxAmount.setCurrency("CNY");
        wxRequest.setAmount(wxAmount);
        System.out.println(wxRequest);
        return wxRequest;
    }

}
