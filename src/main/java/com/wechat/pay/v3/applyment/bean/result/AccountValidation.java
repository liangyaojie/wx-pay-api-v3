package com.wechat.pay.v3.applyment.bean.result;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 汇款账户验证信息
 *
 * @author LYJ
 * @date 2021/1/20 11:15
 * @since 1.0
 */
public class AccountValidation {


    /**
     * 付款户名
     */
    @JsonProperty("account_name")
    private String accountName;

    /**
     * 付款卡号
     */
    @JsonProperty("account_no")
    private String accountNo;

    /**
     * 汇款金额
     */
    @JsonProperty("pay_amount")
    private String payAmount;

    /**
     * 收款卡号
     */
    @JsonProperty("destination_account_number")
    private String destinationAccountNumber;


    /**
     * 收款户名
     */
    @JsonProperty("destination_account_name")
    private String destinationAccountName;


    /**
     * 开户银行
     */
    @JsonProperty("destination_account_bank")
    private String destinationAccountBank;


    /**
     * 省市信息
     */
    @JsonProperty("city")
    private String city;


    /**
     * 备注信息
     */
    @JsonProperty("remark")
    private String remark;



    /**
     * 汇款截止时间
     */
    @JsonProperty("deadline")
    private String deadline;

}
