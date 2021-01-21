package com.wechat.pay.v3.applyment.bean.enumbean;

/**
 * 申请单状态类型
 *
 * @author LYJ
 * @date 2021/1/20 12:10
 * @since 1.0
 */
public enum ApplymentStateType {
    /**
     * 提交申请发生错误导致，请尝试重新提交
     */
    APPLYMENT_STATE_EDITTING("编辑中"),
    /**
     * 申请单正在审核中，超级管理员用微信打开“签约链接”，完成绑定微信号后，申请单进度将通过微信公众号通知超级管理员，引导完成后续步骤
     */
    APPLYMENT_STATE_AUDITING("审核中"),
    /**
     * 请按照驳回原因修改申请资料，超级管理员用微信打开“签约链接”，完成绑定微信号，后续申请单进度将通过微信公众号通知超级管理员。
     */
    APPLYMENT_STATE_REJECTED("已驳回"),
    /**
     * 请超级管理员使用微信打开返回的“签约链接”，根据页面指引完成账户验证
     */
    APPLYMENT_STATE_TO_BE_CONFIRMED("待账户验证"),
    /**
     * 请超级管理员使用微信打开返回的“签约链接”，根据页面指引完成签约
     */
    APPLYMENT_STATE_TO_BE_SIGNED("待签约"),
    /**
     * 系统开通相关权限中，请耐心等待
     */
    APPLYMENT_STATE_SIGNING("开通权限中"),
    /**
     * 商户入驻申请已完成
     */
    APPLYMENT_STATE_FINISHED("已完成"),
    /**
     * 申请单已被撤销。
     */
    APPLYMENT_STATE_CANCELED("已作废");
    private String message;

    ApplymentStateType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
