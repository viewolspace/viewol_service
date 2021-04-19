package com.viewol.dao;

import com.viewol.base.BaseTestClass;
import com.viewol.pojo.ProductIdea;
import com.viewol.pojo.query.ProductIdeaQuery;
import org.junit.Test;

/**
 * Created by lenovo on 2018/6/28.
 */
public class ProductIdeaDAOImplTest extends BaseTestClass{

    private IProductIdeaDAO dao = (IProductIdeaDAO)getInstance("productIdeaDAO");


    private ProductIdea beanProductIdea(){
        ProductIdea p = new ProductIdea();
        p.setProductId(1);
        p.setCategoryId("0001");
        p.setComLogo("comlog1");
        p.setCompanyId(12);
        p.setCompanyName("12");
        p.setCompanyPlace("E43");
        p.setDes("des");
        p.setEmail("email");
        p.setExt("ext");
        p.setExtend("extend");
        p.setIdeaPoint("ideaPoin");
        p.setLandLine("setLandLine");
        p.setLogo("logo");
        p.setModel("setModel");
        p.setPhone("phone");
        p.setProductPic("setProductPic");
        p.setQuota("quota");
        p.setWebsite("website");
        p.setProductName("setProductName");
        p.setLiaisonMan("setLiaisonMan1");
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

        ProductIdeaQuery query = new ProductIdeaQuery();
        System.out.println(dao.queryProductIdea(query));
    }

}
