package com.viewol.service.impl;

import com.viewol.dao.ICompanyCategoryDAO;
import com.viewol.dao.ICompanyDAO;
import com.viewol.dao.IProductDAO;
import com.viewol.dao.IRecommendDAO;
import com.viewol.pojo.*;
import com.viewol.pojo.query.RecommendQuery;
import com.viewol.service.IRecommendService;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2018/7/3.
 */
@Service("recommendService")
public class RecommendServiceImpl implements IRecommendService {

    @Resource
    private IRecommendDAO recommendDAO;

    @Resource
    private ICompanyDAO companyDAO;

    @Resource
    private IProductDAO productDAO;

    @Resource
    private ICompanyCategoryDAO companyCategoryDAO;


    private int addComRecommend(int type,  int thridId){
        Recommend recommend = new Recommend();
        recommend.setType(type);
        recommend.setThirdId(thridId);
        Company company = companyDAO.getCompany(thridId);
        if(company==null){
            return -2;
        }else{
            recommend.setName(company.getName());
            recommend.setImage(company.getImage());
            List<CompanyCategory> list =  companyCategoryDAO.queryCategory(thridId);
            for(CompanyCategory companyCategory:list){
                recommend.setCategoryId(companyCategory.getCategoryId());
                recommendDAO.addRecommend(recommend);
            }
        }
        return 1;
    }


    private int addProductRecommend(int type,  int thridId){
        Recommend recommend = new Recommend();
        recommend.setType(type);
        recommend.setThirdId(thridId);
        Product product = productDAO.getProduct(thridId);
        if(product==null){
            return -3;
        }else{

            String categoryId = product.getCategoryId();
            if(categoryId.length()>8){
                categoryId = categoryId.substring(0,8);
            }
            recommend.setCategoryId(categoryId);
            recommend.setName(product.getName());
            recommend.setImage(product.getImage());
        }
        return recommendDAO.addRecommend(recommend);
    }

    @Override
    public int addRecommend(int type,  int thridId) {
        Recommend recommend = new Recommend();
        recommend.setType(type);
        recommend.setThirdId(thridId);
        switch (type){
            case Recommend.TYPE_COM:
                return this.addComRecommend(type, thridId);
            case Recommend.TYPE_PRODUCT:
                return this.addProductRecommend(type, thridId);
            default:
                return  -1;
        }
    }

    @Override
    public int delRecommend(int id) {
        return recommendDAO.delRecommend(id);
    }

    @Override
    public List<Recommend> listByCategory(String categoryId, int type) {
        return recommendDAO.listByCategory(categoryId, type);
    }

    @Override
    public PageHolder<Recommend> queryRecommend(RecommendQuery query) {
        return recommendDAO.queryRecommend(query);
    }
}
