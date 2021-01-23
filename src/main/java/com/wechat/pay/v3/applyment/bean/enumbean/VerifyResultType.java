package com.wechat.pay.v3.applyment.bean.enumbean;

/**
 * @author LYJ
 * @date 2021/1/20 15:01
 * @since 1.0
 */
public enum VerifyResultType {


    /**
     * 系统汇款验证中
     */
    VERIFYING("系统汇款验证中，商户可发起提现尝试。"),
    /**
     * 系统成功汇款
     */
    VERIFY_SUCCESS("系统成功汇款，该账户可正常发起提现。"),
    /**
     * 系统汇款失败
     */
    VERIFY_FAIL("系统汇款失败，该账户无法发起提现，请检查修改。");

    private String desc;

    private VerifyResultType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }
}
