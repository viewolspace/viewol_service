package com.viewol.dao;

import com.viewol.base.BaseTestClass;
import com.viewol.pojo.CategorySeq;
import org.junit.Test;

/**
 * Created by lenovo on 2018/6/28.
 */
public class CategorySeqDAOImplTest extends BaseTestClass{

    private ICategorySeqDAO dao = (ICategorySeqDAO)getInstance("categorySeqDAO");


    @Test
    public void addCategorySeq(){
        CategorySeq categorySeq = new CategorySeq();
        categorySeq.setParentId("0001");
        categorySeq.setSeq(1);
        System.out.println(dao.addCategorySeq(categorySeq));
    }

    @Test
    public void updateCategorySeq(){
        System.out.println(dao.updateCategorySeq("0001"));
    }

    @Test
    public void getCategorySeq(){
        System.out.println(dao.getCategorySeq("0001"));
    }

}
