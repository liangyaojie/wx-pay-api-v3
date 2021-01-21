package com.wechat.pay.v3.applyment.bean.result;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 驳回原因详情
 *
 * @author LYJ
 * @date 2021/1/20 11:25
 * @since 1.0
 */
public class AuditDetail {


    /**
     * 字段名
     */
    @JsonProperty("field")
    private String field;


    /**
     * 字段名称
     */
    @JsonProperty("field_name")
    private String fieldName;

    /**
     * 驳回原因
     */
    @JsonProperty("reject_reason")
    private String rejectReason;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    @Override
    public String toString() {
        return "AuditDetail{" +
                "field='" + field + '\'' +
                ", fieldName='" + fieldName + '\'' +
                ", rejectReason='" + rejectReason + '\'' +
                '}';
    }
}
