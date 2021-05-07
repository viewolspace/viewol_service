package com.viewol.dao;

import com.viewol.base.BaseTestClass;
import com.viewol.pojo.ProductIdeaNew;
import com.viewol.pojo.query.ProductIdeaNewQuery;
import org.junit.Test;

/**
 * Created by lenovo on 2018/6/28.
 */
public class ProductIdeaNewDAOImplTest extends BaseTestClass{

    private IProductIdeaNewDAO dao = (IProductIdeaNewDAO)getInstance("productIdeaNewDAO");


    private ProductIdeaNew beanProductIdea(){
        ProductIdeaNew p = new ProductIdeaNew();
        p.setProductId(2);
        p.setCategoryId("00021");
        p.setComLogo("comlog11");
        p.setCompanyId(12);
        p.setCompanyName("12");
        p.setAddress("adress1");
        p.setPhone("phone1");
        p.setDes("des1");
        p.setAchievement("Achievement1");
        p.setAchievementZip("setAchievementZip1");
        p.setIdeaPoint("ideaPoin1");
        p.setLogo("logo1");
        p.setQuota("quota1");
        p.setProductName("setProductName1");
        p.setCore("core1");
        p.setCorePic("setCore_pic1");
        p.setPromisePic("setPromisePic1");
        p.setProductPic("setProduct_pic1");
        p.setStandard("setStandard1");
        p.setProAsk("2");
        p.setProEvent("1");
        p.setProView("1");
        p.setVideo("video1");
        return p;
    }





    @Test
    public void addProductIdea(){
        System.out.println(dao.addProductIdea(beanProductIdea()));
    }


    @Test
    public void update(){
        System.out.println(dao.updateProductIdea(beanProductIdea()));
    }


    @Test
    public void updateStatus(){
        System.out.println(dao.updateStatus(1, 1));
    }

    @Test
    public void count(){
        System.out.println(dao.countByCompanyId(1));
    }
    @Test
    public void get(){
        System.out.println(dao.getProductIdea(1));
    }


    @Test
    public void queryProductIdea(){

        ProductIdeaNewQuery query = new ProductIdeaNewQuery();
        System.out.println(dao.queryProductIdea(query));
    }

}
