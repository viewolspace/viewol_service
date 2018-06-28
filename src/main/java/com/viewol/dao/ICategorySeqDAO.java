package com.viewol.dao;

import com.viewol.pojo.CategorySeq;

/**
 * Created by lenovo on 2018/6/28.
 */
public interface ICategorySeqDAO {

    int addCategorySeq(CategorySeq categorySeq);


    int updateCategorySeq(String parentId);


    CategorySeq getCategorySeq(String parentId);


}
