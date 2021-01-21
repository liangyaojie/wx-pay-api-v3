package com.wechat.pay.v3.applyment.bean.enumbean;

/**
 * 登记证书类型
 *
 * @author LYJ
 * @date 2021/1/15 14:40
 * @since 1.0
 */
public enum WxCertType {

    CERTIFICATE_TYPE_2388("事业单位法人证书"),
    CERTIFICATE_TYPE_2389("统一社会信用代码证书"),
    CERTIFICATE_TYPE_2390("有偿服务许可证（军队医院适用）"),
    CERTIFICATE_TYPE_2391("医疗机构执业许可证（军队医院适用）"),
    CERTIFICATE_TYPE_2392("企业营业执照（挂靠企业的党组织适用）"),
    CERTIFICATE_TYPE_2393("组织机构代码证（政府机关适用）"),
    CERTIFICATE_TYPE_2394("社会团体法人登记证书"),
    CERTIFICATE_TYPE_2395("民办非企业单位登记证书"),
    CERTIFICATE_TYPE_2396("基金会法人登记证书"),
    CERTIFICATE_TYPE_2397("慈善组织公开募捐资格证书"),
    CERTIFICATE_TYPE_2398("农民专业合作社法人营业执照"),
    CERTIFICATE_TYPE_2399("宗教活动场所登记证"),
    CERTIFICATE_TYPE_2400("其他证书/批文/证明");

    private String desc;

    private WxCertType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }

}
