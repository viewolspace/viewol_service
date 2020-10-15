package com.viewol.dao;

import com.viewol.pojo.BUser;
import com.viewol.pojo.query.BUserQuery;
import com.youguu.core.util.PageHolder;

import java.util.List;

/**
 * Created by lenovo on 2018/7/9.
 */
public interface IBUserDAO {
    //通过公司id获取
    List<BUser> listByCom(int comId);

    BUser getBUser(int uid);

    //获取公司第一个业务员
    BUser getFirstBuser(int comId);

    BUser getBUser(String openId);

    BUser getBUserByUuid(String uuid);

    int addBUser(BUser user);

    int upDateBUser(BUser user);

    int setStatus(int userId,int status);

    PageHolder<BUser> queryBUser(BUserQuery query);
}
