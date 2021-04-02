package com.wechat.pay.v3.transactions.bean.enums;

/**
 * 交易类型枚举
 *
 * @author LYJ
 * @date 2021/4/2 16:34
 * @since 1.0
 */
enum TradeStateEnum {

    /**
     * 支付成功
     */
    SUCCESS("支付成功"),
    /**
     * 转入退款
     */
    REFUND("转入退款"),
    /**
     * 未支付
     */
    NOTPYA("未支付"),
    /**
     * 已关闭
     */
    CLOSED("已关闭"),
    /**
     * 已撤销(付款码支付)
     */
    REVOKED("已撤销(付款码支付)"),
    /**
     * 用户支付中(付款码支付)
     */
    USERPAYTING("用户支付中(付款码支付)"),
    /**
     * 支付失败
     */
    PAYERROR("支付失败");

    private String msg;


    TradeStateEnum(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
