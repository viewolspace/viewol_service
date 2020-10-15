package com.viewol.dao;

/**
 * Created by lenovo on 2019/6/20.
 */
public interface IExpoProductDAO {

    int saveExpoProduct(int expoId, int productId);

    int delExpoProduct(int productId);

}
