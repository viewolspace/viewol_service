package com.viewol.service.impl;

import com.viewol.dao.ICategoryDAO;
import com.viewol.dao.ICompanyCategoryDAO;
import com.viewol.dao.ICompanyDAO;
import com.viewol.dao.IExpoCompanyDAO;
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
    private IExpoCompanyDAO expoCompanyDAO;

    @Resource
    private ICompanyDAO companyDAO;

    @Resource
    private ICategoryDAO categoryDAO;

    @Transactional("viewolTX")
    @Override
    public int addCompany(int expoId, Company company, List<String> categoryIds) {
        int id = companyDAO.addCompany(company);
        List<CompanyCategory> companyCategorys = new ArrayList<>();
        for (String categoryId : categoryIds) {
            CompanyCategory cc = new CompanyCategory();
            cc.setCategoryId(categoryId);
            cc.setCompanyId(id);
            companyCategorys.add(cc);
        }
        expoCompanyDAO.saveExpoCompany(expoId, id);
        companyCategoryDAO.addCompanyCategoryList(companyCategorys);
        return id;
    }

    @Transactional("viewolTX")
    @Override
    public int updateCompany(Company company, List<String> categoryIds) {
        int result = companyDAO.updateCompany(company);
        if (result > 0) {
            if (categoryIds != null && categoryIds.size() > 0) {
                companyCategoryDAO.delAllCompanyCategory(company.getId());
                List<CompanyCategory> companyCategorys = new ArrayList<>();
                for (String categoryId : categoryIds) {
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
    public int updateByUserNum(Company company) {
        return companyDAO.updateByUserNum(company);
    }

    @Transactional("viewolTX")
    @Override
    public int delCompany(int id) {
        int result = 0;
        result = companyDAO.delCompany(id);
        result = expoCompanyDAO.delExpoCompany(id);
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
        if (list != null && list.size() > 0) {
            for (CompanyCategory companyCategory : list) {
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
    public List<Company> queryRecommentCompany(int expoId) {
        return companyDAO.queryRecommentCompany(expoId);
    }

    @Override
    public int delRecomment(int id) {
        return companyDAO.delRecomment(id);
    }

    @Override
    public int addRecomment(int id, int num) {
        return companyDAO.addRecomment(id, num);
    }

    @Override
    public List<Company> listCompany(String hall,int expoId, String keyWord, String categoryId, int award, long lastSeq, int num) {
        if (lastSeq == 0) {
            lastSeq = Long.MAX_VALUE;
        }
        CompanyQuery query = new CompanyQuery();
        query.setLastSeq(lastSeq);
        query.setHall(hall);
        query.setName(keyWord);
        query.setCategoryId(categoryId);
        query.setPageSize(num);
        query.setAward(award);
        query.setExpoId(expoId);
        return companyDAO.listCompany(query);
    }

    @Override
    public List<Company> listAwardCompany(int expoId, long lastSeq, int num) {
        if (lastSeq == 0) {
            lastSeq = Long.MAX_VALUE;
        }
        CompanyQuery query = new CompanyQuery();
        query.setLastSeq(lastSeq);
        query.setAward(1);
        query.setPageSize(num);
        query.setExpoId(expoId);
        return companyDAO.listCompany(query);
    }

    @Override
    public int updateShow(int id, String showInfo) {
        return companyDAO.updateShow(id, showInfo);
    }

    @Override
    public List<CompanyCategory> queryCompanyCategory(int companyId) {
        return companyCategoryDAO.queryCategory(companyId);
    }

    @Override
    public int delTop(int id) {
        return companyDAO.delTop(id);
    }

    @Override
    public int addTop(int id, int num) {
        return companyDAO.addTop(id, num);
    }

    @Override
    public List<Company> queryTopCompany(int expoId) {
        return companyDAO.queryTopCompany(expoId);
    }

    @Override
    public Company getCompanyByUserNum(String userNum) {
        return companyDAO.getCompanyByUserNum(userNum);
    }
}
