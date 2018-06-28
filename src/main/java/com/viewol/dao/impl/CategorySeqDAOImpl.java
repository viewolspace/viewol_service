package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.ICategorySeqDAO;
import com.viewol.pojo.CategorySeq;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2018/6/28.
 */
@Repository("categorySeqDAO")
public class CategorySeqDAOImpl extends BaseDAO<CategorySeq> implements ICategorySeqDAO{
    @Override
    public int addCategorySeq(CategorySeq categorySeq) {
        categorySeq.setcTime(new Date());
        categorySeq.setmTime(new Date());
        return super.insert(categorySeq);
    }

    @Override
    public int updateCategorySeq(String parentId) {
        Map<String,Object> map = new HashMap<>();
        map.put("parentId",parentId);
        map.put("mTime",new Date());
        return super.updateBy("updateSeq",map);
    }

    @Override
    public CategorySeq getCategorySeq(String parentId) {
        return super.get(parentId);
    }
}
