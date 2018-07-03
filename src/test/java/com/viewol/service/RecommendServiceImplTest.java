package com.viewol.service;

import com.viewol.base.BaseTestClass;
import com.viewol.pojo.Recommend;
import com.viewol.pojo.query.RecommendQuery;
import org.junit.Test;

/**
 * Created by lenovo on 2018/6/28.
 */
public class RecommendServiceImplTest extends BaseTestClass{

    private IRecommendService service = (IRecommendService)getInstance("recommendService");



    @Test
    public void addRecommend(){

        System.out.println(service.addRecommend(1, "0002", 1));
    }


    @Test
    public void delRecommend(){
        System.out.println(service.delRecommend(1));
    }

    @Test
    public void listByCategory(){
        System.out.println(service.listByCategory("0001", 1));
    }

    @Test
    public void queryRecommend(){
        RecommendQuery query = new RecommendQuery();
        query.setType(Recommend.TYPE_PRODUCT);
        query.setCategoryId("0001");
        System.out.println(service.queryRecommend(query));
    }

}
