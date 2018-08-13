package com.viewol.service.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.viewol.dao.IFUserBindDAO;
import com.viewol.dao.IWxTokenDAO;
import com.viewol.pojo.FUserBind;
import com.viewol.pojo.WxToken;
import com.viewol.service.IWxService;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lenovo on 2018/7/19.
 */
@Service("wxService")
public class WxServiceImpl implements IWxService, InitializingBean {

    @Resource
    private IWxTokenDAO wxTokenDAO;
    @Resource
    private IFUserBindDAO ifUserBindDAO;

    @Autowired
    private WxMaService wxMaService;
    @Autowired
    private WxMpService wxMpService;


    @Override
    public WxMaJscode2SessionResult getSessionInfo(String jscode) {
        try {
            WxMaJscode2SessionResult result = wxMaService.getUserService().getSessionInfo(jscode);

            return result;
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public WxMaUserInfo getUserInfo(String sessionKey, String encryptedData, String ivStr) {
        try {
            WxMaUserInfo wxMaUserInfo = wxMaService.getUserService().getUserInfo(sessionKey, encryptedData, ivStr);
            return wxMaUserInfo;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
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
        try {
            String ticket = wxMpService.getJsapiTicket();
            return ticket;
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public boolean isFollow(int userId) {
        FUserBind userBind = ifUserBindDAO.getOpenId(userId, FUserBind.TYPE_WEIXIN);

        if(userBind==null){
            return false;
        }

        String openId = userBind.getOpenId();
        WxMpUser wxMpUser = null;
        try {
            wxMpUser = wxMpService.getUserService().userInfo(openId);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }

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

        try {
            String access_token = wxMpService.getAccessToken(false);
            return this.getUserInfo(access_token,openId);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public WxMpUser getUserInfo(String token, String openId) {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        wxMpOAuth2AccessToken.setAccessToken(token);
        wxMpOAuth2AccessToken.setOpenId(openId);

        try {
            WxMpUser wxMpUser = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
            return wxMpUser;
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public WxMpOAuth2AccessToken getAccessToken(String jscode) {
        try {
            WxMpOAuth2AccessToken accessToken = wxMpService.oauth2getAccessToken(jscode);
            return accessToken;
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String sendTemplateMsg(WxMpTemplateMessage message) {
        try {
            return wxMpService.getTemplateMsgService().sendTemplateMsg(message);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return "-1";
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
