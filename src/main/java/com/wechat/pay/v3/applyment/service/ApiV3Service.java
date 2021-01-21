package com.wechat.pay.v3.applyment.service;

import com.wechat.pay.v3.applyment.bean.info.ApplymentInfo;
import com.wechat.pay.v3.applyment.bean.info.BankAccountInfo;
import com.wechat.pay.v3.applyment.bean.result.ApplymentStatusResult;
import com.wechat.pay.v3.applyment.bean.result.BankAccountResult;

import java.io.IOException;
import java.util.Map;

/**
 * @author LYJ
 * @date 2021/1/15 16:30
 * @since 1.0
 */
public interface ApiV3Service {

    /**
     * 提交申请单请求url
     */
    public static final String APPLYMENT_URL = "https://api.mch.weixin.qq.com/v3/applyment4sub/applyment/";


    /**
     * 查询申请单状态请求url
     */
    public static final String SEARCH_APPLY_STATUS_URL = "https://api.mch.weixin.qq.com/v3/applyment4sub/applyment/business_code/{business_code}";

    /**
     * 修改结算账号请求url
     */
    public static final String CHANGE_SUB_MCH_BANK_URL = "https://api.mch.weixin.qq.com/v3/apply4sub/sub_merchants/{sub_mchid}/modify-settlement";

    /**
     * 查询结算账号请求url
     */
    public static final String QUERY_SUB_MCH_BANK_URL = "https://api.mch.weixin.qq.com/v3/apply4sub/sub_merchants/{sub_mchid}/settlement";

    /**
     * 图片上传请求url
     */
    public static final String UPLOAD_FILE_URL = "https://api.mch.weixin.qq.com/v3/merchant/media/upload";


    /**
     * 提交申请单接口
     *
     * @param applymentInfo
     * @return
     * @throws Exception
     */
    Map<String, String> applyment(ApplymentInfo applymentInfo) throws Exception;


    /**
     * 查询申请单状态
     *
     * @param businessCode
     * @return
     * @throws IOException
     */
    ApplymentStatusResult applymentStatus(String businessCode) throws IOException;

    /**
     * 修改结算账号
     *
     * @param subMchId
     * @param bankAccountInfo
     * @return
     * @throws Exception
     */
    boolean changeSubBank(String subMchId, BankAccountInfo bankAccountInfo) throws Exception;

    /**
     * 查询结算账号
     *
     * @param subMchId
     * @return
     * @throws IOException
     */
    BankAccountResult querySubMch(String subMchId) throws IOException;

    /**
     * 图片上传
     *
     * @param filePath
     * @return
     * @throws Exception
     */
    Map<String, String> upload(String filePath) throws Exception;


}
