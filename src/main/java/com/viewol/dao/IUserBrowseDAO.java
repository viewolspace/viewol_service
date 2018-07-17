package com.viewol.dao;

import com.viewol.pojo.UserBrowse;

import java.util.List;

/**
 * Created by lenovo on 2018/7/17.
 */
public interface IUserBrowseDAO {

    int addUserBrowse(UserBrowse userBrowse);

    List<UserBrowse> listUserBrowse(int userId,int type,int num,int lastId);
}
