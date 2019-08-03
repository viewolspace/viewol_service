package com.viewol.service.impl;

import com.viewol.dao.IProductIdeaDAO;
import com.viewol.pojo.ProductIdea;
import com.viewol.pojo.query.ProductIdeaQuery;
import com.viewol.service.IProductIdeaService;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lenovo on 2019/7/25.
 */
@Service("productIdeaService")
public class ProductIdeaServiceImpl implements IProductIdeaService {

    @Resource
    private IProductIdeaDAO productIdeaDAO;

    @Override
    public ProductIdea getProductIdea(int id) {
        return productIdeaDAO.getProductIdea(id);
    }

    @Override
    public int addProductIdea(ProductIdea productIdea) {
        return productIdeaDAO.addProductIdea(productIdea);
    }

    @Override
    public int updateStatus(int productId, int status) {
        return productIdeaDAO.updateStatus(productId, status);
    }

    @Override
    public int updateProductIdea(ProductIdea productIdea) {
        return productIdeaDAO.updateProductIdea(productIdea);
    }

    @Override
    public PageHolder<ProductIdea> queryProductIdea(ProductIdeaQuery query) {
        return productIdeaDAO.queryProductIdea(query);
    }

    @Override
    public int countByCompanyId(int companyId) {
        return productIdeaDAO.countByCompanyId(companyId);
    }
}
