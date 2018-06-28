package com.viewol.service;

import com.viewol.base.BaseTestClass;
import com.viewol.pojo.Category;
import org.junit.Test;

/**
 * Created by lenovo on 2018/6/28.
 */
public class CategoryServiceImplTest extends BaseTestClass{

    private ICategoryService service = (ICategoryService)getInstance("categoryService");

    private Category beanCategory(){
        Category category = new Category();
        category.setId("000100010001");
        category.setParentId("000100010001");
        category.setType(1);
        category.setLogo("111");
        category.setName("摄像设备");
        category.setNum(1);
        return category;
    }

    @Test
    public void addCategory(){
        System.out.println(service.addCategory(beanCategory()));
    }

    @Test
    public void getCategory(){
        System.out.println(service.getCategory("0001"));
    }

    @Test
    public void updateCategory(){
        Category category = beanCategory();
        category.setName("录音设备111");
        service.updateCategory(category);
    }

    @Test
    public void delCategory(){
        service.delCategory("0001");
    }


    @Test
    public void listByParent(){
        System.out.println(service.listByParent("0001"));
    }

    @Test
    public void listAll(){
        System.out.println(service.listAll("0001"));
    }
}
