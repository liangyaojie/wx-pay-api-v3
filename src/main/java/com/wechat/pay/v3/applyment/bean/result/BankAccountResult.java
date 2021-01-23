package com.wechat.pay.v3.applyment.bean.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wechat.pay.v3.applyment.bean.enumbean.BankAccountType;

/**
 * 查询结算账号返回信息
 *
 * @author LYJ
 * @date 2021/1/18 17:57
 * @since 1.0
 */
public class BankAccountResult {

    /**
     * 账户类型
     */
    @JsonProperty("account_type")
    private BankAccountType accountType;

    /**
     * 开户银行
     */

    @JsonProperty("account_bank")
    private String accountBank;

    /**
     * 开户银行全称（含支行]
     */
    @JsonProperty("bank_name")
    private String bankName;

    /**
     * 开户银行联行号
     */
    @JsonProperty("bank_branch_id")
    private String bankBranchId;

    /**
     * 银行账号
     */
    @JsonProperty("account_number")
    private String accountNumber;

    /**
     * 汇款验证结果
     */
    @JsonProperty("verify_result")
    private String verifyResult;


    public BankAccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(BankAccountType accountType) {
        this.accountType = accountType;
    }

    public String getAccountBank() {
        return accountBank;
    }

    public void setAccountBank(String accountBank) {
        this.accountBank = accountBank;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranchId() {
        return bankBranchId;
    }

    public void setBankBranchId(String bankBranchId) {
        this.bankBranchId = bankBranchId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getVerifyResult() {
        return verifyResult;
    }

    public void setVerifyResult(String verifyResult) {
        this.verifyResult = verifyResult;
    }


    @Override
    public String toString() {
        return "BankAccountResult{" +
                "accountType=" + accountType +
                ", accountBank='" + accountBank + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankBranchId='" + bankBranchId + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", verifyResult='" + verifyResult + '\'' +
                '}';
    }
}
