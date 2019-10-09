package com.viewol.service;

import com.viewol.pojo.BbsJoin;

/**
 * Created by lenovo on 2019/10/9.
 */
public interface IBbsJoinService {
    BbsJoin getBbsJoin(int id);

    BbsJoin getBbsJoin(String phone);

    int addBbsJoin(BbsJoin bbsJoin);

    int signIn(String phone);
}
