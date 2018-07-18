package com.viewol.service;

import com.viewol.pojo.FUser;
import com.viewol.pojo.query.FUserQuery;
import com.youguu.core.util.PageHolder;

/**
 * Created by lenovo on 2018/7/6.
 */
public interface IFUserService {

    FUser getFuser(int uid);

    //添加用户 , openId,uuid,
    int addFUser(FUser fuser , String openId, String uuid, int type);

    //添加用户 , openId,uuid,
    int addFUser(String openId, String uuid, int type);


    //添加用户 , openId,uuid,
    int addFUser(FUser fuser , String answer, String openId, String uuid, int type);

    //修改用户数据
    int updateUser(FUser fuser);


    //修改用户数据
    int updateUser(FUser fuser, String answer);

    //获取用户的openid
    String getOpenId(int uid,int type);


    //查询用户列表
    PageHolder<FUser> querFUser(FUserQuery query);


}
