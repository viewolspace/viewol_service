package com.viewol.service.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.viewol.dao.IFUserBindDAO;
import com.viewol.dao.IWxTokenDAO;
import com.viewol.pojo.FUserBind;
import com.viewol.pojo.Schedule;
import com.viewol.pojo.WxToken;
import com.viewol.service.IFUserService;
import com.viewol.service.IScheduleService;
import com.viewol.service.IWxService;
import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.text.SimpleDateFormat;

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

    @Resource
    private IScheduleService scheduleService;
    @Resource
    private IFUserService fUserService;


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
    public String sendTemplateMsg(int scheduleId, int userId, String uuid, String templateId, String url) {
        try {
            Schedule schedule = scheduleService.getSchedule(scheduleId);
            if(schedule == null){
                return "-1";
            }

            SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String openId = fUserService.getOpenId(userId, FUserBind.TYPE_WEIXIN);
            String title = schedule.getTitle();
            String time = dft.format(schedule.getsTime());
            String place = schedule.getPlace();
            String remark = "请您合理安排时间，准时参加会议";

            WxMpTemplateMessage remindTemplate = WxMpTemplateMessage.builder().build();
            remindTemplate.setToUser(openId);
            remindTemplate.setTemplateId(templateId);
            remindTemplate.setUrl(url);
            WxMpTemplateData titleData = new WxMpTemplateData("keyword1", title);
            WxMpTemplateData scheduleTimeData = new WxMpTemplateData("keyword2", time);
            WxMpTemplateData schedulePlaceData = new WxMpTemplateData("keyword3", place);
            WxMpTemplateData remarkData = new WxMpTemplateData("keyword5", remark);
            remindTemplate.addData(titleData)
                    .addData(scheduleTimeData)
                    .addData(schedulePlaceData)
                    .addData(remarkData);

            return wxMpService.getTemplateMsgService().sendTemplateMsg(remindTemplate);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return "-1";
    }

    @Override
    public File createCompanyWxaCode(int type, int companyId, int fUserId, String page) {
        try {
            StringBuffer scene = new StringBuffer();
            scene.append("a=").append(type).append("&")
                    .append("c=").append(companyId).append("&")
                    .append("u=").append(fUserId);
            return wxMaService.getQrcodeService().createWxaCodeUnlimit(scene.toString(), page);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public File createProductWxaCode(int type, int companyId, int productId, String page) {
        try {
            StringBuffer scene = new StringBuffer();
            scene.append("a=").append(type).append("&")
                    .append("c=").append(companyId).append("&")
                    .append("p=").append(productId);
            return wxMaService.getQrcodeService().createWxaCodeUnlimit(scene.toString(), page);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public WxJsapiSignature createJsapiSignature(String url) {
        try {
            return wxMpService.createJsapiSignature(url);
        }catch (WxErrorException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
