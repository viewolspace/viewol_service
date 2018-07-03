package com.viewol.service.impl;

import com.viewol.dao.ICompanyDAO;
import com.viewol.dao.IProductDAO;
import com.viewol.dao.IRecommendDAO;
import com.viewol.pojo.Company;
import com.viewol.pojo.Product;
import com.viewol.pojo.Recommend;
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

    @Override
    public int addRecommend(int type, String categoryId, int thridId) {
        Recommend recommend = new Recommend();
        recommend.setCategoryId(categoryId);
        switch (type){
            case Recommend.TYPE_COM:
                Company company = companyDAO.getCompany(thridId);
                if(company==null){
                    return -2;
                }else{

                    recommend.setName(company.getName());
                    recommend.setImage(company.getImage());
                }
                break;
            case Recommend.TYPE_PRODUCT:
                Product product = productDAO.getProduct(thridId);
                if(product==null){
                    return -3;
                }else{
                    recommend.setName(product.getName());
                    recommend.setImage(product.getImage());
                }
                break;
            default:
                return  -1;
        }
        return recommendDAO.addRecommend(recommend);
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
