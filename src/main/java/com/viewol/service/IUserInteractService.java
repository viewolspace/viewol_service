package com.viewol.service;

import com.viewol.pojo.UserInteract;

import java.util.List;

/**
 * Created by lenovo on 2019/7/4.
 */
public interface IUserInteractService {

    UserInteract getUserInteract(int userId,int thirdId,int classify,int type);

    int userInteract(int userId , int thirdId , int classify , int type);

    int userComment(int userId, int classify,int thirdId, String comment);


    List<UserInteract> queryList(int thirdId,int classify,int type,int num);

    /**
     * 查询用户对展商是否评论 点赞
     * @param userId
     * @param thirdId
     * @param classify
     * @return
     */
    List<UserInteract> queryUserInteract(int userId,int thirdId,int classify);

    int reply(int id,String reply);

    //查询公司所有的评论
    List<UserInteract> queryComList(int companyId, int thirdId,int classify,int type,int maxId,int num);

}
