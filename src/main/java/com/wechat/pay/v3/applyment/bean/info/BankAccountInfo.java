package com.wechat.pay.v3.applyment.bean.info;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wechat.pay.v3.applyment.anno.SpecEncrypt;
import com.wechat.pay.v3.applyment.bean.enumbean.BankAccountType;

/**
 * 结算银行账户
 *
 * @author LYJ
 * @date 2021/1/15 13:50
 * @since 1.0
 */
public class BankAccountInfo {


    /**
     * 必填
     * 账户类型
     */
    @JsonProperty("bank_account_type")
    @JSONField(name = "bank_account_type")
    private BankAccountType bankAccountType;

    /**
     * 必填
     * 开户名称
     */
    @SpecEncrypt
    @JsonProperty("account_name")
    @JSONField(name = "account_name")
    private String accountName;

    /**
     * 必填
     * 开户银行
     */
    @JsonProperty("account_bank")
    @JSONField(name = "account_bank")
    private String accountBank;

    /**
     * 必填
     * 开户银行省市编码
     */
    @JsonProperty("bank_address_code")
    @JSONField(name = "bank_address_code")
    private String bankAddressCode;

    /**
     * 必填
     * 开户银行联行号
     */
    @JsonProperty("bank_branch_id")
    @JSONField(name = "bank_branch_id")
    private String bankBranchId;

    /**
     * 必填
     * 开户银行全称（含支行）
     */
    @JsonProperty("bank_name")
    @JSONField(name = "bank_name")
    private String bankName;

    /**
     * 必填
     * 银行账号
     */
    @SpecEncrypt
    @JsonProperty("account_number")
    @JSONField(name = "account_number")
    private String accountNumber;

    public BankAccountType getBankAccountType() {
        return bankAccountType;
    }

    public void setBankAccountType(BankAccountType bankAccountType) {
        this.bankAccountType = bankAccountType;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountBank() {
        return accountBank;
    }

    public void setAccountBank(String accountBank) {
        this.accountBank = accountBank;
    }

    public String getBankAddressCode() {
        return bankAddressCode;
    }

    public void setBankAddressCode(String bankAddressCode) {
        this.bankAddressCode = bankAddressCode;
    }

    public String getBankBranchId() {
        return bankBranchId;
    }

    public void setBankBranchId(String bankBranchId) {
        this.bankBranchId = bankBranchId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
