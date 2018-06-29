package com.viewol.dao;

import com.viewol.pojo.Category;
import com.viewol.pojo.Company;
import com.viewol.pojo.query.CompanyQuery;
import com.youguu.core.util.PageHolder;

import java.util.List;

/**
 * Created by lenovo on 2018/6/29.
 */
public interface ICompanyDAO {

    int addCompany(Company company);

    int updateCompany(Company company);

    Company getCompany(int id);

    /**
     * 管理平台使用
     * 通过名称查询公司
     * @return
     */
    PageHolder<Company> queryCompany(CompanyQuery query);

    /**
     * 客户端使用
     * @param query
     * @return
     */
    List<Company> listCompany(CompanyQuery query);

    //查询推荐的展商
    List<Category> queryRecommentCompany();

    //删除推荐
    int delRecomment(int id);
    //添加推荐
    int addRecomment(int id,int num);
}
