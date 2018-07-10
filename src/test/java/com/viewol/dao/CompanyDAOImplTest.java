package com.viewol.dao;

import com.viewol.base.BaseTestClass;
import com.viewol.pojo.Company;
import com.viewol.pojo.query.CompanyQuery;
import org.junit.Test;

/**
 * Created by lenovo on 2018/6/28.
 */
public class CompanyDAOImplTest extends BaseTestClass{

    private ICompanyDAO dao = (ICompanyDAO)getInstance("companyDAO");


    private Company beanCompany(){
        Company company = new Company();
        company.setId(1);
        company.setName("展商一111");
        company.setLogo("");
        company.setCanApply(1);
        company.setIsRecommend(0);
        company.setProductNum(5);
        company.setContent("233123123123123");
        return company;
    }


    @Test
    public void addCompany(){
        System.out.println(dao.addCompany(beanCompany()));

    }


    @Test
    public void updateCompany(){
        System.out.println(dao.updateCompany(beanCompany()));
    }

    @Test
    public void getCompany(){
        System.out.println(dao.getCompany(3));
    }

    @Test
    public void queryCompany(){
        CompanyQuery query = new CompanyQuery();
        System.out.println(dao.queryCompany(query));
    }

    @Test
    public void queryRecommentCompany(){
        System.out.println(dao.queryRecommentCompany());
    }

    @Test
    public void delRecomment(){
        System.out.println(dao.delRecomment(1));
    }

    @Test
    public void addRecomment(){
        System.out.println(dao.addRecomment(1,12));
    }

    @Test
    public void listCompany(){
        CompanyQuery query = new CompanyQuery();
        query.setPageSize(10);
        query.setName("");
        query.setCategoryId("");
        query.setLastSeq(0);
        System.out.println(dao.listCompany(query));
    }




}
