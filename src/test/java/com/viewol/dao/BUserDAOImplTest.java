package com.viewol.dao;

import com.viewol.base.BaseTestClass;
import com.viewol.pojo.BUser;
import org.junit.Test;

/**
 * Created by lenovo on 2018/6/28.
 */
public class BUserDAOImplTest extends BaseTestClass{

    private IBUserDAO dao = (IBUserDAO) getInstance("bUserDAO");

    private BUser beanUser(){
        BUser user = new BUser();
        user.setUserId(1);
        user.setUserName("李四q");
        user.setCompanyId(1);
        user.setPosition("总经理");
        user.setPhone("13811111113");
        user.setStatus(0);
        user.setOpenId("q123123123123123123");
        user.setUuid("waasdasdahiuhhjkjknkj2");
        return user;
    }

    @Test
    public void addBUser(){
        System.out.println(dao.addBUser(beanUser()));
    }



    @Test
    public void upDateBUser(){
        System.out.println(dao.upDateBUser(beanUser()));
    }

    @Test
    public void setStatus(){
        System.out.println(dao.setStatus(1,BUser.STATUS_OK));
    }

    @Test
    public void getBUser(){
        System.out.println(dao.getBUser(1));
        System.out.println(dao.getBUser("123123123123123123"));
    }

    @Test
    public void listByCom(){
        System.out.println(dao.listByCom(1));
    }



}
