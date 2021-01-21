package com.wechat.pay.v3.applyment.bean.info;

/**
 * 组织机构代码证
 *
 * @author LYJ
 * @date 2021/1/15 14:03
 * @since 1.0
 */
public class OrganizationInfo {


    /**
     * 必填
     * 组织机构代码证照片
     * 示例值：47ZC6GCGy9tqZm2XAUf-4KGprrKhpVBDIUv0OF4wFNIO4kqg05InE4d2I6_H7I4
     */
    private String organizationCopy;

    /**
     * 必填
     * 组织机构代码
     * 示例值：123456789-A
     */
    private String organizationCode;

    /**
     * 必填
     * 组织机构代码证有效期开始日期
     * 示例值：2019-08-01
     */
    private String orgPeriodBegin;

    /**
     * 必填
     * 组织机构代码证有效期结束日期
     * 示例值：2019-08-01，长期
     */
    private String orgPeriodEnd;

    public String getOrganizationCopy() {
        return organizationCopy;
    }

    public void setOrganizationCopy(String organizationCopy) {
        this.organizationCopy = organizationCopy;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getOrgPeriodBegin() {
        return orgPeriodBegin;
    }

    public void setOrgPeriodBegin(String orgPeriodBegin) {
        this.orgPeriodBegin = orgPeriodBegin;
    }

    public String getOrgPeriodEnd() {
        return orgPeriodEnd;
    }

    public void setOrgPeriodEnd(String orgPeriodEnd) {
        this.orgPeriodEnd = orgPeriodEnd;
    }
}
