package com.viewol.service;

import com.viewol.base.BaseTestClass;
import com.viewol.pojo.Product;
import com.viewol.pojo.query.ProductQuery;
import org.junit.Test;

/**
 * Created by lenovo on 2018/6/28.
 */
public class ProductServiceImplTest extends BaseTestClass{

    private IProductService service = (IProductService)getInstance("productService");


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
        return p;
    }


    @Test
    public void addProduct(){
        System.out.println(service.addProduct(beanProduct()));
    }

    @Test
    public void delProduct(){
        System.out.println(service.delProduct(2));
    }

    @Test
    public void updateProduct(){
        System.out.println(service.updateProduct(beanProduct()));
    }

    @Test
    public void updateStatus(){
        System.out.println(service.updateStatus(4, 1));
    }


    @Test
    public void delRecomment(){
        System.out.println(service.delRecomment(4));
    }

    @Test
    public void addRecomment(){
        System.out.println(service.addRecomment(3, 2));
    }

    @Test
    public void queryProduct(){

        ProductQuery query = new ProductQuery();
        query.setName("摄像");
        query.setStatus(1);
        query.setCompanyId(1);
        query.setCategoryId("00010001");

        System.out.println(service.queryProduct(query));
    }


    @Test
    public void queryRecommentProduct(){
        System.out.println(service.queryRecommentProduct());
    }






}
