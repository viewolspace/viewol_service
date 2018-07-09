package com.viewol.dao;

import com.viewol.base.BaseTestClass;
import com.viewol.pojo.FUser;
import com.viewol.pojo.FUserBind;
import org.junit.Test;

/**
 * Created by lenovo on 2018/6/28.
 */
public class FUserBindDAOImplTest extends BaseTestClass{

    private IFUserBindDAO dao = (IFUserBindDAO)getInstance("fUserBindDAO");

    private FUser beanUser(){
        FUser user = new FUser();
        user.setUserId(1);
        user.setUserName("李四");
        user.setCompany("李四的公司");
        user.setPosition("总经理");
        user.setPhone("13811111113");
        user.setEmail("zhanngsan@gongsi.com");
        user.setAge(46);
        user.setUuid("aasdasdahiuhhjkjknkj2");
        return user;
    }

    @Test
    public void addFUserBind(){
        FUserBind userBind = new FUserBind();
        userBind.setUserId(1);
        userBind.setUuid("1111111111");
        userBind.setOpenId("11111");
        userBind.setType(1);
        System.out.println(dao.addFUserBind(userBind));
    }


    @Test
    public void isExist(){
        System.out.println(dao.isExist(1,"11111"));
    }

    @Test
    public void getOpenId(){
        System.out.println(dao.getOpenId(2,1));
    }

}
