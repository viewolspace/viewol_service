package com.viewol.dao;

import com.viewol.base.BaseTestClass;
import com.viewol.pojo.UserDownload;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/6/28.
 */
public class UserDownloadDAOImplTest extends BaseTestClass{

    private IUserDownloadDAO dao = (IUserDownloadDAO)getInstance("userDownloadDAO");

    @Test
    public void addUserDownload(){
        UserDownload userDownload = new UserDownload();
        userDownload.setUserId(1);
        userDownload.setProductId(1);
        userDownload.setProductName("测试");
        dao.addUserDownload(userDownload);
    }

    @Test
    public void getUserDownload(){
        System.out.println(dao.getUserDownload(1,1));
    }

    @Test
    public void listDownload(){
        System.out.println(dao.listDownload(2,1,0));
    }


    @Test
    public void queryByIds(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(dao.queryByIds(list));
    }


}
