package com.viewol.wx.config;

import com.viewol.dao.IWxTokenDAO;
import me.chanjar.weixin.common.bean.WxAccessToken;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;

import javax.annotation.Resource;

/**
 * 公众号配置缓存类
 * accessToken，jsapiTicket存储数据库，同时内存缓存
 */
public class WxMpInMysqlConfigStorage extends WxMpInMemoryConfigStorage {

    @Resource
    private IWxTokenDAO wxTokenDAO;

    @Override
    public synchronized void updateAccessToken(WxAccessToken accessToken) {
        super.updateAccessToken(accessToken);
        wxTokenDAO.updateToken(this.getAppId(), accessToken.getAccessToken());
    }

    @Override
    public synchronized void updateAccessToken(String accessToken, int expiresInSeconds) {
        super.updateAccessToken(accessToken, expiresInSeconds);
        wxTokenDAO.updateToken(this.getAppId(), accessToken);
    }

    @Override
    public synchronized void updateJsapiTicket(String jsapiTicket, int expiresInSeconds) {
        super.updateJsapiTicket(jsapiTicket, expiresInSeconds);
        wxTokenDAO.uodateJsapiTicket(this.getAppId(), jsapiTicket);
    }
}