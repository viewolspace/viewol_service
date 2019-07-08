package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.ICompanyDAO;
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

    private long getSeq(Company company){

        int id = company.getId();

        int num = company.getTopNum();

        if(num > 0 ){
            num = 100 - num;
        }

        long seq = num * 1000000 + id;

        return seq;
    }
    private int  updateSeq(Company company ){

        long seq = this.getSeq(company);
        Map<String,Object> map = new HashMap<>();
        map.put("seq",seq);
        map.put("id",company.getId());
        return super.updateBy("updateSeq",map);

    }

    @Override
    public int addCompany(Company company) {
        Date d = new Date();
        company.setcTime(d);
        company.setmTime(d);
        int result = super.insert(company);
        if(result>0){
            this.updateSeq(company);
            return company.getId();
        }else{
            return 0;
        }
    }

    @Override
    public int updateCompany(Company company) {
        company.setmTime(new Date());
        company.setSeq(this.getSeq(company));
        return super.update(company);
    }

    @Override
    public int delCompany(int id) {
        return super.delete(id);
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
        map.put("expoId",query.getExpoId());
        return super.pagedQuery("findByParams",map,query.getPageIndex(),query.getPageSize());
    }

    @Override
    public List<Company> queryRecommentCompany(int expoId) {
        Map<String,Object> map = new HashMap<>();
        map.put("expoId",expoId);
        return super.findBy("queryRecommentCompany",map);
    }

    @Override
    public int delRecomment(int id) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("isRecommend",Company.ISRECOMMEND_NO);
        map.put("recommendNum",0);
        int result = super.updateBy("updateRecommend",map);
        Company company = this.getCompany(id);
        this.updateSeq(company);
        return result;
    }

    @Override
    public int addRecomment(int id,int num) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("isRecommend",Company.ISRECOMMEND_YES);
        map.put("recommendNum",num);
        int result = super.updateBy("updateRecommend",map);
        Company company = this.getCompany(id);
        this.updateSeq(company);
        return result;
    }

    @Override
    public List<Company> listCompany(CompanyQuery query) {
        Map<String,Object> map = new HashMap<>();
        map.put("name",query.getName());
        map.put("categoryId",query.getCategoryId());
        map.put("lastSeq",query.getLastSeq());
        map.put("num",query.getPageSize());
        map.put("expoId",query.getExpoId());
        return super.findBy("listCompany",map);
    }

    @Override
    public int delTop(int id) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("topNum",0);
        int result = super.updateBy("updateTopNum",map);
        Company company = this.getCompany(id);
        this.updateSeq(company);
        return result;
    }

    @Override
    public int addTop(int id, int num) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("topNum",num);
        int result = super.updateBy("updateTopNum",map);
        Company company = this.getCompany(id);
        this.updateSeq(company);
        return result;
    }

    @Override
    public List<Company> queryTopCompany(int expoId) {
        Map<String,Object> map = new HashMap<>();
        map.put("expoId",expoId);
        return super.findBy("queryTopCompany",map);
    }

    @Override
    public int incSeeNum(int id) {
        Map<String,Object> map = new HashMap<>();
        map.put("seeNum",1);
        map.put("id",id);
        return super.updateBy("updateInteractNum", map);
    }

    @Override
    public int incPraiseNum(int id) {
        Map<String,Object> map = new HashMap<>();
        map.put("praiseNum",1);
        map.put("id",id);
        return super.updateBy("updateInteractNum", map);
    }

    @Override
    public int incCommentNum(int id) {
        Map<String,Object> map = new HashMap<>();
        map.put("commentNum",1);
        map.put("id",id);
        return super.updateBy("updateInteractNum", map);
    }

    @Override
    public int updateShow(int id, String show) {
        Map<String,Object> map = new HashMap<>();
        map.put("show",show);
        map.put("id",id);
        return super.updateBy("updateShow", map);
    }
}
