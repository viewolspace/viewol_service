package com.viewol.service;

import com.viewol.pojo.ProductIdea;
import com.viewol.pojo.query.ProductIdeaQuery;
import com.youguu.core.util.PageHolder;

/**
 * Created by lenovo on 2019/7/25.
 */
public interface IProductIdeaService {
    ProductIdea getProductIdea(int id);

    int addProductIdea(ProductIdea productIdea);

    int updateStatus(int productId,int status);

    int  updateProductIdea(ProductIdea productIdea);

    PageHolder<ProductIdea> queryProductIdea(ProductIdeaQuery query);

    int countByCompanyId(int companyId);
}
