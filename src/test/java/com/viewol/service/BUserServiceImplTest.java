package com.viewol.service;

import com.viewol.base.BaseTestClass;
import com.viewol.pojo.BUser;
import org.junit.Test;

/**
 * Created by lenovo on 2018/6/28.
 */
public class BUserServiceImplTest extends BaseTestClass{

    private IBUserService service = (IBUserService) getInstance("bUserService");

    private BUser beanUser(){
        BUser user = new BUser();
        user.setUserId(1);
        user.setUserName("李四1q");
        user.setCompanyId(1);
        user.setPosition("总经理");
        user.setPhone("13811111116");
        user.setStatus(0);
        user.setOpenId("1q123123123123123123");
        user.setUuid("waasdasdahiuhhjkjknkj2");
        return user;
    }

    @Test
    public void addBUser(){
        System.out.println(service.addBUser(beanUser()));
    }

    @Test
    public void getFirstBuser(){
        System.out.println(service.getFirstBuser(2));
    }



    @Test
    public void upDateBUser(){
        System.out.println(service.upDateBUser(beanUser()));
    }

    @Test
    public void setStatus(){
        System.out.println(service.setStatus(1, BUser.STATUS_OK));
    }

    @Test
    public void getBUser(){
        System.out.println(service.getBUser(1));
        System.out.println(service.getBUser("123123123123123123"));
    }

    @Test
    public void listByCom(){
        System.out.println(service.listByCom(1));
    }



}
