package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.IProductDAO;
import com.viewol.pojo.Company;
import com.viewol.pojo.Product;
import com.viewol.pojo.query.ProductQuery;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/6/29.
 */
@Repository("productDAO")
public class ProductDAOImpl extends BaseDAO<Product> implements IProductDAO {
    @Override
    public int addProduct(Product product) {
        Date d = new Date();
        product.setcTime(d);
        product.setmTime(d);

        int result = super.insert(product);
        if (result > 0) {
            this.updateSeq(product);
            return product.getId();
        } else {
            return 0;
        }

    }

    @Override
    public Product getProduct(int id) {
        return super.get(id);
    }

    @Override
    public Product selectByUuid(String uuid) {
        Map<String, Object> map = new HashMap<>();
        map.put("uuid", uuid);
        return super.findUniqueBy("selectByUuid", map);
    }

    @Override
    public int delProduct(int id) {
        return super.delete(id);
    }

    @Override
    public int updateProduct(Product product) {
        product.setmTime(new Date());
        product.setSeq(this.getSeq(product));
        return super.update(product);
    }

    @Override
    public int updateStatus(int id, int status) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("status", status);
        return super.updateBy("updateStatus", map);
    }

    @Override
    public PageHolder<Product> queryProduct(ProductQuery query) {
        Map<String, Object> map = new HashMap<>();
        map.put("categoryId", query.getCategoryId());
        map.put("companyId", query.getCompanyId());
        map.put("name", query.getName());
        map.put("status", query.getStatus());
        map.put("expoId", query.getExpoId());
        return super.pagedQuery("findByParams", map, query.getPageIndex(), query.getPageSize());
    }

    @Override
    public int delRecomment(int id) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("isRecommend", Company.ISRECOMMEND_NO);
        map.put("recommendNum", 0);
        int result = super.updateBy("updateRecommend", map);
        Product product = this.getProduct(id);
        this.updateSeq(product);
        return result;
    }

    @Override
    public int addRecomment(int id, int num) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("isRecommend", Company.ISRECOMMEND_YES);
        map.put("recommendNum", num);
        int result = super.updateBy("updateRecommend", map);
        Product product = this.getProduct(id);
        this.updateSeq(product);
        return result;
    }


    @Override
    public List<Product> listProduct(ProductQuery query) {
        Map<String, Object> map = new HashMap<>();
        map.put("categoryId", query.getCategoryId());
        map.put("companyId", query.getCompanyId());
        map.put("name", query.getName());
        map.put("status", Product.STATUS_ON);
        map.put("num", query.getPageSize());
        map.put("lastSeq", query.getLastSeq());
        map.put("expoId", query.getExpoId());
        map.put("award", query.getAward());
        return this.findBy("listProduct", map);
    }

    @Override
    public List<Product> queryRecommentProduct(int expoId) {
        Map<String, Object> map = new HashMap<>();
        map.put("expoId", expoId);
        return super.findBy("queryRecommentProduct", map);
    }


    @Override
    public int comProductCount(int companyId) {
        Map<String, Object> map = new HashMap<>();
        map.put("companyId", companyId);
        return super.count("comProductCount", map);
    }

    private long getSeq(Product product) {
        int id = product.getId();
        int num = product.getTopNum();

        Date date = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");

        if (num > 0) {
            num = 100 - num;
        }

        long seq = num * 10000000000L + Long.parseLong(dateFormat.format(date));
        return seq;
    }


    private int updateSeq(Product product) {

        long seq = this.getSeq(product);
        Map<String, Object> map = new HashMap<>();
        map.put("seq", seq);
        map.put("id", product.getId());
        return super.updateBy("updateSeq", map);

    }

    @Override
    public int delTop(int id) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("topNum", 0);
        int result = super.updateBy("updateTopNum", map);
        Product product = this.getProduct(id);
        this.updateSeq(product);
        return result;
    }

    @Override
    public int addTop(int id, int num) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("topNum", num);
        int result = super.updateBy("updateTopNum", map);
        Product product = this.getProduct(id);
        this.updateSeq(product);
        return result;
    }

    @Override
    public List<Product> queryTopProduct(int expoId) {
        Map<String, Object> map = new HashMap<>();
        map.put("expoId", expoId);
        return super.findBy("queryTopProduct", map);
    }

    @Override
    public List<Product> listProductByIds(List<Integer> ids) {
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        return super.findBy("listProductByIds", map);
    }

    @Override
    public int incSeeNum(int id) {
        Map<String, Object> map = new HashMap<>();
        map.put("seeNum", 1);
        map.put("id", id);
        return super.updateBy("updateInteractNum", map);
    }

    @Override
    public int incPraiseNum(int id) {
        Map<String, Object> map = new HashMap<>();
        map.put("praiseNum", 1);
        map.put("id", id);
        return super.updateBy("updateInteractNum", map);
    }

    @Override
    public int incCommentNum(int id) {
        Map<String, Object> map = new HashMap<>();
        map.put("commentNum", 1);
        map.put("id", id);
        return super.updateBy("updateInteractNum", map);
    }
}
