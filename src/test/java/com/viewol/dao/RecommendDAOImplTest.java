package com.viewol.dao;

import com.viewol.base.BaseTestClass;
import com.viewol.pojo.Recommend;
import com.viewol.pojo.query.RecommendQuery;
import org.junit.Test;

/**
 * Created by lenovo on 2018/6/28.
 */
public class RecommendDAOImplTest extends BaseTestClass{

    private IRecommendDAO dao = (IRecommendDAO)getInstance("recommendDAO");

    private Recommend beanRecommend(){
        Recommend recommend = new Recommend();
        recommend.setName("展商3");
        recommend.setCategoryId("0001");
        recommend.setThirdId(1);
        recommend.setType(Recommend.TYPE_COM);

        return recommend;
    }

    @Test
    public void addRecommend(){

        System.out.println(dao.addRecommend(beanRecommend()));
    }


    @Test
    public void delRecommend(){
        System.out.println(dao.delRecommend(1));
    }

    @Test
    public void listByCategory(){
        System.out.println(dao.listByCategory("0001",1));
    }

    @Test
    public void queryRecommend(){
        RecommendQuery query = new RecommendQuery();
        query.setType(Recommend.TYPE_PRODUCT);
        query.setCategoryId("0001");
        System.out.println(dao.queryRecommend(query));
    }

}
