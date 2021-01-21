package com.wechat.pay.v3.applyment.validator;

import com.wechat.pay.v3.applyment.bean.enumbean.SalesScenesType;
import com.wechat.pay.v3.applyment.bean.enumbean.SubjectType;
import com.wechat.pay.v3.applyment.bean.enumbean.WxIdDocType;
import com.wechat.pay.v3.applyment.bean.info.*;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 参数校验器
 *
 * @author LYJ
 * @date 2021/1/15 16:36
 * @since 1.0
 */
public class ApiV3Validator {

    /**
     * 验证并格式化请求参数ApplymentInfo
     *
     * @param applymentInfo
     * @return
     */
    public static String validateAndFormat(ApplymentInfo applymentInfo) {
        if (applymentInfo == null) {
            return "申请信息不能为空！";
        }
        if (StringUtils.isBlank(applymentInfo.getBusinessCode())) {
            return "业务申请编号不能为空！";
        }
        if (applymentInfo.getContactInfo() == null) {
            return "超级管理员信息不能为空！";
        }

        String x = checkContactInfo(applymentInfo.getContactInfo());
        if (x != null) {
            return x;
        }
        String x1 = checkSubjectInfo(applymentInfo.getSubjectInfo());
        if (x1 != null) {
            return x1;
        }
        String x2 = checkBusinessInfo(applymentInfo.getBusinessInfo());
        if (x2 != null) {
            return x2;
        }
        String x3 = checkSettlementInfo(applymentInfo.getSettlementInfo());
        if (x3 != null) {
            return x3;
        }
        String x4 = checkBankAccountInfo(applymentInfo.getBankAccountInfo());
        if (x4 != null) {
            return x4;
        }
        return null;
    }

    private static String checkBankAccountInfo(BankAccountInfo bankAccountInfo) {
        if (bankAccountInfo == null) {
            return "结算银行账户不能为空!";
        }
        if (null == bankAccountInfo.getBankAccountType()) {
            return "账户类型不能为空！";
        }
        if (StringUtils.isBlank(bankAccountInfo.getAccountName())) {
            return "开户名称不能为空！";
        }
        if (StringUtils.isBlank(bankAccountInfo.getAccountBank())) {
            return "开户银行不能为空！";
        }
        if (StringUtils.isBlank(bankAccountInfo.getBankAddressCode())) {
            return "开户银行省市编码不能为空！";
        }
        if (StringUtils.isBlank(bankAccountInfo.getAccountNumber())) {
            return "银行账号不能为空！";
        }
        return null;
    }

    /**
     * 校验结算规则
     *
     * @param settlementInfo
     * @return
     */
    private static String checkSettlementInfo(SettlementInfo settlementInfo) {
        if (settlementInfo == null) {
            return "结算规则不能为空!";
        }
        if (StringUtils.isBlank(settlementInfo.getSettlementId())) {
            return "入驻结算规则ID不能为空！";
        }
        if (StringUtils.isBlank(settlementInfo.getQualificationType())) {
            return "所属行业不能为空！";
        }
        return null;
    }

    /**
     * 校验经营资料
     *
     * @param businessInfo
     * @return
     */
    private static String checkBusinessInfo(BusinessInfo businessInfo) {
        if (businessInfo == null) {
            return "经营资料不能为空！";
        }
        if (StringUtils.isBlank(businessInfo.getMerchantShortName())) {
            return "商户简称不能为空！";
        }
        if (StringUtils.isBlank(businessInfo.getServicePhone())) {
            return "客服电话不能为空！";
        }
        SalesInfo salesInfo = businessInfo.getSalesInfo();
        if (salesInfo == null) {
            return "经营场景不能为空！";
        }
        List<SalesScenesType> salesScenesTypeList = salesInfo.getSalesScenesType();
        if (salesScenesTypeList == null) {
            return "经营场景类型不能为空!";
        }
        for (SalesScenesType salesScenesType : salesScenesTypeList) {
            if (salesScenesType == SalesScenesType.SALES_SCENES_MINI_PROGRAM) {
                MiniProgramInfo miniProgramInfo = salesInfo.getMiniProgramInfo();
                if (null == miniProgramInfo) {
                    return "经营场景类型不能为空!";
                }
                if (StringUtils.isBlank(miniProgramInfo.getMiniProgramAppId()) &&
                        StringUtils.isBlank(miniProgramInfo.getMiniProgramSubAppId())) {
                    return "服务商小程序APPID 和 商家小程序APPID 不能同时为空!";
                }
            } else {
                //TODO　其它类型
            }
        }
        return null;
    }

    /**
     * 校验主体资料
     *
     * @param subjectInfo
     * @return
     */
    private static String checkSubjectInfo(SubjectInfo subjectInfo) {
        if (subjectInfo == null) {
            return "主体资料不能为空！";
        }
        SubjectType subjectType = subjectInfo.getSubjectType();
        if (subjectType == null) {
            return "主体类型不能为空！";
        }
        if (subjectType == SubjectType.SUBJECT_TYPE_INDIVIDUAL || subjectType == SubjectType.SUBJECT_TYPE_ENTERPRISE) {
            BusinessLicenseInfo licenseInfo = subjectInfo.getBusinessLicenseInfo();
            if (licenseInfo == null) {
                return "营业执照不能为空！";
            }
            if (StringUtils.isBlank(licenseInfo.getLicenseCopy())) {
                return "营业执照照片不能为空！";
            }
            if (StringUtils.isBlank(licenseInfo.getLicenseNumber())) {
                return "注册号/统一社会信用代码不能为空！";
            }
            int copyLength = licenseInfo.getLicenseNumber().length();
            if (copyLength != 15 && copyLength != 18) {
                return "注册号格式须为15位数字或18位数字|大写字母！";
            }
            if (StringUtils.isBlank(licenseInfo.getMerchantName())) {
                return "商户名称不能为空！";
            }
            if (StringUtils.isBlank(licenseInfo.getLegalPerson())) {
                return "个体户经营者/法人姓名不能为空！";
            }
        }
        if (subjectInfo.getCertificateInfo() != null) {
            return checkCertificateInfo(subjectInfo.getCertificateInfo());
        }
        //TODO 其它类型 SubjectType
        IdentityInfo identityInfo = subjectInfo.getIdentityInfo();
        WxIdDocType identityInfoIdDocType = identityInfo.getIdDocType();
        if (identityInfoIdDocType == null) {
            return "证件类型不能为空！";
        }
        if (identityInfoIdDocType == WxIdDocType.IDENTIFICATION_TYPE_IDCARD) {
            IdCardInfo idCardInfo = identityInfo.getIdCardInfo();
            if (idCardInfo == null) {
                return "身份证信息不能为空！";
            }
            if (StringUtils.isBlank(idCardInfo.getIdCardNational())) {
                return "身份证国徽面照片不能为空！";
            }
            if (StringUtils.isBlank(idCardInfo.getIdCardName())) {
                return "身份证姓名不能为空！";
            }
            if (StringUtils.isBlank(idCardInfo.getIdCardNumber())) {
                return "身份证号码不能为空！";
            }
            if (StringUtils.isBlank(idCardInfo.getCardPeriodBegin())) {
                return "身份证有效期开始时间不能为空！";
            }
            if (StringUtils.isBlank(idCardInfo.getCardPeriodEnd())) {
                return "身份证有效期结束时间不能为空！";
            }
        } else {
            //TODO 其它类型
        }
        return null;
    }

    private static String checkCertificateInfo(CertificateInfo certificateInfo) {
        if (StringUtils.isBlank(certificateInfo.getCertCopy())) {
            return "登记证书照片不能为空！";
        }
        if (StringUtils.isBlank(certificateInfo.getCertNumber())) {
            return "证书号不能为空！";
        }
        if (StringUtils.isBlank(certificateInfo.getMerchantName())) {
            return "商户名称不能为空！";
        }
        if (StringUtils.isBlank(certificateInfo.getCompanyAddress())) {
            return "注册地址不能为空！";
        }
        if (StringUtils.isBlank(certificateInfo.getLegalPerson())) {
            return "法人姓名不能为空！";
        }
        if (StringUtils.isBlank(certificateInfo.getPeriodBegin())) {
            return "有效期开始时间不能为空！";
        }
        if (StringUtils.isBlank(certificateInfo.getPeriodEnd())) {
            return "有效期结束时间不能为空！";
        }
        return null;
    }

    /**
     * 校验超级管理员信息
     *
     * @param contactInfo
     * @return
     */
    private static String checkContactInfo(ContactInfo contactInfo) {
        if (StringUtils.isBlank(contactInfo.getContactName())) {
            return "超级管理员姓名不能为空！";
        }
        if (StringUtils.isBlank(contactInfo.getContactIdNumber()) && StringUtils.isBlank(contactInfo.getOpenId())) {
            return "超级管理员身份证件号码 和 超级管理员微信openid 不能同时为空！";
        }
        if (StringUtils.isBlank(contactInfo.getMobilePhone())) {
            return "联系手机不能为空！";
        }
        if (StringUtils.isBlank(contactInfo.getContactName())) {
            return "联系邮箱不能为空！";
        }
        return null;
    }


}
