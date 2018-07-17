package com.viewol.service;

import com.viewol.pojo.UserBrowse;

import java.util.List;

/**
 * Created by lenovo on 2018/7/17.
 */
public interface IUserBrowseService {

    int addUserBrowse(int userId,int type,int thirdId);

    List<UserBrowse> listUserBrowse(int userId,int type,int num,int lastId);
}
