package com.viewol.service;

import com.alibaba.fastjson.JSONObject;
import com.viewol.base.BaseTestClass;
import com.viewol.pojo.CfpaCompany;
import com.viewol.pojo.CfpaProduct;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CfpaServiceImplTest extends BaseTestClass {

    private CfpaService service = (CfpaService)getInstance("cfpaService");

    @Test
    public void queryAllCfpaCompany() {
        List<CfpaCompany> list = service.queryAllCfpaCompany();
        System.out.println(JSONObject.toJSONString(list));
    }

    @Test
    public void getCfpaCompany() {
        CfpaCompany cfpaCompany = service.getCfpaCompany("913101170711845481");
        System.out.println(JSONObject.toJSONString(cfpaCompany));
    }

    @Test
    public void getCfpaProduct() {
        List<CfpaProduct> list = service.getCfpaProduct("913101170711845481");
        System.out.println(JSONObject.toJSONString(list));
    }

    @Test
    public void queryAllCfpaProduct() {
        List<CfpaCompany> list = service.queryAllCfpaProduct();
        System.out.println(JSONObject.toJSONString(list));
    }
}