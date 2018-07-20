package com.viewol.wx.config;

import cn.binarywang.wx.miniapp.config.WxMaInMemoryConfig;
import com.viewol.dao.IWxTokenDAO;
import me.chanjar.weixin.common.bean.WxAccessToken;

import javax.annotation.Resource;

public class WxMaInMysqlConfig extends WxMaInMemoryConfig {

    @Resource
    private IWxTokenDAO wxTokenDAO;

    @Override
    public synchronized void updateAccessToken(WxAccessToken accessToken) {
        super.updateAccessToken(accessToken);
        wxTokenDAO.updateToken(this.getAppid(), accessToken.getAccessToken());
    }

    @Override
    public synchronized void updateAccessToken(String accessToken, int expiresInSeconds) {
        super.updateAccessToken(accessToken, expiresInSeconds);
        wxTokenDAO.updateToken(this.getAppid(), accessToken);
    }
}
