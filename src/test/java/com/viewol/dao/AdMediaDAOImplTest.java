package com.viewol.dao;

import com.viewol.base.BaseTestClass;
import com.viewol.pojo.AdMedia;
import com.viewol.pojo.query.AdMediaQuery;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2018/6/28.
 */
public class AdMediaDAOImplTest extends BaseTestClass{

    private IAdMediaDAO dao = (IAdMediaDAO)getInstance("adMediaDAO");


    private List<AdMedia> beanAdMedio(){
        List<AdMedia> list = new ArrayList<>();
        AdMedia adMedia = new AdMedia();
        adMedia.setCompanyId(11);
        adMedia.setCompanyName("11231");
        adMedia.setcTime(new Date());
        adMedia.setItemName("111");
        adMedia.setNum("w1");
        adMedia.setShowRoom("111");
        adMedia.setSize("12");
        adMedia.setPrice("123");
        adMedia.setPhone("13818181716");
        adMedia.setUserName("11111");
        list.add(adMedia);
        return list;
    }





    @Test
    public void addAdMedias(){
        System.out.println(dao.addAdMedias(beanAdMedio()));
    }


    @Test
    public void delAdmedia(){
        System.out.println(dao.delAdmedia(11));
    }


    @Test
    public void listByCompanyId(){
        System.out.println(dao.listByCompanyId(12));
    }


    @Test
    public void queryAdMedia(){
        System.out.println(dao.queryAdMedia(new AdMediaQuery()));
    }
}
