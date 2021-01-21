package com.wechat.pay.v3.applyment.bean.info;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wechat.pay.v3.applyment.anno.SpecEncrypt;

/**其他类型证件信息
 * @author LYJ
 * @date 2021/1/15 14:58
 * @since 1.0
 */
public class IdDocInfo {

    /**必填
     * 证件照片
     */
    @JsonProperty("id_doc_copy")
    private String idDocCopy;


    /**必填
     * 证件姓名
     */
    @SpecEncrypt
    @JsonProperty("id_doc_name")
    private String idDocName;


    /**必填
     * 证件号码
     */
    @SpecEncrypt
    @JsonProperty("id_doc_number")
    private String idDocNumber;


    /**必填
     * 证件有效期开始时间
     */
    @JsonProperty("doc_period_begin ")
    private String docPeriodBegin ;


    /**必填
     * 证件有效期结束时间
     */
    @JsonProperty("doc_period_end")
    private String docPeriodEnd ;



}
