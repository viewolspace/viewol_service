package com.viewol.service;

import com.viewol.pojo.BUser;

import java.util.List;

/**
 * Created by lenovo on 2018/7/9.
 */
public interface IBUserService {

    //通过公司id获取
    List<BUser> listByCom(int comId);

    BUser getBUser(int uid);

    BUser getBUser(String openId);

    int addBUser(BUser user);

    int upDateBUser(BUser user);

    int setStatus(int userId,int status);
}
