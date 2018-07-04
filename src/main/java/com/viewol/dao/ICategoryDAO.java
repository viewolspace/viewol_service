package com.viewol.dao;

import com.viewol.pojo.Category;

import java.util.List;

/**
 * Created by lenovo on 2018/6/28.
 */
public interface ICategoryDAO {

    int addCategory(Category category);

    Category getCategory(String id);

    int delCategory(String id);

    int updateCategory(Category category);

    /**
     * 查询多个分类
     * @param ids
     * @return
     */
    List<Category> listCategorys(List<String> ids);

    /**
     * 查询子节点
     * @param parentId
     * @return
     */
    List<Category> listByParent(String parentId);

    /**
     * 查询所有节点
     * @param parentId
     * @return
     */
    List<Category> listAll(String parentId);
}
