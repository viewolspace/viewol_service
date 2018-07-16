package com.viewol.service;

import com.viewol.base.BaseTestClass;
import com.viewol.pojo.UserCollection;
import org.junit.Test;

/**
 * Created by lenovo on 2018/6/28.
 */
public class UserCollectionServiceImplTest extends BaseTestClass{

    private IUserCollectionService service = (IUserCollectionService)getInstance("userCollectionService");

    @Test
    public void addUserCollection(){
        UserCollection userCollection = new UserCollection();
        userCollection.setUserId(1);
        userCollection.setType(0);
        userCollection.setName("测试");
        userCollection.setThirdId(1);

        System.out.println(service.addUserCollection(1,1,1));


    }


    @Test
    public void delUserCollection(){
        System.out.println(service.delUserCollection(1, 1, 1));
    }

    @Test
    public void isCollection(){
        System.out.println(service.isCollection(1, 0, 1));
    }

    @Test
    public void listUserCollection(){
        System.out.println(service.listUserCollection(1, 0, 10, 0));
    }

}
