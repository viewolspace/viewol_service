package com.viewol.dao;

import com.viewol.pojo.FUserBind;

/**
 * Created by lenovo on 2018/7/5.
 */
public interface IFUserBindDAO {

    int addFUserBind(FUserBind userBind);

    boolean isExist(int type,String openId);

    FUserBind getOpenId(int userId,int type);

    FUserBind getFUserBind(String openId,int type);
}
