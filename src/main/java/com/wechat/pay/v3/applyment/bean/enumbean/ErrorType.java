package com.wechat.pay.v3.applyment.bean.enumbean;

/**
 * 微信apiV3公共错误码
 *
 * @author LYJ
 * @date 2021/1/20 11:57
 * @since 1.0
 */
public enum ErrorType {
    /**
     * 系统异常，请使用相同参数稍后重新调用
     */
    SYSTEMERROR("系统错误"),
    /**
     * 请使用正确的参数重新调用
     */
    PARAM_ERROR("参数错误"),
    /**
     * 可通过查询申请单状态查看此申请单的申请状态，或更换out_request_no提交新的申请单
     */
    PROCESSING("存在流程进行中的申请单，请检查是否重入"),
    /**
     * 请确认是否已经开通相关权限
     */
    NO_AUTH("商户权限异常"),
    /**
     * 请降低调用频率
     */
    RATE_LIMITED("频率限制"),
    /**
     * 确认入参，传入正确的申请单编号
     */
    APPLYMENT_NOTEXIST("申请单不存在");


    /**
     * 描述
     */
    private String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
