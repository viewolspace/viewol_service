package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.ICategoryDAO;
import com.viewol.pojo.Category;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/6/28.
 */
@Repository("categoryDAO")
public class CategoryDAOImpl extends BaseDAO<Category> implements ICategoryDAO {
    @Override
    public int addCategory(Category category) {
        category.setcTime(new Date());
        return super.insert(category);
    }

    @Override
    public Category getCategory(String id) {
        return super.get(id);
    }

    @Override
    public int delCategory(String id) {
        return super.delete(id);
    }

    @Override
    public int updateCategory(Category category) {
        return super.update(category);
    }

    @Override
    public List<Category> listByParent(String parentId) {
        Map<String,Object> map = new HashMap<>();
        map.put("parentId",parentId);
        return super.findBy("queryByParent",map);
    }

    @Override
    public List<Category> listAll(String parentId) {
        Map<String,Object> map = new HashMap<>();
        map.put("parentId",parentId);
        return super.findBy("queryAll",map);
    }

    @Override
    public List<Category> listCategorys(List<String> ids) {
        Map<String,Object> map = new HashMap<>();
        map.put("list",ids);
        return super.findBy("listCategorys",map);
    }
}
