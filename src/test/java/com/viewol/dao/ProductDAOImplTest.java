package com.viewol.dao;

import com.viewol.base.BaseTestClass;
import com.viewol.pojo.Product;
import com.viewol.pojo.query.ProductQuery;
import org.junit.Test;

/**
 * Created by lenovo on 2018/6/28.
 */
public class ProductDAOImplTest extends BaseTestClass{

    private IProductDAO dao = (IProductDAO)getInstance("productDAO");


    private Product beanProduct(){
        Product p = new Product();
        p.setId(1);
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
        System.out.println(dao.addProduct(beanProduct()));
    }

    @Test
    public void delProduct(){
        System.out.println(dao.delProduct(1));
    }

    @Test
    public void updateProduct(){
        System.out.println(dao.updateProduct(beanProduct()));
    }

    @Test
    public void updateStatus(){
        System.out.println(dao.updateStatus(4, 1));
    }


    @Test
    public void delRecomment(){
        System.out.println(dao.delRecomment(2));
    }

    @Test
    public void addRecomment(){
        System.out.println(dao.addRecomment(2, 2));
    }

    @Test
    public void queryProduct(){

        ProductQuery query = new ProductQuery();
        query.setName("摄像11");
        query.setStatus(1);
        query.setCompanyId(1);
        query.setCategoryId("00010001");

        System.out.println(dao.queryProduct(query));
    }


    @Test
    public void queryRecommentProduct(){
        System.out.println(dao.queryRecommentProduct());
    }


    @Test
    public void listProduct(){
        ProductQuery query = new ProductQuery();
        query.setName("摄像");
        query.setCategoryId("00010001");
        System.out.println(dao.listProduct(query));
    }

    @Test
    public void comProductCount(){
        System.out.println(dao.comProductCount(1));
    }

    @Test
    public void addTop(){
        System.out.println(dao.addTop(2,1));
    }

    @Test
    public void delTop(){
        System.out.println(dao.delTop(2));
    }

    @Test
    public void queryTopProduct(){
        System.out.println(dao.queryTopProduct());
    }
}
