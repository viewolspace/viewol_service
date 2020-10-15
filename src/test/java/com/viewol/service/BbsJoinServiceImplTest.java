package com.viewol.service;

import com.viewol.base.BaseTestClass;
import com.viewol.pojo.BbsJoin;
import org.junit.Test;

/**
 * Created by lenovo on 2018/6/28.
 */
public class BbsJoinServiceImplTest extends BaseTestClass{

    private IBbsJoinService service = (IBbsJoinService) getInstance("bbsJoinService");

    private BbsJoin beanBbsJoin(){
        BbsJoin user = new BbsJoin();
        user.setBbsId(1);
        user.setName("测试");
        user.setCompany("公司");
        user.setPhone("13800000000");
        user.setPosition("职位");
        user.setSex("男");
        return user;
    }

    @Test
    public void addBUser(){
        System.out.println(service.addBbsJoin(beanBbsJoin()));
    }


    @Test
    public void getBbsJoin(){
        System.out.println(service.getBbsJoin(1));

        System.out.println(service.getBbsJoin("13800000000",1));
    }
    @Test
    public void signIn(){
        System.out.println(service.signIn("13800000000",1));
    }

}
