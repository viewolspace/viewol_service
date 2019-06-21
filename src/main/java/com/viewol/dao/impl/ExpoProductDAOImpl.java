package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.IExpoProductDAO;
import com.viewol.pojo.ExpoProduct;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2019/6/20.
 */
@Repository("expoProductDAO")
public class ExpoProductDAOImpl extends BaseDAO<ExpoProduct> implements IExpoProductDAO{
    @Override
    public int saveExpoProduct(int expoId, int productId) {
        ExpoProduct expoProduct = new ExpoProduct();
        expoProduct.setExpoId(expoId);
        expoProduct.setProductId(productId);
        expoProduct.setcTime(new Date());
        return super.insert(expoProduct);
    }

    @Override
    public int delExpoProduct(int productId) {
        Map<String,Object> map = new HashMap<>();
        map.put("productId",productId);
        return super.deleteBy("deleteExpoProduct",map);
    }
}
