package com.viewol.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by lenovo on 2018/7/19.
 * 返回微信相关
 */
public interface IWxService {

    /**
     * 生成token 并存储 -- 定时任务使用
     * @param type
     * @return
     */
    String generateToken(int type);


    /**
     * type 1 公众号  2 小程序
     * @param type
     * @return
     */
    String getTokenFromDb(int type);

    /**
     * 生成ticket 并存储
     * @return
     */
    String generateJsapiTicket();


    String jsapiTicket();

    /**
     * 用户是否关注了公众号
     * @param userId
     * @return
     */
    boolean isFollow(int userId);

    /**
     * 拉取用户数据
     * @param userId
     * @return
     */
    JSONObject getUserInfo(int userId);

    /**
     * 拉取用户数据
     * @param token
     * @param openId
     * @return
     */
    JSONObject getUserInfo(String token,String openId);
}
