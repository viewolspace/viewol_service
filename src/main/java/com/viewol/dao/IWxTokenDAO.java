package com.viewol.dao;

import com.viewol.pojo.WxToken;

/**
 * Created by lenovo on 2018/7/19.
 */
public interface IWxTokenDAO {

    int updateToken(int type,String token);

    WxToken getWxToken(int type);
}
