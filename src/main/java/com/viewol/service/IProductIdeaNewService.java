package com.viewol.service;

import com.viewol.pojo.ProductIdeaNew;
import com.viewol.pojo.query.ProductIdeaNewQuery;
import com.youguu.core.util.PageHolder;

/**
 * Created by lenovo on 2019/7/25.
 */
public interface IProductIdeaNewService {
    ProductIdeaNew getProductIdea(int id);

    int addProductIdea(ProductIdeaNew productIdea);

    int updateStatus(int productId, int status);

    int  updateProductIdea(ProductIdeaNew productIdea);

    PageHolder<ProductIdeaNew> queryProductIdea(ProductIdeaNewQuery query);

    int countByCompanyId(int companyId);
}
