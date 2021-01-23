package com.wechat.pay.v3.transactions.service.impl;

import com.alibaba.fastjson.JSON;
import com.wechat.pay.contrib.apache.httpclient.WechatPayHttpClientBuilder;
import com.wechat.pay.contrib.apache.httpclient.auth.AutoUpdateCertificatesVerifier;
import com.wechat.pay.contrib.apache.httpclient.auth.PrivateKeySigner;
import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Credentials;
import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Validator;
import com.wechat.pay.contrib.apache.httpclient.util.PemUtil;
import com.wechat.pay.v3.config.WxApiV3Config;
import com.wechat.pay.v3.transactions.bean.base.WxBaseResult;
import com.wechat.pay.v3.transactions.bean.directly.WxDirectlyQueryResult;
import com.wechat.pay.v3.transactions.bean.directly.WxDirectlyRequest;
import com.wechat.pay.v3.transactions.bean.partner.WxPartnerQueryResult;
import com.wechat.pay.v3.transactions.bean.partner.WxPartnerRequest;
import com.wechat.pay.v3.transactions.service.WxPayV3Api;
import com.wechat.pay.v3.utils.JsonUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 微信支付api调用实现
 *
 * @author LYJ
 * @date 2021/1/22 10:43
 * @since 1.0
 */
public class WxPayV3ApiImpl implements WxPayV3Api {


    private static final Logger LOGGER = LoggerFactory.getLogger(WxPayV3ApiImpl.class);

    /**
     * 测试AutoUpdateCertificatesVerifier的verify方法参数
     */
    private CloseableHttpClient httpClient;
    private AutoUpdateCertificatesVerifier verifier;
    private static final String WE_CHAT_PAY_SERIAL = "Wechatpay-Serial";


    private WxApiV3Config wxApiV3Config;
    private X509Certificate certificate;
    private PrivateKey privateKey;


    public WxPayV3ApiImpl(WxApiV3Config wxApiV3Config) {
        this.wxApiV3Config = wxApiV3Config;
        httpClientBuilder();
    }


    /**
     * 服务商
     * App下单
     *
     * @param wxRequest
     * @return
     * @throws IOException
     */
    @Override
    public Map<String, String> partnerPayByApp(WxPartnerRequest wxRequest) throws IOException {
        return payUtils(wxRequest, Partner.APP_URL);
    }

    /**
     * 服务商
     * JSAPI下单
     *
     * @param wxRequest
     * @return
     * @throws IOException
     */
    @Override
    public Map<String, String> partnerPayByJsApi(WxPartnerRequest wxRequest) throws IOException {
        return payUtils(wxRequest, Partner.JSAPI_URL);
    }

    /**
     * 服务商
     * Native下单
     *
     * @param wxRequest
     * @return
     * @throws IOException
     */
    @Override
    public Map<String, String> partnerPayByNative(WxPartnerRequest wxRequest) throws IOException {
        return payUtils(wxRequest, Partner.NATIVE_URL);
    }

    /**
     * 服务商
     * H5下单
     *
     * @param wxRequest
     * @return
     * @throws IOException
     */
    @Override
    public Map<String, String> partnerPayByH5(WxPartnerRequest wxRequest) throws IOException {
        return payUtils(wxRequest, Partner.H5_URL);
    }

    /**
     * 服务商
     * 微信订单号查询订单
     *
     * @return
     * @throws IOException
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
     * @throws IOException
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
     * @throws IOException
     */
    private WxBaseResult queryPartnerTransactions(String url, String id, String s) throws IOException {
        HttpGet httpGet = new HttpGet(url.replace(s, id)
                .concat("?sp_mchid=" + wxApiV3Config.getSpMchId()).concat("&sub_mchid=" + wxApiV3Config.getSubMchId()));
        httpGet.addHeader("Content-Type", "application/json");
        httpGet.addHeader("Accept", "application/json");
        httpGet.addHeader(WE_CHAT_PAY_SERIAL, certificate.getSerialNumber().toString(16).toUpperCase());
        LOGGER.info(WE_CHAT_PAY_SERIAL + "--->" + certificate.getSerialNumber().toString(16).toUpperCase());
        HttpResponse response = httpClient.execute(httpGet);
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
     * @throws IOException
     */
    @Override
    public Boolean closePartnerTransactions(String outTradeNo) throws IOException {
        HttpPost httpPost = new HttpPost(Partner.CLOSE_TRANSACTIONS_URL.replace("{out_trade_no}", outTradeNo));
        // 设置请求头
        setPostHeader(httpPost);
        Map<String, String> map = new HashMap<>(2);
        map.put("sp_mchid", wxApiV3Config.getSpMchId());
        map.put("sub_mchid", wxApiV3Config.getSubMchId());
        String submitJson = JSON.toJSONString(map);
        LOGGER.info("submit  json---->\n" + submitJson);
        //防止中文乱码
        httpPost.setEntity(new StringEntity(submitJson, "UTF-8"));
        HttpResponse response = httpClient.execute(httpPost);
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

    //服务商
    //===================================================== 分隔线 ===============================================================================
    //直连商户

    /**
     * 直连商户
     * app下单
     *
     * @param wxRequest
     * @return
     * @throws IOException
     */
    @Override
    public Map<String, String> payByApp(WxDirectlyRequest wxRequest) throws IOException {
        return payUtils(wxRequest, APP_URL);
    }

    /**
     * 直连商户
     * JSAPI下单
     *
     * @param wxRequest
     * @return
     * @throws IOException
     */
    @Override
    public Map<String, String> payByJsApi(WxDirectlyRequest wxRequest) throws IOException {
        return payUtils(wxRequest, JSAPI_URL);
    }

    /**
     * 直连商户
     * Native下单
     *
     * @param wxRequest
     * @return
     * @throws IOException
     */
    @Override
    public Map<String, String> payByNative(WxDirectlyRequest wxRequest) throws IOException {
        return payUtils(wxRequest, NATIVE_URL);
    }

    /**
     * 直连商户
     * H5下单
     *
     * @param wxRequest
     * @return
     * @throws IOException
     */
    @Override
    public Map<String, String> payByH5(WxDirectlyRequest wxRequest) throws IOException {
        return payUtils(wxRequest, H5_URL);
    }

    /**
     * 直连商户
     * 微信订单号查询订单
     *
     * @return
     * @throws IOException
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
     * @throws IOException
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
     * @throws IOException
     */
    private WxDirectlyQueryResult queryTransactions(String url, String id, String s) throws IOException {
        HttpGet httpGet = new HttpGet(url.replace(s, id)
                .concat("?mchid=" + wxApiV3Config.getSubMchId()));
        httpGet.addHeader("Content-Type", "application/json");
        httpGet.addHeader("Accept", "application/json");
        httpGet.addHeader(WE_CHAT_PAY_SERIAL, certificate.getSerialNumber().toString(16).toUpperCase());
        LOGGER.info(WE_CHAT_PAY_SERIAL + "--->" + certificate.getSerialNumber().toString(16).toUpperCase());
        HttpResponse response = httpClient.execute(httpGet);
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
        setPostHeader(httpPost);
        Map<String, String> map = new HashMap<>(1);
        map.put("mchid", wxApiV3Config.getSubMchId());
        String submitJson = JSON.toJSONString(map);
        LOGGER.info("submit  json---->\n" + submitJson);
        //防止中文乱码
        httpPost.setEntity(new StringEntity(submitJson, "UTF-8"));
        HttpResponse response = httpClient.execute(httpPost);
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
     * 下单工具方法
     *
     * @param wxRequest
     * @param url
     * @return
     * @throws IOException
     */
    private Map<String, String> payUtils(Object wxRequest, String url) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        // 设置请求头
        setPostHeader(httpPost);
        String submitJson = JSON.toJSONString(wxRequest);
        LOGGER.info("submit  json---->\n" + submitJson);
        //防止中文乱码
        httpPost.setEntity(new StringEntity(submitJson, "UTF-8"));
        HttpResponse response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        LOGGER.info(" result source->{}", result);
        if (response.getStatusLine().getStatusCode() == 200) {
            LOGGER.info("result---->" + result);
            Map<String, String> map = JsonUtils.toMap(result, String.class, String.class);
            return map;
        } else {
            LOGGER.warn("result error---->" + result);
            return null;
        }
    }


    private void setPostHeader(HttpPost httpPost) {
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.addHeader("Accept", "application/json");
        httpPost.addHeader(WE_CHAT_PAY_SERIAL, certificate.getSerialNumber().toString(16).toUpperCase());
        LOGGER.info(WE_CHAT_PAY_SERIAL + "--->" + certificate.getSerialNumber().toString(16).toUpperCase());
    }


    /**
     * 获取自动更新验证签名器httpClient
     */
    private void httpClientBuilder() {
        try {
            if (Objects.isNull(wxApiV3Config)) {
                throw new RuntimeException("wxApiV3Config配置为空");
            }
            if (Objects.isNull(wxApiV3Config.getSpMchId())) {
                throw new RuntimeException("请配置商户号");
            }
            if (Objects.isNull(wxApiV3Config.getMchSerialNo())) {
                throw new RuntimeException("请配置证书序列号");
            }
            if (Objects.isNull(wxApiV3Config.getApiV3Key())) {
                throw new RuntimeException("请配置ApiV3key");
            }
            if (Objects.isNull(wxApiV3Config.getWeChatPayCertificateFilePath())) {
                throw new RuntimeException("请配置微信平台证书路径");
            }
            if (Objects.isNull(wxApiV3Config.getMchPrivateKeyFilePath())) {
                throw new RuntimeException("请配置私钥文件路径");
            }
            this.certificate = PemUtil.loadCertificate(new FileInputStream(new File(wxApiV3Config.getWeChatPayCertificateFilePath())));
            this.privateKey = PemUtil.loadPrivateKey(new FileInputStream(new File(wxApiV3Config.getMchPrivateKeyFilePath())));
            verifier = new AutoUpdateCertificatesVerifier(
                    new WechatPay2Credentials(wxApiV3Config.getSpMchId(), new PrivateKeySigner(wxApiV3Config.getMchSerialNo(), this.privateKey)),
                    wxApiV3Config.getApiV3Key().getBytes("utf-8"));
            WechatPayHttpClientBuilder builder = WechatPayHttpClientBuilder.create()
                    .withMerchant(wxApiV3Config.getSpMchId(), wxApiV3Config.getMchSerialNo(), this.privateKey)
                    .withValidator(new WechatPay2Validator(verifier));
            // 通过WechatPayHttpClientBuilder构造的HttpClient，会自动的处理签名和验签，并进行证书自动更新
            this.httpClient = builder.build();
        } catch (Exception e) {
            LOGGER.error("构建httpClient出错", e);
            e.printStackTrace();
        }
    }

}
