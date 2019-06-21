package com.viewol.service;

import com.viewol.pojo.Product;
import com.viewol.pojo.query.ProductQuery;
import com.youguu.core.util.PageHolder;

import java.util.List;

/**
 * Created by lenovo on 2018/6/30.
 */
public interface IProductService {

    Product getProduct(int id);

    /**
     * -98 展商不存在
     * -99 超过允许添加产品的上限
     * @param product
     * @return
     */
    int addProduct(int expoId,Product product);

    int delProduct(int  id);

    int updateProduct(Product product);

    //修改上架 下架状态
    int updateStatus(int id,int status);

    //管理平台查询产品
    PageHolder<Product> queryProduct(ProductQuery query);

    //删除推荐
    int delRecomment(int id);

    //添加推荐
    int addRecomment(int id,int num);

    //查询推荐产品
    List<Product> queryRecommentProduct(int expoId);

    //客户端查询
    List<Product> listProduct(int expoId,int companyId,String name,String categoryId,long lastSeq,int num);

    //删除置顶
    int delTop(int id);

    //添加推荐
    int addTop(int id,int num);

    //查询推荐产品
    List<Product> queryTopProduct(int expoId);


    //通过id查询
    List<Product> listProductByIds(List<Integer> ids);

}
