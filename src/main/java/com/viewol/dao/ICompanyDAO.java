package com.viewol.dao;

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

    int delCompany(int id);

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
    List<Company> queryRecommentCompany(int expoId);

    //删除推荐
    int delRecomment(int id);
    //添加推荐
    int addRecomment(int id,int num);

    //删除置顶
    int delTop(int id);

    //添加置顶
    int addTop(int id , int num);

    //查询推荐的展商
    List<Company> queryTopCompany(int expoId);

    int incSeeNum(int id);

    int incPraiseNum(int id);

    int incCommentNum(int id);

    int updateShow(int id ,String showInfo);


    Company getCompanyByUserNum(String userNum);
}
