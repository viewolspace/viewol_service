package com.viewol.dao;

import com.viewol.base.BaseTestClass;
import com.viewol.pojo.UserCollection;
import org.junit.Test;

/**
 * Created by lenovo on 2018/6/28.
 */
public class UserCollectionDAOImplTest extends BaseTestClass{

    private IUserCollectionDAO dao = (IUserCollectionDAO)getInstance("userCollectionDAO");

    @Test
    public void addUserCollection(){
        UserCollection userCollection = new UserCollection();
        userCollection.setUserId(1);
        userCollection.setType(0);
        userCollection.setName("测试");
        userCollection.setThirdId(1);

        System.out.println(dao.addUserCollection(userCollection));


    }


    @Test
    public void delUserCollection(){
        System.out.println(dao.delUserCollection(1,1,1));
    }

    @Test
    public void isCollection(){
        System.out.println(dao.isCollection(1,0,1));
    }

    @Test
    public void listUserCollection(){
        System.out.println(dao.listUserCollection(1,0,10,0));
    }

}
