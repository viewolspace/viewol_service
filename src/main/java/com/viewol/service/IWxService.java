package com.viewol.service;

import com.viewol.pojo.WxUserInfo;

/**
 * Created by lenovo on 2018/7/19.
 * 返回微信相关
 */
public interface IWxService {

    /**
     * 小程序获取登录后的session信息
     * @param jscode
     * @return
     */
    String getSessionInfo(String jscode);


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
    WxUserInfo getUserInfo(int userId);

    /**
     * 未关注微信公众号用户，拉取用户数据
     *
     * @param token
     * @param openId
     * @return
     */
    WxUserInfo getUserInfo(String token, String openId);
}
