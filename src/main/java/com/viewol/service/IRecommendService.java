package com.viewol.service;

import com.viewol.pojo.Recommend;
import com.viewol.pojo.query.RecommendQuery;
import com.youguu.core.util.PageHolder;

import java.util.List;

/**
 * Created by lenovo on 2018/7/3.
 */
public interface IRecommendService {
    /**
     * 添加同类推荐
     * @param type
     * @param categoryId
     * @param thridId
     * @return
     */
    int addRecommend(int type,String categoryId,int thridId);

    int delRecommend(int id);

    List<Recommend> listByCategory(String categoryId,int type);

    PageHolder<Recommend> queryRecommend(RecommendQuery query);
}
