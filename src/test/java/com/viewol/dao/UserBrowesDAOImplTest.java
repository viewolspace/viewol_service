package com.viewol.dao;

import com.viewol.base.BaseTestClass;
import com.viewol.pojo.UserBrowse;
import org.junit.Test;

/**
 * Created by lenovo on 2018/6/28.
 */
public class UserBrowesDAOImplTest extends BaseTestClass{

    private IUserBrowseDAO dao = (IUserBrowseDAO)getInstance("userBrowseDAO");

    @Test
    public void addUserBrowse(){
        UserBrowse userBrowse = new UserBrowse();
        userBrowse.setUserId(1);
        userBrowse.setType(1);
        userBrowse.setThirdId(1);
        System.out.println(dao.addUserBrowse(userBrowse));


    }

}
