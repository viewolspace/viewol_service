package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.IProductIdeaNewDAO;
import com.viewol.pojo.ProductIdeaNew;
import com.viewol.pojo.query.ProductIdeaNewQuery;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2019/7/25.
 */
@Repository("productIdeaNewDAO")
public class ProductIdeaNewDAOImpl extends BaseDAO<ProductIdeaNew> implements IProductIdeaNewDAO {

    @Override
    public ProductIdeaNew getProductIdea(int id) {
        return super.get(id);
    }

    @Override
    public int addProductIdea(ProductIdeaNew productIdea) {
        Date d = new Date();
        productIdea.setcTime(d);
        productIdea.setmTime(d);
        return super.insert(productIdea);
    }

    @Override
    public int deleteProductIdea(int id) {
        return super.delete(id);
    }

    @Override
    public int updateProductIdea(ProductIdeaNew productIdea) {
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
    public int updateNum(int productId) {
        Map<String,Object> map = new HashMap<>();
        map.put("productId",productId);
        return super.updateBy("updateNum",map);
    }

    @Override
    public PageHolder<ProductIdeaNew> queryProductIdea(ProductIdeaNewQuery query) {
        return super.pagedQuery("findByParams",query.map(),query.getPageIndex(),query.getPageSize());
    }

    @Override
    public int countByCompanyId(int companyId) {
        return super.count("countByCompanyId11", companyId);
    }


    @Override
    public List<ProductIdeaNew> list(String cid, String productName,int productId, int pageIndex, int pageSize) {
        Map<String,Object> map = new HashMap<>();
        if(cid!=null && !"".equals(cid)){
            map.put("categoryId",cid);
        }
        if(productName!=null && !"".equals(productName)){
            map.put("productName",productName);
        }
        if(productId > 0 ){
            map.put("productId",productId);
        }
        map.put("start",(pageIndex-1)*pageSize);
        map.put("end",pageSize);
        return super.findBy("list",map);
    }


    @Override
    public int allcount() {
        return super.count("allcount",null);
    }
}
