package com.wechat.pay.v3.applyment.bean.info;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wechat.pay.v3.applyment.anno.SpecEncrypt;
import com.wechat.pay.v3.applyment.bean.enumbean.WxIdDocType;

/**经营者/法人身份证件
 * @author LYJ
 * @date 2021/1/15 13:55
 * @since 1.0
 */
public class IdentityInfo {


    /**必填
     *证件类型
     */
    @JsonProperty("id_doc_type")
    private WxIdDocType idDocType;

    /**非必填
     * 身份证信息
     * 证件类型为“身份证”时填写
     */
    @SpecEncrypt
    @JsonProperty("id_card_info")
    private IdCardInfo idCardInfo;
    /**非必填
     * 身份证信息
     * 证件类型为“身份证”时填写
     */
    @SpecEncrypt
    @JsonProperty("id_doc_info")
    private IdDocInfo idDocInfo;

    /**必填
     *经营者/法人是否为受益人
     */
    @JsonProperty("owner")
    private boolean owner = true;

    public WxIdDocType getIdDocType() {
        return idDocType;
    }

    public void setIdDocType(WxIdDocType idDocType) {
        this.idDocType = idDocType;
    }

    public IdCardInfo getIdCardInfo() {
        return idCardInfo;
    }

    public void setIdCardInfo(IdCardInfo idCardInfo) {
        this.idCardInfo = idCardInfo;
    }

    public IdDocInfo getIdDocInfo() {
        return idDocInfo;
    }

    public void setIdDocInfo(IdDocInfo idDocInfo) {
        this.idDocInfo = idDocInfo;
    }

    public boolean isOwner() {
        return owner;
    }

    public void setOwner(boolean owner) {
        this.owner = owner;
    }
}
