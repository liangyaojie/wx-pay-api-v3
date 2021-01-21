package com.wechat.pay.v3.applyment.bean.info;

import java.util.List;

/**
 * 企业微信场景
 *
 * @author LYJ
 * @date 2021/1/15 15:37
 * @since 1.0
 */
public class WeWorkInfo {


    /**
     * 必填
     * 商家企业微信CorpID
     */
    private String subCorpId;

    /**
     * 必填
     * 企业微信页面截图
     */
    private List<String> weworkPics;


    public String getSubCorpId() {
        return subCorpId;
    }

    public void setSubCorpId(String subCorpId) {
        this.subCorpId = subCorpId;
    }

    public List<String> getWeworkPics() {
        return weworkPics;
    }

    public void setWeworkPics(List<String> weworkPics) {
        this.weworkPics = weworkPics;
    }
}
