package com.viewol.dao;

import com.viewol.pojo.Recommend;
import com.viewol.pojo.query.RecommendQuery;
import com.youguu.core.util.PageHolder;

import java.util.List;

/**
 * Created by lenovo on 2018/7/3.
 */
public interface IRecommendDAO {

    int addRecommend(Recommend recommend);

    int delRecommend(int id);

    List<Recommend> listByCategory(String categoryId,int type);

    PageHolder<Recommend> queryRecommend(RecommendQuery query);
}
