package com.viewol.dao;

import com.viewol.pojo.UserDownload;

import java.util.List;

/**
 * Created by lenovo on 2018/7/17.
 */
public interface IUserDownloadDAO {

    int addUserDownload(UserDownload userDownload);


    UserDownload getUserDownload(int userId,int productId);


    List<UserDownload> listDownload(int userId,int num,int lastId);


    List<UserDownload> queryByIds(List<Integer> ids);
}
