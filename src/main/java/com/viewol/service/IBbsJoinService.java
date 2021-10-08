package com.viewol.service;

import com.viewol.pojo.BbsJoin;

import java.util.List;

/**
 * Created by lenovo on 2019/10/9.
 */
public interface IBbsJoinService {
    BbsJoin getBbsJoin(int id);

    BbsJoin getBbsJoin(String phone,int bbsId);

    int addBbsJoin(BbsJoin bbsJoin);

    int signIn(String phone,int bbsId);

    List<BbsJoin> listBbsJoin(int bbsId);
}
