package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.IRecommendDAO;
import com.viewol.pojo.Recommend;
import com.viewol.pojo.query.RecommendQuery;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/7/3.
 */
@Repository("recommendDAO")
public class RecommendDAOImpl extends BaseDAO<Recommend> implements IRecommendDAO {
    @Override
    public int addRecommend(Recommend recommend) {
        recommend.setcTime(new Date());
        int result = super.insert(recommend);
        if(result>0){
            return recommend.getId();
        }else{
            return 0;
        }

    }

    @Override
    public int delRecommend(int id) {
        return super.delete(id);
    }

    @Override
    public List<Recommend> listByCategory(String categoryId,int type) {
        Map<String,Object> map = new HashMap<>();
        map.put("categoryId",categoryId);
        map.put("type",type);
        return super.findBy("listByCategory",map);
    }

    @Override
    public PageHolder<Recommend> queryRecommend(RecommendQuery query) {
        Map<String,Object> map = new HashMap<>();
        map.put("type",query.getType());
        map.put("categoryId",query.getCategoryId());
        return super.pagedQuery("findByParams",map,query.getPageIndex(),query.getPageSize());
    }
}
