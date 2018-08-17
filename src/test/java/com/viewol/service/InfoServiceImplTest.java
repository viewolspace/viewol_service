package com.viewol.service;

import com.viewol.base.BaseTestClass;
import com.viewol.pojo.Info;
import com.youguu.core.util.PageHolder;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

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
        service.save(info);
    }

    @Test
    public void queryInfo() {
        PageHolder<Info> pageHolder = service.queryInfo("", "", "", 1, 10);
        System.out.println(pageHolder.size());
    }

    @Test
    public void listInfo() {
        List<Info> list = service.listInfo(100, 20);
        System.out.println(list.size());
    }
}