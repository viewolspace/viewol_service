package com.viewol.service;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

import java.io.File;

/**
 * Created by lenovo on 2018/7/19.
 * 返回微信相关
 */
public interface IWxService {

    String getAccessToken();

    /**
     * 小程序获取登录后的session信息
     * @paran maNum 1 观展通  2 观展讯
     * @param code
     * @return
     */
    WxMaJscode2SessionResult getSessionInfo(int maNum,String code);

    /**
     * 小程序获取用户信息
     * @paran type 1 观展通  3 观展讯
     * @param sessionKey    会话密钥
     * @param encryptedData 消息密文
     * @param ivStr         加密算法的初始向量
     * @return
     */
    WxMaUserInfo getUserInfo(int type,String sessionKey, String encryptedData, String ivStr);

    /**
     * 获取手机号码
     * @paran maNum 1 观展通  3 观展讯
     * @param sessionKey
     * @param encryptedData
     * @param ivStr
     * @return
     */
    WxMaPhoneNumberInfo getPhoneNumberInfo(int maNum,String sessionKey, String encryptedData, String ivStr);


    /**
     * 查询基础token
     * @param appId
     * @return
     */
    String getTokenFromDb(String appId);

    /**
     *
     * @return
     */
    String getJsapiTicket();

    /**
     * 判断用户是否关注了公众号
     *
     * @param userId
     * @return
     */
    boolean isFollow(int userId);

    /**
     * 已关注微信公众号用户，拉取用户数据
     *
     * @param userId
     * @return
     */
    WxMpUser getUserInfo(int userId);

    /**
     * 已关注微信公众号用户，拉取用户数据
     *
     * @param openId
     * @return
     */
    WxMpUser getUserInfo(String openId);

    /**
     * 未关注微信公众号用户，拉取用户数据
     *
     * @param token
     * @param openId
     * @return
     */
    WxMpUser getUserInfo(String token, String openId);

    WxMpOAuth2AccessToken getAccessToken(String jscode);

    /**
     * 发送公众号模板消息
     * @param scheduleId 活动ID
     * @param userId 用户ID
     * @param uuid 微信unionid
     * @return msgId
     */
    String sendTemplateMsg(int scheduleId, int userId, String uuid, String templateId, String url);


    /**
     * 获取展商小程序码（永久有效、数量暂无限制）.
     * @param companyId 展商ID
     * @param bUserId 业务员ID
     * @param page      必须是已经发布的小程序页面，例如 "pages/index/index" ,如果不填写这个字段，默认跳主页面
     * @return
     */
    File createCompanyWxaCode(int maNum,int type, int companyId, int bUserId, String page, int width);

    /**
     * 获取产品小程序码（永久有效、数量暂无限制）.
     * @param companyId 展商ID
     * @param productId 产品ID
     * @param page      必须是已经发布的小程序页面，例如 "pages/index/index" ,如果不填写这个字段，默认跳主页面
     * @return
     */
    File createProductWxaCode(int maNum,int type, int companyId, int productId, String page, int width);

    File createPublicxaCode(int maNum,String page , String scene , int width);

    /**
     * 生成小程序的二维码
     * @param width
     * @param page
     * @return
     */
    File createProgramWxaCode(int maNum,int width, String page);


    /**
     * 生成小程序的二维码 透明底色
     * @param width
     * @param page
     * @return
     */
    File createPNGProgramWxaCode(int maNum,int width, String page);


    /**
     * 生成小程序的二维码 透明底色
     * @param width
     * @param page
     * @return
     */
    File createPNGPublicxaCode(int maNum,String page , String scene , int width);

    /**
     * <pre>
     * 创建调用jsapi时所需要的签名
     *
     * 详情请见：http://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141115&token=&lang=zh_CN
     * </pre>
     */
    WxJsapiSignature createJsapiSignature(String url);

    /**
     * 生成海报

     */
    String genPlaybill(int userId,String userNickName,String headPic)  throws Exception;
}
