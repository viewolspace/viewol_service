package com.viewol.service.impl;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.viewol.dao.IFUserBindDAO;
import com.viewol.dao.IWxTokenDAO;
import com.viewol.pojo.FUserBind;
import com.viewol.pojo.WxToken;
import com.viewol.pojo.WxUserInfo;
import com.viewol.service.IWxService;
import com.viewol.wx.WxChannel;
import com.youguu.core.util.ClassCast;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lenovo on 2018/7/19.
 */
@Service("wxService")
public class WxServiceImpl implements IWxService {

    @Resource
    private IWxTokenDAO wxTokenDAO;

    @Resource
    private IFUserBindDAO ifUserBindDAO;

    @Override
    public WxMaJscode2SessionResult getSessionInfo(String jscode) {
        WxChannel wxChannel = WxChannel.getInstance();
        return wxChannel.getSessionInfo(jscode);
    }

    @Override
    public WxMaUserInfo getUserInfo(String sessionKey, String encryptedData, String ivStr) {
        WxChannel wxChannel = WxChannel.getInstance();
        return wxChannel.getUserInfo(sessionKey, encryptedData, ivStr);
    }

    @Override
    public String getTokenFromDb(String appId) {
        WxToken wxToken = wxTokenDAO.getWxToken(appId);
        if(wxToken!=null){
            return wxToken.getToken();
        }
        return null;
    }

    @Override
    public String getJsapiTicket() {
        WxChannel wxChannel = WxChannel.getInstance();
        String jsapi_ticket =  wxChannel.getJsapiTicket();

        return jsapi_ticket;
    }


    @Override
    public boolean isFollow(int userId) {
        FUserBind userBind = ifUserBindDAO.getOpenId(userId, FUserBind.TYPE_WEIXIN);

        if(userBind==null){
            return false;
        }

        String openId = userBind.getOpenId();
        WxChannel wxChannel = WxChannel.getInstance();
        WxMpUser wxMpUser = wxChannel.getUserFollowInfo(openId);

        if(wxMpUser != null){
           return wxMpUser.getSubscribe();
        }

        return false;
    }


    @Override
    public WxMpUser getUserInfo(int userId) {
        FUserBind userBind = ifUserBindDAO.getOpenId(userId, FUserBind.TYPE_WEIXIN);

        if(userBind==null){
            return null;
        }
        String openId = userBind.getOpenId();
        WxChannel wxChannel = WxChannel.getInstance();
        String token = wxChannel.getMpToken(0);
        return this.getUserInfo(token,openId);
    }

    @Override
    public WxMpUser getUserInfo(String token, String openId) {
        WxChannel wxChannel = WxChannel.getInstance();
        WxMpUser wxMpUser = wxChannel.getUser(token, openId);
        return wxMpUser;
    }

    @Override
    public WxMpOAuth2AccessToken getAccessToken(String jscode) {
        WxChannel wxChannel = WxChannel.getInstance();
        return wxChannel.getAccessToken(jscode);
    }
}
