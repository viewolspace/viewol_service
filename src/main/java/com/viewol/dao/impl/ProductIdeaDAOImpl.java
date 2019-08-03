package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.IProductIdeaDAO;
import com.viewol.pojo.ProductIdea;
import com.viewol.pojo.query.ProductIdeaQuery;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2019/7/25.
 */
@Repository("productIdeaDAO")
public class ProductIdeaDAOImpl extends BaseDAO<ProductIdea> implements IProductIdeaDAO {

    @Override
    public ProductIdea getProductIdea(int id) {
        return super.get(id);
    }

    @Override
    public int addProductIdea(ProductIdea productIdea) {
        Date d = new Date();
        productIdea.setcTime(d);
        productIdea.setmTime(d);
        return super.insert(productIdea);
    }

    @Override
    public int updateProductIdea(ProductIdea productIdea) {
        Date d = new Date();
        productIdea.setmTime(d);
        return super.update(productIdea);
    }

    @Override
    public int updateStatus(int productId, int status) {
        Map<String,Object> map = new HashMap<>();
        map.put("productId",productId);
        map.put("status",status);
        return super.updateBy("updateStatus",map);
    }

    @Override
    public PageHolder<ProductIdea> queryProductIdea(ProductIdeaQuery query) {
        return super.pagedQuery("findByParams",query.map(),query.getPageIndex(),query.getPageSize());
    }

    @Override
    public int countByCompanyId(int companyId) {
        return super.count("countByCompanyId", companyId);
    }
}
