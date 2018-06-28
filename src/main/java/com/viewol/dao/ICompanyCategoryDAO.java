package com.viewol.dao;

import com.viewol.pojo.CompanyCategory;

import java.util.List;

/**
 * Created by lenovo on 2018/6/28.
 */
public interface ICompanyCategoryDAO {

    int addCompanyCategoryList(List<CompanyCategory> companyCategory);

    int delCompanyCategory(int id);

    int delAllCompanyCategory(int companyId);

    List<CompanyCategory> queryCategory(int companyId);
}
