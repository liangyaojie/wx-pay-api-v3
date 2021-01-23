package com.wechat.pay.v3.applyment.bean.enumbean;

/**
 * 账户类型
 *
 * @author LYJ
 * @date 2021/1/15 15:42
 * @since 1.0
 */
public enum BankAccountType {

    ACCOUNT_TYPE_BUSINESS("对公银行账户"),
    ACCOUNT_TYPE_PRIVATE("经营者个人银行卡");

    private String desc;

    private BankAccountType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }


}
