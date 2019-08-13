package com.viewol.service.impl;

import com.viewol.dao.ICompanyDAO;
import com.viewol.dao.IExpoProductDAO;
import com.viewol.dao.IProductDAO;
import com.viewol.dao.IProductIdeaDAO;
import com.viewol.pojo.Company;
import com.viewol.pojo.Product;
import com.viewol.pojo.query.ProductQuery;
import com.viewol.service.IProductService;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private IExpoProductDAO expoProductDAO;


    @Resource
    private ICompanyDAO companyDAO;

    @Resource
    private IProductIdeaDAO productIdeaDAO;

    @Override
    public Product getProduct(int id) {
        return productDAO.getProduct(id);
    }

    @Transactional("viewolTX")
    @Override
    public int addProduct(int expoId,Product product) {
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
        int result = 0;

        result = productDAO.addProduct(product);

        expoProductDAO.saveExpoProduct(expoId,product.getId());

        return result;
    }

    @Transactional("viewolTX")
    @Override
    public int delProduct(int id) {
        expoProductDAO.delExpoProduct(id);
        productIdeaDAO.deleteProductIdea(id);
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
    public List<Product> queryRecommentProduct(int expoId) {
        return productDAO.queryRecommentProduct(expoId);
    }

    @Override
    public List<Product> listProduct(int expoId,int companyId, String name, String categoryId, int award,long lastSeq, int num) {
        ProductQuery query = new ProductQuery();
        if(companyId!=0){
            query.setCompanyId(companyId);
        }
        query.setName(name);
        query.setCategoryId(categoryId);
        query.setPageSize(num);
        query.setLastSeq(lastSeq);
        query.setExpoId(expoId);
        query.setAward(award);
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
    public List<Product> queryTopProduct(int expoId) {
        return productDAO.queryTopProduct(expoId);
    }

    @Override
    public List<Product> listProductByIds(List<Integer> ids) {
        return productDAO.listProductByIds(ids);
    }
}
