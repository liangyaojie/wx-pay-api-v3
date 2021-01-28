package com.wechat.pay.v3.test;

import com.wechat.pay.factory.ApiV3ServiceFactory;
import com.wechat.pay.utils.sign.WxApiV3SignUtils;
import com.wechat.pay.v3.config.WxPartnerApiV3Config;
import com.wechat.pay.v3.transactions.bean.base.*;
import com.wechat.pay.v3.transactions.bean.partner.WxPartnerRequest;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * 服务商支付接口测试
 *
 * @author LYJ
 * @date 2021/1/22 10:53
 * @since 1.0
 */
public class WxPayPartnerApiV3Test {

    private WxPartnerApiV3Config wxPartnerApiV3Config;

    @Before
    public void setWxConfig() {
        this.wxPartnerApiV3Config = new WxPartnerApiV3Config();
        //设置服务商公众号ID
        wxPartnerApiV3Config.setSpAppId("wx28988d6eb");
        //设置服务商商户号
        wxPartnerApiV3Config.setSpMchId("160218");
        //设置特约商公众号ID
        wxPartnerApiV3Config.setSubAppId("wxbe55f994d878");
        //设置特约商商户号
        wxPartnerApiV3Config.setSubMchId("1602952");
        //设置apiV3key
        wxPartnerApiV3Config.setApiV3Key("sdfdgdfbdfs24365cdsgsdg325gs");
        //设置商户证书序列号
        wxPartnerApiV3Config.setMchSerialNo("4FE3502F2FE44A01D25A6474A2F29B77");
        //设置私钥文件路径
        wxPartnerApiV3Config.setMchPrivateKeyFilePath("D:/Desktop/apiclient_key.pem");
        //设置平台证书文件路径
        wxPartnerApiV3Config.setWeChatPayCertificateFilePath("D:/wx/wechatpay_288DBF1A35945995870D22D8B81CC43C18E.pem");
        wxPartnerApiV3Config.setNotifyUrl("http://v1./notify");

    }


    /**
     * 服务商APP下单测试
     */
    @Test
    public void partnerPayByAppTest() {
        Map<String, String> map = ApiV3ServiceFactory.getWxPayPartnerV3Api(wxPartnerApiV3Config).partnerPayByApp(creatWxPartnerRequest());
        System.out.println(map);
    }

    /**
     * 服务商JSAPI/小程序下单
     */
    @Test
    public void partnerPayByJsApiTest() {
        Map<String, String> map = ApiV3ServiceFactory.getWxPayPartnerV3Api(wxPartnerApiV3Config).partnerPayByJsApi(creatWxPartnerRequest());
        System.out.println(map);
    }

    /**
     * 服务商Native下单测试
     */
    @Test
    public void partnerPayByNativeTest() {
        Map<String, String> map = ApiV3ServiceFactory.getWxPayPartnerV3Api(wxPartnerApiV3Config).partnerPayByNative(creatWxPartnerRequest());
        System.out.println(map);
    }

    /**
     * 服务商H5下单测试
     */
    @Test
    public void partnerPayByH5Test() {
        WxBaseRequest wxPartnerRequest = creatWxPartnerRequest();
        WxH5Info wxH5Info = new WxH5Info();
        wxH5Info.setType("Wap");
        WxSceneInfo wxSceneInfo = new WxSceneInfo();
        wxSceneInfo.setPayerClientIp("100.100.100.100");
        wxSceneInfo.setH5Info(wxH5Info);
        wxPartnerRequest.setSceneInfo(wxSceneInfo);
        Map<String, String> map = ApiV3ServiceFactory.getWxPayPartnerV3Api(wxPartnerApiV3Config).partnerPayByH5(wxPartnerRequest);
        System.out.println(map);
    }

    /**
     * 服务商微信订单号查询订单测试
     *
     * @throws Exception
     */
    @Test
    public void queryPartnerByTransactionIdTest() throws Exception {
        WxBaseResult wxPartnerQueryResult = ApiV3ServiceFactory.getWxPayPartnerV3Api(wxPartnerApiV3Config).queryPartnerByTransactionId("42000009142020123543644");
        System.out.println(wxPartnerQueryResult);

    }

    /**
     * 服务商商家订单号查询订单测试
     *
     * @throws Exception
     */
    @Test
    public void queryPartnerTransactionsTest() throws Exception {
        WxBaseResult wxPartnerQueryResult = ApiV3ServiceFactory.getWxPayPartnerV3Api(wxPartnerApiV3Config).queryPartnerByOutTradeNo("MWEB39186496498044928");
        System.out.println(wxPartnerQueryResult);

    }


    /**
     * 服务商关闭订单测试
     *
     * @throws Exception
     */
    @Test
    public void closePartnerTransactionsTest() throws Exception {
        Boolean aBoolean = ApiV3ServiceFactory.getWxPayPartnerV3Api(wxPartnerApiV3Config).closePartnerTransactions("MWEB39186496498044928");
        System.out.println(aBoolean);
    }


    /**
     * 创建服务商支付请求参数
     *
     * @return
     */
    WxPartnerRequest creatWxPartnerRequest() {
        WxPartnerRequest wxRequest = new WxPartnerRequest();
        wxRequest.setSpAppId(wxPartnerApiV3Config.getSpAppId());
        wxRequest.setSpMchId(wxPartnerApiV3Config.getSpMchId());
        wxRequest.setSubAppId(wxPartnerApiV3Config.getSubAppId());
        wxRequest.setSubMchId(wxPartnerApiV3Config.getSubMchId());
        wxRequest.setAttach("接口测试");
        wxRequest.setGoodsTag("WXG");
        wxRequest.setTimeExpire("2021-01-22T15:29:35+08:00");
        wxRequest.setDescription("apiV3接口测试");
        wxRequest.setOutTradeNo("apiV3test001");
        wxRequest.setNotifyUrl(wxPartnerApiV3Config.getNotifyUrl());
        WxAmount wxAmount = new WxAmount();
        wxAmount.setTotal(1);
        wxAmount.setCurrency("CNY");
        wxRequest.setAmount(wxAmount);
        System.out.println(wxRequest);
        return wxRequest;
    }


    @Test
    public void signTest() throws Exception {
        String get = WxApiV3SignUtils.getToken("GET",
                "https://www.baidu.com/abc", "",
                wxPartnerApiV3Config.getSpMchId(), WxApiV3SignUtils.getPrivateKey(wxPartnerApiV3Config.getMchPrivateKeyFilePath()),
                wxPartnerApiV3Config.getMchSerialNo());
        System.out.println(get);
    }

}
