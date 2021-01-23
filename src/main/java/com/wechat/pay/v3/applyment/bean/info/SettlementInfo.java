package com.wechat.pay.v3.applyment.bean.info;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 结算规则
 *
 * @author LYJ
 * @date 2021/1/15 13:50
 * @since 1.0
 */
public class SettlementInfo {

    /**
     * 必填
     * 入驻结算规则ID
     */
    @JsonProperty("settlement_id")
    @JSONField(name = "settlement_id")
    private String settlementId;

    /**
     * 必填
     * 所属行业
     */
    @JsonProperty("qualification_type")
    @JSONField(name = "qualification_type")
    private String qualificationType;

    /**
     * 条件选填
     * 特殊资质图片
     */
    @JsonProperty("qualifications")
    @JSONField(name = "qualifications")
    private List<String> qualifications;

    /**
     * 条件选填
     * 优惠费率活动ID
     */
    @JsonProperty("activities_id")
    @JSONField(name = "activities_id")
    private String activitiesId;

    /**
     * 条件选填
     * 优惠费率活动值
     */
    @JsonProperty("activities_rate")
    @JSONField(name = "activities_rate")
    private String activitiesRate;

    /**
     * 非必填
     * 优惠费率活动补充材料
     */
    @JsonProperty("activities_additions")
    @JSONField(name = "activities_additions")
    private List<String> activitiesAdditions;

    public String getSettlementId() {
        return settlementId;
    }

    public void setSettlementId(String settlementId) {
        this.settlementId = settlementId;
    }

    public String getQualificationType() {
        return qualificationType;
    }

    public void setQualificationType(String qualificationType) {
        this.qualificationType = qualificationType;
    }

    public List<String> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<String> qualifications) {
        this.qualifications = qualifications;
    }

    public String getActivitiesId() {
        return activitiesId;
    }

    public void setActivitiesId(String activitiesId) {
        this.activitiesId = activitiesId;
    }

    public String getActivitiesRate() {
        return activitiesRate;
    }

    public void setActivitiesRate(String activitiesRate) {
        this.activitiesRate = activitiesRate;
    }

    public List<String> getActivitiesAdditions() {
        return activitiesAdditions;
    }

    public void setActivitiesAdditions(List<String> activitiesAdditions) {
        this.activitiesAdditions = activitiesAdditions;
    }
}
