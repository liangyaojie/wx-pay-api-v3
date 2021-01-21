package com.wechat.pay.v3.applyment.bean.info;

import java.util.List;

/**
 * @author LYJ
 * @date 2021/1/15 15:12
 * @since 1.0
 */
public class MiniProgramInfo {


    /**
     * 服务商小程序APPID
     * 与商家小程序appId二选一
     */
    private String miniProgramAppId;

    /**
     * 商家小程序APPID
     * 与服务商小程序appId二选一
     */
    private String miniProgramSubAppId;

    /**
     * 条件选填
     * 小程序截图
     */
    private List<String> miniProgramPics;

    public String getMiniProgramAppId() {
        return miniProgramAppId;
    }

    public void setMiniProgramAppId(String miniProgramAppId) {
        this.miniProgramAppId = miniProgramAppId;
    }

    public String getMiniProgramSubAppId() {
        return miniProgramSubAppId;
    }

    public void setMiniProgramSubAppId(String miniProgramSubAppId) {
        this.miniProgramSubAppId = miniProgramSubAppId;
    }

    public List<String> getMiniProgramPics() {
        return miniProgramPics;
    }

    public void setMiniProgramPics(List<String> miniProgramPics) {
        this.miniProgramPics = miniProgramPics;
    }
}
