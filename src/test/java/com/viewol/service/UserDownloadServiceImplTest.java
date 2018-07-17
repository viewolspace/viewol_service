package com.viewol.service;

import com.viewol.base.BaseTestClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/6/28.
 */
public class UserDownloadServiceImplTest extends BaseTestClass{

    private IUserDownloadService service = (IUserDownloadService)getInstance("userDownloadService");

    @Test
    public void addUserDownload(){

        System.out.println(service.addUserDownload(1, 2));
    }


    @Test
    public void listDownload(){
        System.out.println(service.listDownload(2, 1, 0));
    }


    @Test
    public void queryByIds(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(service.queryByIds(list));
    }


}
