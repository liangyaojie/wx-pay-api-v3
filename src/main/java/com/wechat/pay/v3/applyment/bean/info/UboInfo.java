package com.wechat.pay.v3.applyment.bean.info;

import com.wechat.pay.v3.applyment.anno.SpecEncrypt;
import com.wechat.pay.v3.applyment.bean.enumbean.WxIdDocType;

/**
 * 最终受益人信息(UBO)
 *
 * @author LYJ
 * @date 2021/1/15 14:11
 * @since 1.0
 */
public class UboInfo {


    /**
     * 必填
     * 证件类型
     */
    private WxIdDocType idType;

    /**
     * 条件选填
     * 身份证人像面照片
     */
    private String idCardCopy;

    /**
     * 条件选填
     * 身份证国徽面照片
     */
    private String idCardNational;


    /**
     * 条件选填
     * 证件照片
     */
    private String idDocCopy;

    /**
     * 必填
     * 受益人姓名
     */
    @SpecEncrypt
    private String name;

    /**
     * 必填
     * 证件号码
     * 示例值：AOZdYGISxo4y44/Ug4P4TG5xzchG/5IL9DBd+Z0zZXkw==
     */
    @SpecEncrypt
    private String idCardNumber;

    /**
     * 必填
     * 证件有效期开始时间
     * 示例值：2019-06-06
     */
    private String idPeriodBegin;

    /**
     * 必填
     * 证件有效期结束时间
     * 示例值：2026-06-06
     */
    private String idPeriodEnd;

    public WxIdDocType getIdType() {
        return idType;
    }

    public void setIdType(WxIdDocType idType) {
        this.idType = idType;
    }

    public String getIdCardCopy() {
        return idCardCopy;
    }

    public void setIdCardCopy(String idCardCopy) {
        this.idCardCopy = idCardCopy;
    }

    public String getIdCardNational() {
        return idCardNational;
    }

    public void setIdCardNational(String idCardNational) {
        this.idCardNational = idCardNational;
    }

    public String getIdDocCopy() {
        return idDocCopy;
    }

    public void setIdDocCopy(String idDocCopy) {
        this.idDocCopy = idDocCopy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getIdPeriodBegin() {
        return idPeriodBegin;
    }

    public void setIdPeriodBegin(String idPeriodBegin) {
        this.idPeriodBegin = idPeriodBegin;
    }

    public String getIdPeriodEnd() {
        return idPeriodEnd;
    }

    public void setIdPeriodEnd(String idPeriodEnd) {
        this.idPeriodEnd = idPeriodEnd;
    }
}
