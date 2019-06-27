package com.viewol.service;

import com.viewol.base.BaseTestClass;
import com.viewol.pojo.Info;
import com.viewol.pojo.query.InfoQuery;
import com.youguu.core.util.PageHolder;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class InfoServiceImplTest  extends BaseTestClass {
    private IInfoService service = (IInfoService)getInstance("infoService");

    @Test
    public void save() {
        Info info = new Info();
        info.setTitle("dddddddddddddddddddddddddd");
        info.setContentUrl("http://www.baidu.com");
        info.setPicUrl("http://www.baidu.com/1.jpg");
        info.setCreateTime(new Date());
        info.setPubTime(new Date());
        info.setSummary("sssssssssssssssssssss");
        service.save(1,info);
    }

    @Test
    public void queryInfo() {
        InfoQuery query = new InfoQuery();
        PageHolder<Info> pageHolder = service.queryInfo(query);
        System.out.println(pageHolder.size());
    }

    @Test
    public void listInfo() {
        List<Info> list = service.listInfo(1,100, 20);
        System.out.println(list.size());
    }

    @Test
    public void updateStatus() {
        service.updateStatus(2556,1);
    }

    @Test
    public void getInfo() {
        System.out.println(service.getInfo(2556));
    }
}