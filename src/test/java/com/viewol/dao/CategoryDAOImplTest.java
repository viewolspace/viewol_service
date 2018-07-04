package com.viewol.dao;

import com.viewol.base.BaseTestClass;
import com.viewol.pojo.Category;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/6/28.
 */
public class CategoryDAOImplTest extends BaseTestClass{

    private ICategoryDAO dao = (ICategoryDAO)getInstance("categoryDAO");

    private Category beanCategory(){
        Category category = new Category();
        category.setId("000100010002");
        category.setParentId("00010001");
        category.setType(1);
        category.setLogo("111");
        category.setName("摄像设备1");
        category.setNum(1);
        return category;
    }

    @Test
    public void addCategory(){
        System.out.println(dao.addCategory(beanCategory()));
    }

    @Test
    public void getCategory(){
        System.out.println(dao.getCategory("0001"));
    }

    @Test
    public void updateCategory(){
        Category category = beanCategory();
        category.setName("录音设备");
        dao.updateCategory(category);
    }

    @Test
    public void delCategory(){
        dao.delCategory("0001");
    }


    @Test
    public void listByParent(){
        System.out.println(dao.listByParent("0001"));
    }

    @Test
    public void listAll(){
        System.out.println(dao.listAll("0001"));
    }

    @Test
    public void listCategorys(){
        List<String> list = new ArrayList<>();
        list.add("000100010001");
        list.add("000100010002");
        System.out.println(dao.listCategorys(list));
    }
}
