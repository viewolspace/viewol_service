package com.viewol.service.impl;

import com.viewol.dao.IProductIdeaNewDAO;
import com.viewol.pojo.ProductIdeaNew;
import com.viewol.pojo.query.ProductIdeaNewQuery;
import com.viewol.service.IProductIdeaNewService;
import com.youguu.core.util.PageHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2019/7/25.
 */
@Service("productIdeaNewService")
public class ProductIdeaNewServiceImpl implements IProductIdeaNewService {

    @Autowired
    private IProductIdeaNewDAO productIdeaDAO;

    @Override
    public ProductIdeaNew getProductIdea(int id) {
        return productIdeaDAO.getProductIdea(id);
    }

    @Override
    public int addProductIdea(ProductIdeaNew productIdea) {
        return productIdeaDAO.addProductIdea(productIdea);
    }

    @Override
    public int updateStatus(int productId, int status) {
        return productIdeaDAO.updateStatus(productId, status);
    }

    @Override
    public int updateProductIdea(ProductIdeaNew productIdea) {
        return productIdeaDAO.updateProductIdea(productIdea);
    }

    @Override
    public PageHolder<ProductIdeaNew> queryProductIdea(ProductIdeaNewQuery query) {
        return productIdeaDAO.queryProductIdea(query);
    }

    @Override
    public int countByCompanyId(int companyId) {
        return productIdeaDAO.countByCompanyId(companyId);
    }
}
