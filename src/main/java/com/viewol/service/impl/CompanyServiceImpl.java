package com.viewol.service.impl;

import com.viewol.dao.ICategoryDAO;
import com.viewol.dao.ICompanyCategoryDAO;
import com.viewol.dao.ICompanyDAO;
import com.viewol.pojo.Category;
import com.viewol.pojo.Company;
import com.viewol.pojo.CompanyCategory;
import com.viewol.pojo.query.CompanyQuery;
import com.viewol.service.ICompanyService;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/6/29.
 */
@Service("companyService")
public class CompanyServiceImpl implements ICompanyService {

    @Resource
    private ICompanyCategoryDAO companyCategoryDAO;

    @Resource
    private ICompanyDAO companyDAO;

    @Resource
    private ICategoryDAO categoryDAO;

    @Transactional("viewolTX")
    @Override
    public int addCompany(Company company, List<String> categoryIds) {
        int id = companyDAO.addCompany(company);
        List<CompanyCategory> companyCategorys  = new ArrayList<>();
        for(String categoryId:categoryIds){
            CompanyCategory cc = new CompanyCategory();
            cc.setCategoryId(categoryId);
            cc.setCompanyId(id);
            companyCategorys.add(cc);
        }
        companyCategoryDAO.addCompanyCategoryList(companyCategorys);
        return id;
    }

    @Transactional("viewolTX")
    @Override
    public int updateCompany(Company company, List<String> categoryIds) {
        int result = companyDAO.updateCompany(company);
        if(result>0){
            if(categoryIds!=null && categoryIds.size()>0){
                companyCategoryDAO.delAllCompanyCategory(company.getId());
                List<CompanyCategory> companyCategorys  = new ArrayList<>();
                for(String categoryId:categoryIds){
                    CompanyCategory cc = new CompanyCategory();
                    cc.setCategoryId(categoryId);
                    cc.setCompanyId(company.getId());
                    companyCategorys.add(cc);
                }
                companyCategoryDAO.addCompanyCategoryList(companyCategorys);
            }
        }
        return result;
    }

    @Override
    public Company getCompany(int id) {
        return companyDAO.getCompany(id);
    }

    @Override
    public List<Category> getCompanyCategory(int id) {
        List<CompanyCategory> list = companyCategoryDAO.queryCategory(id);
        List<String> ids = new ArrayList<>();
        if(list!=null && list.size()>0){
            for(CompanyCategory companyCategory:list){
                ids.add(companyCategory.getCategoryId());
            }
            return categoryDAO.listCategorys(ids);
        }
        return null;
    }

    @Override
    public PageHolder<Company> queryCompany(CompanyQuery query) {
        return companyDAO.queryCompany(query);
    }

    @Override
    public List<Company> queryRecommentCompany() {
        return companyDAO.queryRecommentCompany();
    }

    @Override
    public int delRecomment(int id) {
        return companyDAO.delRecomment(id);
    }

    @Override
    public int addRecomment(int id,int num) {
        return companyDAO.addRecomment(id,num);
    }
}
