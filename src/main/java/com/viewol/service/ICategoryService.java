package com.viewol.service;

import com.viewol.pojo.Category;

import java.util.List;

/**
 * Created by lenovo on 2018/6/28.
 */
public interface ICategoryService {
    /**
     * 添加一个新的分类
     * @param category
     * @return
     */
    String addCategory(Category category);


    int delCategory(String id);

    int updateCategory(Category category);

    Category getCategory(String id);

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
