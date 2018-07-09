package com.viewol.dao;

import com.viewol.base.BaseTestClass;
import com.viewol.pojo.FUser;
import com.viewol.pojo.query.FUserQuery;
import com.youguu.core.util.PageHolder;
import org.junit.Test;

/**
 * Created by lenovo on 2018/6/28.
 */
public class FUserDAOImplTest extends BaseTestClass{

    private IFUserDAO dao = (IFUserDAO)getInstance("fUserDAO");

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
    public void addFUser(){
        System.out.println(dao.addFUser(beanUser()));
    }

    @Test
    public void updateFUser(){
        System.out.println(dao.updateFUser(beanUser()));
    }

    @Test
    public void getFuser(){
        System.out.println(dao.getFuser(1));
    }

    @Test
    public void getUserByUuid(){
        System.out.println(dao.getUserByUuid("aasdasdahiuhhjkjknkj"));
    }

    @Test
    public void querFUser(){
        FUserQuery query = new FUserQuery();
        query.setUserName("张三");
        query.setEmail("zhanngsan@gongsi.com");
        query.setCompany("张三");
        query.setPhone("13811111111");
        PageHolder<FUser> pageHolder = dao.querFUser(query);
        System.out.println(pageHolder);
        if(pageHolder!=null && pageHolder.size()>0){

            for(FUser user:pageHolder.getList()){
                System.out.println(user);
            }
        }
    }


}
