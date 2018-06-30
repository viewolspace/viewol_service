package com.viewol.service.impl;

import com.viewol.dao.IProductDAO;
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

    @Override
    public int addProduct(Product product) {
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
}
