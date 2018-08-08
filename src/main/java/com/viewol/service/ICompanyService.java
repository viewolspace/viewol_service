package com.viewol.service;

import com.viewol.pojo.Category;
import com.viewol.pojo.Company;
import com.viewol.pojo.CompanyCategory;
import com.viewol.pojo.query.CompanyQuery;
import com.youguu.core.util.PageHolder;

import java.util.List;

/**
 * Created by lenovo on 2018/6/29.
 */
public interface ICompanyService {

    //添加一个展商
    int addCompany(Company company,List<String> categoryIds);

    //修改展商 categoryIds为空表示不做分类的修改
    int updateCompany(Company company,List<String> categoryIds);

    //获取展商
    Company getCompany(int id);

    //获取展商所属的分类
    List<Category> getCompanyCategory(int id);

    //查询推荐的展商
    List<Company> queryRecommentCompany();


    List<CompanyCategory> queryCompanyCategory(int companyId);

    //管理平台 查询展商
    PageHolder<Company> queryCompany(CompanyQuery query);

    //前端使用的展商搜索
    List<Company> listCompany(String keyWord,String categoryId,long lastSeq,int num);

    //删除推荐
    int delRecomment(int id);
    //添加推荐
    int addRecomment(int id,int num);

    //删除置顶
    int delTop(int id);

    //添加置顶
    int addTop(int id , int num);

    //查询推荐的展商
    List<Company> queryTopCompany();
}
