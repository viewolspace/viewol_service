package com.viewol.dao;

import com.viewol.base.BaseTestClass;
import com.viewol.pojo.CompanyCategory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/6/28.
 */
public class CompanyCategoryDAOImplTest extends BaseTestClass{

    private ICompanyCategoryDAO dao = (ICompanyCategoryDAO)getInstance("companyCategoryDAO");



    @Test
    public void addCompanyCategoryList(){
        List<CompanyCategory> list  = new ArrayList<>();
        CompanyCategory c = new CompanyCategory();
        c.setCompanyId(1);
        c.setCategoryId("0001");
        list.add(c);

        c = new CompanyCategory();
        c.setCompanyId(1);
        c.setCategoryId("0002");
        list.add(c);

        c = new CompanyCategory();
        c.setCompanyId(1);
        c.setCategoryId("0003");
        list.add(c);

        c = new CompanyCategory();
        c.setCompanyId(2);
        c.setCategoryId("0001");
        list.add(c);


        System.out.println(dao.addCompanyCategoryList(list));

    }


    @Test
    public void delCompanyCategory(){
        System.out.println(dao.delCompanyCategory(1));
    }


    @Test
    public void delAllCompanyCategory(){
        System.out.println(dao.delAllCompanyCategory(1));
    }

    @Test
    public void queryCategory(){
        System.out.println(dao.queryCategory(1));
    }


}
