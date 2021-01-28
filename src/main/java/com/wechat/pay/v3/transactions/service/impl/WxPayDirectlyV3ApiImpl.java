package com.wechat.pay.v3.transactions.service.impl;

import com.alibaba.fastjson.JSON;
import com.wechat.pay.constant.WxConstant;
import com.wechat.pay.utils.WxPayUtil;
import com.wechat.pay.utils.json.JsonUtils;
import com.wechat.pay.utils.sign.WxApiV3SignUtils;
import com.wechat.pay.v3.config.WxDirectlyApiV3Config;
import com.wechat.pay.v3.transactions.bean.directly.WxDirectlyQueryResult;
import com.wechat.pay.v3.transactions.bean.directly.WxDirectlyRequest;
import com.wechat.pay.v3.transactions.service.directly.WxPayDirectlyV3Api;
import org.apache.commons.lang3.StringUtils;
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
import java.util.Objects;

/**
 * @author LYJ
 * @date 2021/1/28 8:56
 * @since 1.0
 */
public class WxPayDirectlyV3ApiImpl implements WxPayDirectlyV3Api {

    private static final Logger LOGGER = LoggerFactory.getLogger(WxPayDirectlyV3ApiImpl.class);

    private static final String PREPAY_ID = "prepay_id";

    private final WxDirectlyApiV3Config wxDirectlyApiV3Config;
    private final WxPayUtil wxPayUtil;


    public WxPayDirectlyV3ApiImpl(WxDirectlyApiV3Config wxDirectlyApiV3Config) {
        this.wxDirectlyApiV3Config = wxDirectlyApiV3Config;
        this.wxPayUtil = new WxPayUtil();
        wxPayUtil.builderDirectlyHttpClient(wxDirectlyApiV3Config);
    }


    /**
     * 直连商户
     * app下单
     *
     * @param wxRequest
     * @return
     */
    @Override
    public Map<String, String> payByApp(WxDirectlyRequest wxRequest) {
        return wxPayUtil.payUtils(wxRequest, APP_URL);
    }

    /**
     * 直连商户
     * JSAPI下单
     *
     * @param wxRequest
     * @return
     * @
     */
    @Override
    public Map<String, String> payByJsApi(WxDirectlyRequest wxRequest) {
        return wxPayUtil.payUtils(wxRequest, JSAPI_URL);
    }

    /**
     * 直连商户
     * Native下单
     *
     * @param wxRequest
     * @return
     * @
     */
    @Override
    public Map<String, String> payByNative(WxDirectlyRequest wxRequest) {
        return wxPayUtil.payUtils(wxRequest, NATIVE_URL);
    }

    /**
     * 直连商户
     * H5下单
     *
     * @param wxRequest
     * @return
     * @
     */
    @Override
    public Map<String, String> payByH5(WxDirectlyRequest wxRequest) {
        return wxPayUtil.payUtils(wxRequest, H5_URL);
    }

    /**
     * 直连商户
     * 微信订单号查询订单
     *
     * @return
     * @
     */
    @Override
    public WxDirectlyQueryResult queryByTransactionId(String transactionId) throws IOException {
        return queryTransactions(QUERY_BY_TRANSACTION_ID_URL, transactionId, "{transaction_id}");
    }

    /**
     * 直连商户
     * 商户订单号查询订单
     *
     * @param outTradeNo outTradeNo
     * @return
     * @
     */
    @Override
    public WxDirectlyQueryResult queryByOutTradeNo(String outTradeNo) throws IOException {
        return queryTransactions(QUERY_BY_OUT_TRADE_NO_URL, outTradeNo, "{out_trade_no}");
    }

    /**
     * 直连商户
     * 查询订单
     *
     * @param url
     * @param id
     * @param s
     * @return
     * @
     */
    private WxDirectlyQueryResult queryTransactions(String url, String id, String s) throws IOException {
        HttpGet httpGet = new HttpGet(url.replace(s, id)
                .concat("?mchid=" + wxDirectlyApiV3Config.getMchId()));
        wxPayUtil.setHeader(httpGet);
        HttpResponse response = wxPayUtil.httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        LOGGER.info(" result source->{}", result);
        if (response.getStatusLine().getStatusCode() == 200) {
            LOGGER.info("result---->" + result);
            return JsonUtils.toBean(result, WxDirectlyQueryResult.class);
        } else {
            LOGGER.warn("result error---->" + result);
            return null;
        }
    }

    /**
     * 直连商户
     * 关闭订单
     *
     * @return
     */
    @Override
    public Boolean closeTransactions(String outTradeNo) throws IOException {
        HttpPost httpPost = new HttpPost(CLOSE_TRANSACTIONS_URL.replace("{out_trade_no}", outTradeNo));
        // 设置请求头
        wxPayUtil.setHeader(httpPost);
        Map<String, String> map = new HashMap<>(1);
        map.put("mchid", wxDirectlyApiV3Config.getMchId());
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


    /**
     * 直连商
     * APP下单API
     *
     * @param wxDirectlyRequest the pay params
     * @return the wechat response entity
     */
    public Map<String, String> appPay(WxDirectlyRequest wxDirectlyRequest) {
        Map<String, String> respMap = payByApp(wxDirectlyRequest);
        if (Objects.isNull(respMap) || StringUtils.isBlank(respMap.get(PREPAY_ID))) {
            throw new RuntimeException("获取" + PREPAY_ID + "失败");
        }
        String prepayId = respMap.get(PREPAY_ID);
        Map<String, String> map = new HashMap<>(6);
        try {
            String timestamp = String.valueOf(WxApiV3SignUtils.getCurrentTimestamp());
            String nonceStr = WxApiV3SignUtils.generateNonceStr();
            map.put(WxConstant.App.APP_ID, wxDirectlyApiV3Config.getAppId());
            map.put(WxConstant.App.PARTNER_ID, wxDirectlyApiV3Config.getMchId());
            map.put(WxConstant.App.PREPAY_ID, prepayId);
            map.put(WxConstant.App.PACKAGE, "Sign=WXPay");
            map.put(WxConstant.App.NONCE_STR, nonceStr);
            map.put(WxConstant.App.TIMESTAMP, timestamp);
            String message = WxApiV3SignUtils.createMessage(wxDirectlyApiV3Config.getAppId(), timestamp, nonceStr, prepayId);
            map.put(WxConstant.App.PAY_SIGN, WxApiV3SignUtils.sign(message, wxPayUtil.privateKey));
            return map;
        } catch (Exception e) {
            LOGGER.error("app签名失败", e);
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 直连商
     * JSAPI下单API
     *
     * @param wxDirectlyRequest the pay params
     * @return the wechat response entity
     */
    @Override
    public Map<String, String> getJsApiConfig(WxDirectlyRequest wxDirectlyRequest) {

        Map<String, String> map = new HashMap<>(6);
        try {
            Map<String, String> respMap = payByJsApi(wxDirectlyRequest);
            String prepayId = respMap.get(PREPAY_ID);
            String timestamp = String.valueOf(WxApiV3SignUtils.getCurrentTimestamp());
            String nonceStr = WxApiV3SignUtils.generateNonceStr();
            map.put(WxConstant.JsApi.APP_ID, wxDirectlyApiV3Config.getAppId());
            map.put(WxConstant.JsApi.TIMESTAMP, timestamp);
            map.put(WxConstant.JsApi.NONCE_STR, nonceStr);
            map.put(WxConstant.JsApi.PACKAGE, PREPAY_ID.concat("=").concat(prepayId));
            map.put(WxConstant.JsApi.SIGN_TYPE, "RSA");
            String message = WxApiV3SignUtils.createMessage(wxDirectlyApiV3Config.getAppId(), timestamp, nonceStr, PREPAY_ID.concat("=").concat(prepayId));
            map.put(WxConstant.JsApi.PAY_SIGN, WxApiV3SignUtils.sign(message, wxPayUtil.privateKey));
            return map;
        } catch (Exception e) {
            LOGGER.error("JSAPI签名失败", e);
            e.printStackTrace();
        }
        return null;
    }


}
