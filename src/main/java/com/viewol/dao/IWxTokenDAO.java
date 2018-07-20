package com.viewol.dao;

import com.viewol.pojo.WxToken;

/**
 * Created by lenovo on 2018/7/19.
 */
public interface IWxTokenDAO {

    int updateToken(String appId, String token);

    int uodateJsapiTicket(String appId, String jsapiTicket);

    WxToken getWxToken(String appId);
}
