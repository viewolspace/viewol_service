package com.viewol.dao;

import com.viewol.pojo.UserInteract;

import java.util.List;

/**
 * Created by lenovo on 2019/7/4.
 */
public interface IUserInteractDAO {

    int addUserInteract(UserInteract userInteract);

    List<UserInteract> queryList(int thirdId,int classify,int type,int num);

    List<UserInteract> queryUserInteract(int userId,int thirdId,int classify);


    UserInteract getUserInteract(int userId,int thirdId,int classify,int type);
}
