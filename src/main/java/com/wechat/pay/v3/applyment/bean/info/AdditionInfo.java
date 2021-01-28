package com.wechat.pay.v3.applyment.bean.info;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 补充材料
 *
 * @author LYJ
 * @date 2021/1/15 13:50
 * @since 1.0
 */
public class AdditionInfo {


    /**
     * 非必填
     * 法人开户承诺函
     */
    @JsonProperty("legal_person_commitment ")
    @JSONField(name = "legal_person_commitment ")
    private String legalPersonCommitment;

    /**
     * 非必填
     * 法人开户意愿视频
     */
    @JsonProperty("legal_person_video")
    @JSONField(name = "legal_person_video")
    private String legalPersonVideo;

    /**
     * 非必填
     * 补充材料
     */
    @JsonProperty("business_addition_pics ")
    @JSONField(name = "business_addition_pics ")
    private List<String> businessAdditionPics;

    /**
     * 非必填
     * 补充说明
     */
    @JsonProperty("business_addition_msg")
    @JSONField(name = "business_addition_msg")
    private String businessAdditionMsg;

    public String getLegalPersonCommitment() {
        return legalPersonCommitment;
    }

    public void setLegalPersonCommitment(String legalPersonCommitment) {
        this.legalPersonCommitment = legalPersonCommitment;
    }

    public String getLegalPersonVideo() {
        return legalPersonVideo;
    }

    public void setLegalPersonVideo(String legalPersonVideo) {
        this.legalPersonVideo = legalPersonVideo;
    }

    public List<String> getBusinessAdditionPics() {
        return businessAdditionPics;
    }

    public void setBusinessAdditionPics(List<String> businessAdditionPics) {
        this.businessAdditionPics = businessAdditionPics;
    }

    public String getBusinessAdditionMsg() {
        return businessAdditionMsg;
    }

    public void setBusinessAdditionMsg(String businessAdditionMsg) {
        this.businessAdditionMsg = businessAdditionMsg;
    }
}
