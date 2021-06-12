package com.viewol.dao;

import com.viewol.pojo.ProductIdeaNew;
import com.viewol.pojo.query.ProductIdeaNewQuery;
import com.youguu.core.util.PageHolder;

import java.util.List;

/**
 * Created by lenovo on 2019/7/25.
 */
public interface IProductIdeaNewDAO {

    ProductIdeaNew getProductIdea(int id);

    int addProductIdea(ProductIdeaNew productIdea);

    int deleteProductIdea(int id);

    int updateStatus(int productId, int status);

    int  updateProductIdea(ProductIdeaNew productIdea);

    PageHolder<ProductIdeaNew> queryProductIdea(ProductIdeaNewQuery query);

    int countByCompanyId(int companyId);

    int updateNum(int productId);

    List<ProductIdeaNew> list(String cid, String productName,int productId,int pageIndex, int pageSize);

    int allcount();
}
