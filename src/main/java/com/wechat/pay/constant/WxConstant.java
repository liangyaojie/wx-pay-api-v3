package com.wechat.pay.constant;

/**
 * @author LYJ
 * @date 2021/1/26 11:14
 * @since 1.0
 */
public interface WxConstant {
    class App {
        public static final String APP_ID = "appid";
        public static final String PARTNER_ID = "partnerid";
        public static final String PREPAY_ID = "prepayid";
        public static final String PACKAGE = "package";
        public static final String NONCE_STR = "noncestr";
        public static final String TIMESTAMP = "timestamp";
        public static final String PAY_SIGN = "paySign";
    }
    class JsApi{
        public static final String APP_ID = "appId";
        public static final String TIMESTAMP = "timeStamp";
        public static final String NONCE_STR = "nonceStr";
        public static final String PACKAGE = "package";
        public static final String SIGN_TYPE = "signType";
        public static final String PAY_SIGN = "paySign";

    }
}
