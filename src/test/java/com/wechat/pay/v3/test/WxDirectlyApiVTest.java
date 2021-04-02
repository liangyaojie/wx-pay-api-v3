package com.wechat.pay.v3.test;


import com.wechat.pay.factory.ApiV3ServiceFactory;
import com.wechat.pay.utils.sign.WxApiV3SignUtils;
import com.wechat.pay.v3.config.WxDirectlyApiV3Config;
import com.wechat.pay.v3.transactions.bean.base.WxAmount;
import com.wechat.pay.v3.transactions.bean.base.WxDetail;
import com.wechat.pay.v3.transactions.bean.base.WxH5Info;
import com.wechat.pay.v3.transactions.bean.base.WxSceneInfo;
import com.wechat.pay.v3.transactions.bean.directly.WxDirectlyPayer;
import com.wechat.pay.v3.transactions.bean.directly.WxDirectlyRequest;
import com.wechat.pay.v3.transactions.service.partner.WxPayPartnerV3Api;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * 直连商户接口测试
 *
 * @author LYJ
 * @date 2021/1/28 10:35
 * @since 1.0
 */
public class WxDirectlyApiVTest {


    private WxDirectlyApiV3Config wxDirectlyApiV3Config;

    @Before
    public void setWxConfig() {

        this.wxDirectlyApiV3Config = new WxDirectlyApiV3Config();
        //设置公众号ID
        wxDirectlyApiV3Config.setAppId("wx111ba6d21f6cb56c");
        //设置商户号
        wxDirectlyApiV3Config.setMchId("1299208701");
        //设置apiV3key
        wxDirectlyApiV3Config.setApiV3Key("3FWDWvMPEBw84aRbDFVDrQUv2jKCb911");
        //设置商户证书序列号
        wxDirectlyApiV3Config.setMchSerialNo("3D6FAC6C982DE7822A2B72E33AECB72D6AEBC751");
        //设置私钥文件路径
        wxDirectlyApiV3Config.setMchPrivateKeyFilePath("D:\\huyi\\ssl\\wx\\directly\\apiclient_key.pem");
        //设置平台证书文件路径
        wxDirectlyApiV3Config.setWeChatPayCertificateFilePath("D:\\huyi\\ssl\\wx\\directly\\apiclient_cert.pem");
        wxDirectlyApiV3Config.setNotifyUrl("http://v1.dotcanting.com/order/pay/wx/notify");
    }


    /**
     * APP下单测试
     */
    @Test
    public void payByAppTest() {
        Map<String, String> map = ApiV3ServiceFactory.getWxPayDirectlyV3Api(wxDirectlyApiV3Config).payByApp(creatWxDirectlyRequestApp());
        System.out.println(map);
    }

    /**
     * JSAPI/小程序下单
     */
    @Test
    public void payByJsApiTest() {
        Map<String, String> map = ApiV3ServiceFactory.getWxPayDirectlyV3Api(wxDirectlyApiV3Config).payByJsApi(creatWxDirectlyRequest());
        System.out.println(map);
    }

    /**
     * Native下单测试
     */
    @Test
    public void payByNativeTest() {
        Map<String, String> map = ApiV3ServiceFactory.getWxPayDirectlyV3Api(wxDirectlyApiV3Config).payByNative(creatWxDirectlyRequest());
        System.out.println(map);
    }

    /**
     * H5下单测试
     */
    @Test
    public void payByH5Test() {
        Map<String, String> map = ApiV3ServiceFactory.getWxPayDirectlyV3Api(wxDirectlyApiV3Config).payByH5(creatWxDirectlyRequestH5());
        System.out.println(map);
    }

    /**
     * 查询订单测试
     */
    @Test
    public void queryTransactionsTest() {
    }


    /**
     * 关闭订单测试
     *
     * @throws Exception
     */
    @Test
    public void closeTransactionsTest() throws Exception {
        ApiV3ServiceFactory.getWxPayDirectlyV3Api(wxDirectlyApiV3Config).closeTransactions("");
    }


    /**
     * 创建直连商户支付请求参数
     *
     * @return
     */
    WxDirectlyRequest creatWxDirectlyRequest() {
        WxDirectlyRequest wxRequest = new WxDirectlyRequest();
        wxRequest.setAppId(wxDirectlyApiV3Config.getAppId());
        wxRequest.setMchId(wxDirectlyApiV3Config.getMchId());
        wxRequest.setAttach("接口测试");
        wxRequest.setGoodsTag("WXG");
        wxRequest.setTimeExpire("2021-01-22T15:29:35+08:00");
        wxRequest.setDescription("apiV3接口测试");
        wxRequest.setOutTradeNo("apiV3test001");
        wxRequest.setNotifyUrl(wxDirectlyApiV3Config.getNotifyUrl());
        WxAmount wxAmount = new WxAmount();
        wxAmount.setTotal(1);
        wxAmount.setCurrency("CNY");
        wxRequest.setAmount(wxAmount);
        System.out.println(wxRequest);
        return wxRequest;
    }


    /**
     * 创建直连商户app支付请求参数
     *
     * @return
     */
    WxDirectlyRequest creatWxDirectlyRequestApp() {
        WxDirectlyRequest wxRequest = new WxDirectlyRequest();
        wxRequest.setAppId(wxDirectlyApiV3Config.getAppId());
        wxRequest.setMchId(wxDirectlyApiV3Config.getMchId());
        wxRequest.setAttach("接口测试");
        wxRequest.setGoodsTag("WXG");
        wxRequest.setTimeExpire("2021-01-22T15:29:35+08:00");
        wxRequest.setDescription("apiV3接口测试");
        wxRequest.setOutTradeNo("apiV3test001");
        wxRequest.setNotifyUrl(wxDirectlyApiV3Config.getNotifyUrl());
        WxAmount wxAmount = new WxAmount();
        wxAmount.setTotal(1);
        wxAmount.setCurrency("CNY");
        wxRequest.setAmount(wxAmount);
        System.out.println(wxRequest);
        return wxRequest;
    }



    /**
     * 创建直连商户H5支付请求参数
     *
     * @return
     */
    WxDirectlyRequest creatWxDirectlyRequestH5() {
        WxDirectlyRequest wxRequest = new WxDirectlyRequest();
        wxRequest.setAppId(wxDirectlyApiV3Config.getAppId());
        wxRequest.setMchId(wxDirectlyApiV3Config.getMchId());
        //商品描述
        wxRequest.setDescription("apiV3接口测试");
        //商户订单号
        wxRequest.setOutTradeNo("apiV3test002");
        //订单失效时间 非必传
        wxRequest.setTimeExpire("2021-06-08T10:34:56+08:00");
        //附加数据，传什么返回什么 非必传
        wxRequest.setAttach("接口测试");
        //微信通知回调地址
        wxRequest.setNotifyUrl(wxDirectlyApiV3Config.getNotifyUrl());
        //订单优惠标记 非必传
        wxRequest.setGoodsTag("WXG");

        //订单金额
        WxAmount wxAmount = new WxAmount();
        //订单总金额
        wxAmount.setTotal(1);
        //货币类型 非必传
        wxAmount.setCurrency("CNY");
        wxRequest.setAmount(wxAmount);
      //优惠功能 非必传
        WxDetail wxDetail = new WxDetail();
        //场景信息
        WxSceneInfo wxSceneInfo = new WxSceneInfo();
        //h5场景信息
        WxH5Info wxH5Info = new WxH5Info();
        wxH5Info.setType("Wap");
        wxSceneInfo.setH5Info(wxH5Info);
        //用户的客户端ip
        wxSceneInfo.setPayerClientIp("14.23.150.211 ");
        wxRequest.setSceneInfo(wxSceneInfo);
        System.out.println(wxRequest);
        return wxRequest;
    }
    /**
     * 创建直连商户JsApi支付请求参数
     *
     * @return
     */
    WxDirectlyRequest creatWxDirectlyRequestJsApi() {
        WxDirectlyRequest wxRequest = new WxDirectlyRequest();
        wxRequest.setAppId(wxDirectlyApiV3Config.getAppId());
        wxRequest.setMchId(wxDirectlyApiV3Config.getMchId());
        wxRequest.setAttach("接口测试");
        wxRequest.setGoodsTag("WXG");
        wxRequest.setTimeExpire("2021-01-22T15:29:35+08:00");
        wxRequest.setDescription("apiV3接口测试");
        wxRequest.setOutTradeNo("apiV3test001");
        wxRequest.setNotifyUrl(wxDirectlyApiV3Config.getNotifyUrl());
        WxAmount wxAmount = new WxAmount();
        wxAmount.setTotal(1);
        wxAmount.setCurrency("CNY");
        wxRequest.setAmount(wxAmount);
        WxDirectlyPayer wxDirectlyPayer = new WxDirectlyPayer();
        wxDirectlyPayer.setOpenId("oy6W_w9plkaBgFJuMmyuFRQtmIhI");
        wxRequest.setPayer(wxDirectlyPayer);
        System.out.println(wxRequest);
        return wxRequest;
    }

    @Test
    public void jsApiTest() {
        WxPayPartnerV3Api wxPayV3Api = (WxPayPartnerV3Api) ApiV3ServiceFactory.getWxPayDirectlyV3Api(wxDirectlyApiV3Config).getJsApiConfig(creatWxDirectlyRequestJsApi());
        System.out.println(wxPayV3Api);
    }


    @Test
    public void signTest() throws Exception {
        String get = WxApiV3SignUtils.getToken("GET",
                "https://www.baidu.com/abc", "",
                wxDirectlyApiV3Config.getMchId(), WxApiV3SignUtils.getPrivateKey(wxDirectlyApiV3Config.getMchPrivateKeyFilePath()),
                wxDirectlyApiV3Config.getMchSerialNo());
        System.out.println(get);
    }
}
