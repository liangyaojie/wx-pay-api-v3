package com.wechat.pay.v3.transactions.service.impl;

import com.alibaba.fastjson.JSON;
import com.wechat.pay.utils.WxPayUtil;
import com.wechat.pay.utils.json.JsonUtils;
import com.wechat.pay.v3.config.WxPartnerApiV3Config;
import com.wechat.pay.v3.transactions.bean.base.WxBaseRequest;
import com.wechat.pay.v3.transactions.bean.base.WxBaseResult;
import com.wechat.pay.v3.transactions.bean.partner.WxPartnerQueryResult;
import com.wechat.pay.v3.transactions.service.partner.WxPayPartnerV3Api;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.wechat.pay.v3.transactions.service.partner.WxPayPartnerV3Api.Partner.CLOSE_TRANSACTIONS_URL;

/**
 * 微信支付api调用实现
 *
 * @author LYJ
 * @date 2021/1/22 10:43
 * @since 1.0
 */
public class WxPayPartnerV3ApiImpl implements WxPayPartnerV3Api {


    private static final Logger LOGGER = LoggerFactory.getLogger(WxPayPartnerV3ApiImpl.class);

    /**
     * 测试AutoUpdateCertificatesVerifier的verify方法参数
     */
    private final WxPayUtil wxPayUtil;


    private final WxPartnerApiV3Config wxPartnerApiV3Config;


    public WxPayPartnerV3ApiImpl(WxPartnerApiV3Config wxPartnerApiV3Config, WxPayUtil wxPayUtil) {
        this.wxPartnerApiV3Config = wxPartnerApiV3Config;
        this.wxPayUtil = wxPayUtil;
        wxPayUtil.builderPartnerHttpClient(wxPartnerApiV3Config);
    }


    /**
     * 服务商
     * App下单
     *
     * @param wxRequest
     * @return
     * @
     */
    @Override
    public Map<String, String> partnerPayByApp(WxBaseRequest wxRequest) {
        return wxPayUtil.payUtils(wxRequest, Partner.APP_URL);
    }

    /**
     * 服务商
     * JSAPI下单
     *
     * @param wxRequest
     * @return
     * @
     */
    @Override
    public Map<String, String> partnerPayByJsApi(WxBaseRequest wxRequest) {
        return wxPayUtil.payUtils(wxRequest, Partner.JSAPI_URL);
    }

    /**
     * 服务商
     * Native下单
     *
     * @param wxRequest
     * @return
     * @
     */
    @Override
    public Map<String, String> partnerPayByNative(WxBaseRequest wxRequest) {
        return wxPayUtil.payUtils(wxRequest, Partner.NATIVE_URL);
    }

    /**
     * 服务商
     * H5下单
     *
     * @param wxRequest
     * @return
     * @
     */
    @Override
    public Map<String, String> partnerPayByH5(WxBaseRequest wxRequest) {
        return wxPayUtil.payUtils(wxRequest, Partner.H5_URL);
    }

    /**
     * 服务商
     * 微信订单号查询订单
     *
     * @return
     * @
     */
    @Override
    public WxBaseResult queryPartnerByTransactionId(String transactionId) throws IOException {
        return queryPartnerTransactions(Partner.QUERY_BY_TRANSACTION_ID_URL, transactionId, "{transaction_id}");
    }

    /**
     * 服务商
     * 商户订单号查询订单
     *
     * @param outTradeNo outTradeNo
     * @return
     * @
     */
    @Override
    public WxBaseResult queryPartnerByOutTradeNo(String outTradeNo) throws IOException {
        return queryPartnerTransactions(Partner.QUERY_BY_OUT_TRADE_NO_URL, outTradeNo, "{out_trade_no}");
    }

    /**
     * 服务商
     * 查询订单
     *
     * @param url url
     * @param id  id
     * @param s   s
     * @return WxPartnerQueryResult
     * @
     */
    private WxBaseResult queryPartnerTransactions(String url, String id, String s) throws IOException {
        HttpGet httpGet = new HttpGet(url.replace(s, id)
                .concat("?sp_mchid=" + wxPartnerApiV3Config.getSpMchId()).concat("&sub_mchid=" + wxPartnerApiV3Config.getSubMchId()));
        wxPayUtil.setHeader(httpGet);
        HttpResponse response = wxPayUtil.httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        LOGGER.info(" result source->{}", result);
        if (response.getStatusLine().getStatusCode() == 200) {
            LOGGER.info("result---->" + result);
            return JsonUtils.toBean(result, WxPartnerQueryResult.class);
        } else {
            LOGGER.warn("result error---->" + result);
            return null;
        }
    }


    /**
     * 服务商
     * 关闭订单
     *
     * @return
     * @
     */
    @Override
    public Boolean closePartnerTransactions(String outTradeNo) throws IOException {
        HttpPost httpPost = new HttpPost(CLOSE_TRANSACTIONS_URL.replace("{out_trade_no}", outTradeNo));
        // 设置请求头
        wxPayUtil.setHeader(httpPost);
        Map<String, String> map = new HashMap<>(2);
        map.put("sp_mchid", wxPartnerApiV3Config.getSpMchId());
        map.put("sub_mchid", wxPartnerApiV3Config.getSubMchId());
        String submitJson = JSON.toJSONString(map);
        LOGGER.info("submit  json---->\n" + submitJson);
        //防止中文乱码
        httpPost.setEntity(new StringEntity(submitJson, "UTF-8"));
        HttpResponse response = wxPayUtil.httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        LOGGER.info(" result source->{}", result);
        if (response.getStatusLine().getStatusCode() == 204) {
            LOGGER.info("result---->" + result);
            return true;
        } else {
            LOGGER.warn("result error---->" + result);
            return false;
        }
    }


}
