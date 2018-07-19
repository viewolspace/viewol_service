package com.viewol.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.viewol.dao.IFUserBindDAO;
import com.viewol.dao.IWxTokenDAO;
import com.viewol.pojo.FUserBind;
import com.viewol.pojo.WxToken;
import com.viewol.service.IWxService;
import com.viewol.wx.WxChannel;
import com.viewol.wx.WxChannelCache;
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
    public String generateToken(int type) {

        WxChannel wxChannel = WxChannelCache.getWxChannel(type);

        String token = wxChannel.getToken(type);

        if(token==null){
            return null;
        }

        int result = wxTokenDAO.updateToken(type,token);

        if(result>0){
            return token;
        }else{
            return null;
        }

    }

    @Override
    public String getTokenFromDb(int type) {
        WxToken wxToken = wxTokenDAO.getWxToken(type);
        if(wxToken!=null){
            return wxToken.getToken();
        }
        return null;
    }

    @Override
    public String generateJsapiTicket() {

        String access_token = this.getTokenFromDb(WxToken.TYPE_WX);

        WxChannel wxChannel = WxChannelCache.getWxChannel(WxToken.TYPE_WX);

        JSONObject json = wxChannel.getJsapi(access_token);
        if(json==null){
            return null;
        }
        int errcode = json.getIntValue("errcode");
        if(0 == errcode){
            String jsapi_ticket = json.getString("ticket");
            int result = wxTokenDAO.updateToken(WxToken.TYPE_JSPAPI,jsapi_ticket);
            if(result > 0){
                return jsapi_ticket;
            }
        }else if(40001 == errcode || 42001 == errcode){
            //token 可能无效或者过期 -- 强制重新生成一下
            this.generateToken(WxToken.TYPE_WX);
        }
        return null;
    }

    @Override
    public String jsapiTicket() {
        WxToken wxToken = wxTokenDAO.getWxToken(WxToken.TYPE_JSPAPI);
        if(wxToken!=null){
            return wxToken.getToken();
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

        WxToken wxToken = wxTokenDAO.getWxToken(WxToken.TYPE_WX);

        WxChannel wxChannel = WxChannelCache.getWxChannel(WxToken.TYPE_WX);

        String response = wxChannel.getUserFollowInfo(wxToken.getToken(), openId);

        if(response!=null){
            JSONObject json = JSON.parseObject(response);
            int errcode = json.getIntValue("errcode");
            if(0 == errcode){
                int subscribe = json.getIntValue("subscribe");
                if(subscribe!=0){
                    return true;
                }
            }
        }

        return false;
    }


    @Override
    public JSONObject getUserInfo(int userId) {
        FUserBind userBind = ifUserBindDAO.getOpenId(userId, FUserBind.TYPE_WEIXIN);

        if(userBind==null){
            return null;
        }
        String openId = userBind.getOpenId();

        WxToken wxToken = wxTokenDAO.getWxToken(WxToken.TYPE_WX);

        return this.getUserInfo(wxToken.getToken(),openId);
    }

    @Override
    public JSONObject getUserInfo(String token, String openId) {
        WxChannel wxChannel = WxChannelCache.getWxChannel(WxToken.TYPE_WX);
        String response = wxChannel.getUser(token, openId);
        if(response!=null){
            JSONObject jsonObject = JSONObject.parseObject(response);
            return jsonObject;
        }
        return null;
    }
}
