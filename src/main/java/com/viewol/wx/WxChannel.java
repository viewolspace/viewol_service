package com.viewol.wx;


import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class WxChannel {

    public static final Log logger = LogFactory.getLog(WxChannel.class);
    @Autowired
    private WxMaService wxMaService;
    @Autowired
    protected WxMpService wxMpService;

    public WxChannel() {
    }

    /***初始化变量值***/
    //获取access_token
    private String grant_type = "client_credential";

    /**
     * 获取token的url
     */
    private String tokenUrl = "https://api.weixin.qq.com/cgi-bin/token";


    /**
     * 通过CODE 拉toKen
     */
    private String getUserTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
    private String getUserUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN";


    private String getUserFollowUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s&lang=zh_CN";


    private String imgTicket_url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=";

    //公众号发送模板消息
    private String send_msg_url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";


    private long lasttime = 0;

    /**
     * 小程序获取登录后的session信息
     * 临时登录凭证校验接口是一个 HTTPS 接口，开发者服务器使用 临时登录凭证code 获取 session_key 和 openid 等。
     * @param jscode 小程序调用wx.login()获取的code
     * @return
     */
    public String getSessionInfo(String jscode){
        try {
            WxMaJscode2SessionResult result = wxMaService.getUserService().getSessionInfo(jscode);
            return JSON.toJSONString(result);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return null;
    }



    /**
     * 获取小程序授权token，这个接口暂时应该用不上。
     * @param flag 0-正常获取，会根据缓存判断；1-强制刷新
     * @return
     */
    public String getMaToken(int flag) {
        try {
            String access_token = wxMaService.getAccessToken(flag == 1? true: false);
            return access_token;
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取公众号授权基础token，后面查询用户是否关注公众号会使用
     * @param flag 0-正常获取，会根据缓存判断；1-强制刷新
     * @return
     */
    public String getMpToken(int flag) {
        try {
            String access_token = wxMpService.getAccessToken(flag == 1? true: false);
            return access_token;
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取用户网页授权AccessToken
     * @param code
     * @return
     */
    public String getAccessToken(String code){
        try {
            WxMpOAuth2AccessToken accessToken = wxMpService.oauth2getAccessToken(code);
            JSON.toJSONString(accessToken);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 网页授权，拉取用户信息(需scope为 snsapi_userinfo)
     * @param token 网页授权access_token
     * @param openid
     * @return
     */
    public String getUser(String token, String openid) {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        wxMpOAuth2AccessToken.setAccessToken(token);
        wxMpOAuth2AccessToken.setOpenId(openid);

        try {
            WxMpUser wxMpUser = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
            return JSON.toJSONString(wxMpUser);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * jsapi_ticket是公众号用于调用微信JS接口的临时票据。
     * 正常情况下，jsapi_ticket的有效期为7200秒，通过access_token来获取。
     * 由于获取jsapi_ticket的api调用次数非常有限，频繁刷新jsapi_ticket会导致api调用受限，
     * 影响自身业务，开发者必须在自己的服务全局缓存jsapi_ticket。
     * 接口地址：https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi
     * access_token为基础token，非网页授权token
     * @return
     */
    public String getJsapiTicket() {
        try {
            String ticket = wxMpService.getJsapiTicket();
            return ticket;
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 判断用户是否关注了公众号
     * 接口地址：https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s&lang=zh_CN
     * 此接口的access_token是接口基础调用access_token，不是网页授权access_token
     * WxMpService接口调用默认会带上基础access_token,不需要从外部传入
     * @param openid
     * @return
     */
    public String getUserFollowInfo(String openid) {
        try {
            WxMpUser wxMpUser = wxMpService.getUserService().userInfo(openid);
            return JSON.toJSONString(wxMpUser);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 推送模板信息
     *
     * @param openid
     * @param template_id
     * @param msg
     * @return
     */
    private String sendMsg(String openid, String template_id, JSONObject msg) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder().toUser(openid).templateId(template_id).url("").build();

            WxMpTemplateData firstData = new WxMpTemplateData("first", dateFormat.format(new Date()), "#FF00FF");
            WxMpTemplateData remarkData = new WxMpTemplateData("remark", RandomStringUtils.randomAlphanumeric(100), "#FF00FF");
            templateMessage.addData(firstData).addData(remarkData);

            String msgId = this.wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
            return msgId;
        } catch (WxErrorException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {


    }
}
