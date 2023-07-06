package com.viewol.dao;

import com.viewol.base.BaseTestClass;
import com.viewol.pojo.ApplyUser;
import com.viewol.pojo.query.ApplyUserQuery;
import org.junit.Test;

/**
 * Created by lenovo on 2018/6/28.
 */
public class ApplyUserDAOImplTest extends BaseTestClass{

    private IApplyUserDAO dao = (IApplyUserDAO)getInstance("applyUserDAO");


    private ApplyUser beanApplyUser(){
        ApplyUser applyUser = new ApplyUser();
        applyUser.setCompanyName("测试的1");
        applyUser.setStatus(0);
        applyUser.setCompanyPic("/data/a.jsp");
        applyUser.setPhone("13899999998");
        return applyUser;
    }


    @Test
    public void addApplyUser(){
        System.out.println(dao.addApplyUser(beanApplyUser()));

    }


    @Test
    public void updateStatus(){
        System.out.println(dao.updateStatus(1,2));
    }

    @Test
    public void isApply(){
        System.out.println(dao.isApply("13899999999"));
    }

    @Test
    public void queryBUser(){
        ApplyUserQuery query = new ApplyUserQuery();
        query.setStatus(0);
        System.out.println(dao.queryBUser(query));
    }



}
