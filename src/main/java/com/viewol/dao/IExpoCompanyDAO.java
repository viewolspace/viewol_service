package com.viewol.dao;

/**
 * Created by lenovo on 2019/6/20.
 */
public interface IExpoCompanyDAO {

    int saveExpoCompany(int expoId,int companyId);

    int delExpoCompany(int companyId);

}
