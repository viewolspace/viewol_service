package com.viewol.dao;

import com.viewol.pojo.BbsJoin;

/**
 * Created by lenovo on 2019/10/9.
 */
public interface IBbsJoinDAO {

    BbsJoin getBbsJoin(int id);

    BbsJoin getBbsJoin(String phone);

    int addBbsJoin(BbsJoin bbsJoin);

    int signIn(int id,int status);
}
