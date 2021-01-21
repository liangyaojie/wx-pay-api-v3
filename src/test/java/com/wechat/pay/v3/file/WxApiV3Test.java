package com.wechat.pay.v3.file;

import com.wechat.pay.v3.applyment.bean.enumbean.SalesScenesType;
import com.wechat.pay.v3.applyment.bean.enumbean.SubjectType;
import com.wechat.pay.v3.applyment.bean.enumbean.WxIdDocType;
import com.wechat.pay.v3.applyment.bean.info.*;
import com.wechat.pay.v3.applyment.bean.result.ApplymentStatusResult;
import com.wechat.pay.v3.applyment.bean.result.BankAccountResult;
import com.wechat.pay.v3.applyment.factory.ApiV3ServiceFactory;
import com.wechat.pay.v3.applyment.config.WxApiV3Config;
import com.wechat.pay.v3.applyment.service.ApiV3Service;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

/**
 * @author LYJ
 * @date 2021/1/15 18:35
 * @since 1.0
 */

public class WxApiV3Test {

    private WxApiV3Config wxApiV3Config;

    @Before
    public void setWxConfig() {
        this.wxApiV3Config = new WxApiV3Config();
        //设置商户号
        wxApiV3Config.setMchId("1602189359");
        //设置apiV3key
        wxApiV3Config.setApiV3Key("sdfdgdfbdfvvdgs24365cdsgsdg325sg");
        //设置商户证书序列号
        wxApiV3Config.setMchSerialNo("4FE3502F2FE44A01D2040B5E0E5A6474A2F29B87");
        //设置私钥文件路径
        wxApiV3Config.setMchPrivateKeyFilePath("D:/Desktop/apiclient_key.pem");
        //设置平台证书文件路径
        wxApiV3Config.setWeChatPayCertificateFilePath("D:/wx/wechatpay_288DBF1A320CE05945995870D22D8B81CC43C18E.pem");
    }

    /**
     * 申请入驻加载参数
     */
    private ApplymentInfo creatInfo() {
        ApplymentInfo applymentInfo = new ApplymentInfo();
        applymentInfo.setBusinessCode("test");
        //超级管理员信息
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setContactName("");
        contactInfo.setContactIdNumber("");
        contactInfo.setMobilePhone("");
        contactInfo.setContactEmail("liang_yaojie@163.com");
        applymentInfo.setContactInfo(contactInfo);
        //主体资料
        SubjectInfo subjectInfo = new SubjectInfo();
        subjectInfo.setSubjectType(SubjectType.SUBJECT_TYPE_INDIVIDUAL);
        BusinessLicenseInfo businessLicenseInfo = new BusinessLicenseInfo();
        //营业执照照片
        businessLicenseInfo.setLicenseCopy("MK8mDdyaoy3i1HxqDBBiq7kJ6vLdYkkEH0yUtJhDwbmA8UA214cGISMiJPs7YZveMPg02NrQZz6izJTXNC7j56lylsRbDKojuA7ncHG8d0Y");
        //营业执照注册号
        businessLicenseInfo.setLicenseNumber("91510100MA66Y3269H");
        //商户名称
        businessLicenseInfo.setMerchantName("接口测试");
        //法人姓名
        businessLicenseInfo.setLegalPerson("接口测试");
        subjectInfo.setBusinessLicenseInfo(businessLicenseInfo);

        IdentityInfo identityInfo = new IdentityInfo();
        //证件类型
        identityInfo.setIdDocType(WxIdDocType.IDENTIFICATION_TYPE_IDCARD);
        IdCardInfo idCardInfo = new IdCardInfo();
        //身份证人像面照片
        idCardInfo.setIdCardCopy("MK8mDdyaoy3i1HxqDBBiq7kJ6vLdYkkEH0yUtJhDwbmA8UA214cGISMiJPs7YZveMPg02NrQZz6izJTXNC7j56lylsRbDKojuA7ncHG8d0Y");
        //身份证国徽面照片
        idCardInfo.setIdCardNational("MK8mDdyaoy3i1HxqDBBiq7kJ6vLdYkkEH0yUtJhDwbmA8UA214cGISMiJPs7YZveMPg02NrQZz6izJTXNC7j56lylsRbDKojuA7ncHG8d0Y");
        //身份证姓名
        idCardInfo.setIdCardName("");
        //身份证号码
        idCardInfo.setIdCardNumber("");
        //身份证有效开始时间
        idCardInfo.setCardPeriodBegin("2017-08-17");
        //身份证有效结束时间
        idCardInfo.setCardPeriodEnd("2037-08-14");

        identityInfo.setIdCardInfo(idCardInfo);
        identityInfo.setOwner(true);
        subjectInfo.setIdentityInfo(identityInfo);
        applymentInfo.setSubjectInfo(subjectInfo);
        BusinessInfo businessInfo = new BusinessInfo();
        //商户简称
        businessInfo.setMerchantShortName("接口测试");
        //客服电话
        businessInfo.setServicePhone("");
        //经营场景
        SalesInfo salesInfo = new SalesInfo();
        salesInfo.setSalesScenesType(Arrays.asList(SalesScenesType.SALES_SCENES_WEB));

        WebInfo webInfo = new WebInfo();
        webInfo.setDomain("");
        salesInfo.setWebInfo(webInfo);
        businessInfo.setSalesInfo(salesInfo);
        applymentInfo.setBusinessInfo(businessInfo);
        //结算规则
        SettlementInfo settlementInfo = new SettlementInfo();
        //入驻结算规则ID
        settlementInfo.setSettlementId("719");
        settlementInfo.setQualificationType("餐饮");
        settlementInfo.setQualifications(Collections.singletonList("MK8mDdyaoy3i1HxqDBBiq7kJ6vLdYkkEH0yUtJhDwbmA8UA214cGISMiJPs7YZveMPg02NrQZz6izJTXNC7j56lylsRbDKojuA7ncHG8d0Y"));
        settlementInfo.setActivitiesAdditions(null);

        applymentInfo.setSettlementInfo(settlementInfo);

        return applymentInfo;
    }


    /**
     * 测试申请入驻
     *
     * @throws Exception
     */
    @Test
    public void applymentTest() throws Exception {
        ApplymentInfo applymentInfo = creatInfo();
        ApiV3Service service = ApiV3ServiceFactory.getApiV3Service(wxApiV3Config);
        Map<String, String> map = service.applyment(applymentInfo);
        System.out.println(map);
    }


    /**
     * 测试查询申请单状态
     *
     * @throws Exception
     */
    @Test
    public void applymentStatusTest() throws Exception {
        String s = "test";
        ApiV3Service service = ApiV3ServiceFactory.getApiV3Service(wxApiV3Config);
        ApplymentStatusResult applymentStatusResult = service.applymentStatus(s);
        System.out.println(applymentStatusResult.toString());
    }


    /**
     * 测试修改结算账号
     *
     * @throws Exception
     */
    @Test
    public void changeSubBankTest() throws Exception {
        String s = "1602952973";
        ApiV3Service service = ApiV3ServiceFactory.getApiV3Service(wxApiV3Config);
        BankAccountInfo bankAccountInfo = new BankAccountInfo();
        boolean b = service.changeSubBank(s, bankAccountInfo);
        System.out.println(b);
    }


    /**
     * 测试查询结算账号
     *
     * @throws Exception
     */
    @Test
    public void querySubMchTest() throws Exception {
        String s = "1602952973";
        ApiV3Service service = ApiV3ServiceFactory.getApiV3Service(wxApiV3Config);
        BankAccountResult bankAccountResult = service.querySubMch(s);
        System.out.println(bankAccountResult);
    }


    /**
     * 图片上传原图片路径
     */
    String filePath = "D:/portal/xuechen/xc-ui-pc-static-portal/img/asset-login_img.jpg";

    /**
     * 图片上传测试
     *
     * @throws Exception
     */
    @Test
    public void fileUploadTest() throws Exception {
        ApiV3Service service = ApiV3ServiceFactory.getApiV3Service(wxApiV3Config);
        Map<String, String> map = service.upload(filePath);
        System.out.println(map);
    }

}