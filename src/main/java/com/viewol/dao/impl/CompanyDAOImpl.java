package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.ICompanyDAO;
import com.viewol.pojo.Category;
import com.viewol.pojo.Company;
import com.viewol.pojo.query.CompanyQuery;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/6/29.
 */
@Repository("companyDAO")
public class CompanyDAOImpl extends BaseDAO<Company> implements ICompanyDAO {
    @Override
    public int addCompany(Company company) {
        Date d = new Date();
        company.setcTime(d);
        company.setmTime(d);
        int result = super.insert(company);
        if(result>0){
            return company.getId();
        }else{
            return 0;
        }
    }

    @Override
    public int updateCompany(Company company) {
        return super.update(company);
    }

    @Override
    public Company getCompany(int id) {
        return super.get(id);
    }

    @Override
    public PageHolder<Company> queryCompany(CompanyQuery query) {
        Map<String,Object> map = new HashMap<>();
        map.put("categoryId",query.getCategoryId());
        map.put("name",query.getName());
        return super.pagedQuery("findByParams",map,query.getPageIndex(),query.getPageSize());
    }

    @Override
    public List<Category> queryRecommentCompany() {
        return super.findBy("queryRecommentCompany",null);
    }

    @Override
    public int delRecomment(int id) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("isRecommend",Company.ISRECOMMEND_NO);
        map.put("recommendNum",0);
        return super.updateBy("updateRecommend",map);
    }

    @Override
    public int addRecomment(int id,int num) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("isRecommend",Company.ISRECOMMEND_YES);
        map.put("recommendNum",num);
        return super.updateBy("updateRecommend",map);
    }

    //TODO
    @Override
    public List<Company> listCompany(CompanyQuery query) {
        return null;
    }
}
