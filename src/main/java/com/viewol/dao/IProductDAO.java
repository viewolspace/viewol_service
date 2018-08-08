package com.viewol.dao;

import com.viewol.pojo.Product;
import com.viewol.pojo.query.ProductQuery;
import com.youguu.core.util.PageHolder;

import java.util.List;

/**
 * Created by lenovo on 2018/6/29.
 */
public interface IProductDAO {

    Product getProduct(int id);

    int addProduct(Product product);

    int delProduct(int  id);

    int updateProduct(Product product);

    //修改上架 下架状态
    int updateStatus(int id,int status);

    //查询公司产品数量
    int comProductCount(int companyId);

    //管理平台查询产品
    PageHolder<Product> queryProduct(ProductQuery query);

    //删除推荐
    int delRecomment(int id);

    //添加推荐
    int addRecomment(int id,int num);

    //查询推荐产品
    List<Product> queryRecommentProduct();

    //客户端查询
    List<Product> listProduct(ProductQuery query);

    //删除置顶
    int delTop(int id);

    //添加推荐
    int addTop(int id,int num);

    //查询推荐产品
    List<Product> queryTopProduct();


}
