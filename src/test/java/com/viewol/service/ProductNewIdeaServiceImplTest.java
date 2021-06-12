package com.viewol.service;

import com.viewol.base.BaseTestClass;
import com.viewol.pojo.Product;
import org.junit.Test;

/**
 * Created by lenovo on 2018/6/28.
 */
public class ProductNewIdeaServiceImplTest extends BaseTestClass{

    private IProductIdeaNewService service = (IProductIdeaNewService)getInstance("productIdeaNewService");


    private Product beanProduct(){
        Product p = new Product();
        p.setId(2);
        p.setContent("内容");
        p.setCompanyId(1);
        p.setCategoryId("00010001");
        p.setPdfName("说明书");
        p.setIsRecommend(0);
        p.setRecommendNum(0);
        p.setName("摄像头");
        p.setStatus(0);
        p.setPdfUrl("");
        p.setReImg("112");
        return p;
    }
    @Test
    public void getProduct(){
        System.out.println(service.vote("1123",1));
//        System.out.println(service.vote("123",4));
//        System.out.println(service.vote("123",5));
//        System.out.println(service.vote("123",6));
    }


    @Test
    public void list(){
        System.out.println(service.list("","",1,1,10));

//        System.out.println(service.vote("1123",1));
//        System.out.println(service.vote("123",4));
//        System.out.println(service.vote("123",5));
//        System.out.println(service.vote("123",6));
    }









}
