package com.wechat.pay.v3.applyment.bean.info;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wechat.pay.v3.applyment.anno.SpecEncrypt;

/**
 * 身份证信息
 *
 * @author LYJ
 * @date 2021/1/15 14:54
 * @since 1.0
 */
public class IdCardInfo {


    /**
     * 必填
     * 身份证人像面照片
     * 可上传1张图片，请填写通过《图片上传API》预先上传图片生成好的MediaID。
     * 示例值：jTpGmxUX3FBWVQ5NJTZvlKX_gdU4cRz7z5NxpnFuAxhBTEO_PvWkfSCJ3zVIn001D8daLC-ehEuo0BJqRTvDujqhThn4ReFxikqJ5YW6zFQ
     */
    @JsonProperty("id_card_copy")
    private String idCardCopy;

    /**
     * 必填
     * 反身份证国徽面照片
     * 可上传1张图片，请填写通过《图片上传API》预先上传图片生成好的MediaID。
     * 示例值： 47ZC6GC-vnrbEny__Ie_An5-tCpqxucuxi-vByf3Gjm7KE53JXvGy9tqZm2XAUf-4KGprrKhpVBDIUv0OF4wFNIO4kqg05InE4d2I6_H7I4
     */
    @JsonProperty("id_card_national")
    private String idCardNational;


    /**
     * 必填
     * 身份证姓名
     * 该字段需进行加密处理，加密方法详见《敏感信息加密说明》。(提醒：必须在HTTP头中上送Wechatpay-Serial)
     * 示例值：pVd1HJ6zyvPedzGaV+X3qtmrq9bb9tPRDm2qhZ9evAM+Jv1z0NVa8MRtelw/wDa4SzfeespQO/0kjiwfqdfg==
     */
    @SpecEncrypt
    @JsonProperty("id_card_name")
    private String idCardName;

    /**
     * 必填
     * 身份证号码
     * 该字段需进行加密处理，加密方法详见《敏感信息加密说明》。(提醒：必须在HTTP头中上送Wechatpay-Serial)
     * 示例值：AOZdYGISxo4y44/UgZ69bdagEcGe+vLYiKrzcrodtkRJJp0/0eow96uY1Pk7Rq79Jtt7+I8juwEc4P4TG5xzchG/5IL9DBd+Z0zZXkw==
     */
    @SpecEncrypt
    @JsonProperty("id_card_number")
    private String idCardNumber;

    /**
     * 必填
     * 身份证有效期开始时间
     * 示例值：2026-06-06
     */
    @JsonProperty("card_period_begin")
    private String cardPeriodBegin;

    /**
     * 必填
     * 身份证有效期结束时间
     * 示例值：2026-06-06
     */
    @JsonProperty("card_period_end")
    private String cardPeriodEnd;

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

    public String getIdCardName() {
        return idCardName;
    }

    public void setIdCardName(String idCardName) {
        this.idCardName = idCardName;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getCardPeriodBegin() {
        return cardPeriodBegin;
    }

    public void setCardPeriodBegin(String cardPeriodBegin) {
        this.cardPeriodBegin = cardPeriodBegin;
    }

    public String getCardPeriodEnd() {
        return cardPeriodEnd;
    }

    public void setCardPeriodEnd(String cardPeriodEnd) {
        this.cardPeriodEnd = cardPeriodEnd;
    }
}
