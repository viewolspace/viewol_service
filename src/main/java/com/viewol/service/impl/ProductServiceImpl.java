package com.viewol.service.impl;

import com.viewol.dao.ICompanyDAO;
import com.viewol.dao.IProductDAO;
import com.viewol.pojo.Company;
import com.viewol.pojo.Product;
import com.viewol.pojo.query.ProductQuery;
import com.viewol.service.IProductService;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2018/6/30.
 */
@Service("productService")
public class ProductServiceImpl implements IProductService {

    @Resource
    private IProductDAO productDAO;


    @Resource
    private ICompanyDAO companyDAO;

    @Override
    public Product getProduct(int id) {
        return productDAO.getProduct(id);
    }

    @Override
    public int addProduct(Product product) {
        int comId = product.getCompanyId();

        Company company = companyDAO.getCompany(comId);

        if(company==null){
            return -98;
        }

        int num = company.getProductNum();

        int countNum = productDAO.comProductCount(comId);

        if(countNum >= num){
            return -99;
        }

        return productDAO.addProduct(product);
    }

    @Override
    public int delProduct(int id) {
        return productDAO.delProduct(id);
    }

    @Override
    public int updateProduct(Product product) {
        return productDAO.updateProduct(product);
    }

    @Override
    public int updateStatus(int id, int status) {
        return productDAO.updateStatus(id,status);
    }

    @Override
    public PageHolder<Product> queryProduct(ProductQuery query) {
        return productDAO.queryProduct(query);
    }

    @Override
    public int delRecomment(int id) {
        return productDAO.delRecomment(id);
    }

    @Override
    public int addRecomment(int id, int num) {
        return productDAO.addRecomment(id,num);
    }

    @Override
    public List<Product> queryRecommentProduct() {
        return productDAO.queryRecommentProduct();
    }

    @Override
    public List<Product> listProduct(int companyId, String name, String categoryId, long lastSeq, int num) {
        ProductQuery query = new ProductQuery();
        query.setName(name);
        query.setCategoryId(categoryId);
        query.setPageSize(num);
        query.setLastSeq(lastSeq);
        return productDAO.listProduct(query);
    }

    @Override
    public int delTop(int id) {
        return productDAO.delTop(id);
    }

    @Override
    public int addTop(int id, int num) {
        return productDAO.addTop(id, num);
    }

    @Override
    public List<Product> queryTopProduct() {
        return productDAO.queryTopProduct();
    }
}
