package com.viewol.dao;

import com.viewol.pojo.UserInteract;
import com.viewol.pojo.query.UserInteractQuery;
import com.youguu.core.util.PageHolder;

import java.util.List;

/**
 * Created by lenovo on 2019/7/4.
 */
public interface IUserInteractDAO {

    int addUserInteract(UserInteract userInteract);

    int reply(int id, String reply);

    List<UserInteract> queryList(int thirdId, int classify, int type, int num);

    List<UserInteract> queryUserInteract(int userId, int thirdId, int classify);

    UserInteract getUserInteract(int userId, int thirdId, int classify, int type);

    //查询公司所有的评论
    List<UserInteract> queryComList(int companyId, int thirdId, int classify, int type, int maxId, int num);

    PageHolder<UserInteract> queryUserInteract(UserInteractQuery query);

}
