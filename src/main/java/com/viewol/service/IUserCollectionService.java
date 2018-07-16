package com.viewol.service;

import com.viewol.pojo.UserCollection;

import java.util.List;

/**
 * Created by lenovo on 2018/7/16.
 */
public interface IUserCollectionService {

    int addUserCollection(int userId,int type,int thirdId);


    int delUserCollection(int userId,int type,int thirdId);


    int isCollection(int userId,int type,int thirdId);


    List<UserCollection> listUserCollection(int userId,int type,int num,int lastId);
}
