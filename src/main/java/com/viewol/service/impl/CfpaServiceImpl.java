package com.viewol.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.viewol.pojo.CfpaCompany;
import com.viewol.pojo.CfpaProduct;
import com.viewol.service.CfpaService;
import com.viewol.util.HttpUtil;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("cfpaService")
public class CfpaServiceImpl implements CfpaService {
    private static final Log log = LogFactory.getLog(CfpaServiceImpl.class);

    @Override
    public List<CfpaCompany> queryAllCfpaCompany() {
        try {
            String url = "http://101.39.228.80:18088/qyjbxx/list";
            String resJson = HttpUtil.doPost(url, null);

            JSONObject obj1 = JSONObject.parseObject(resJson);
            JSONObject resultObj = obj1.getJSONObject("result");
            JSONArray listArray = resultObj.getJSONArray("list");
            String js = JSONObject.toJSONString(listArray, SerializerFeature.WriteClassName);
            List<CfpaCompany> list = JSONObject.parseArray(js, CfpaCompany.class);
            return list;
        } catch (Exception e) {
            log.error("queryAllCfpaCompany error", e);
        }

        return null;
    }

    @Override
    public CfpaCompany getCfpaCompany(String userNum) {
        String url = "http://101.39.228.80:18088/qyjbxx/list";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("tyshxydm", userNum);
        String resJson = HttpUtil.doPost(url, paramMap);

        return null;
    }

    @Override
    public List<CfpaProduct> getCfpaProduct(String userNum) {
        String url = "http://101.39.228.80:18088/qyjbxx/listAllCpjs";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("tyshxydm", userNum);
        String resJson = HttpUtil.doPost(url, paramMap);

        return null;
    }

    @Override
    public List<CfpaProduct> queryAllCfpaProduct() {
        try {
            String url = "http://101.39.228.80:18088/qyjbxx/listAllCpjs";
            String resJson = HttpUtil.doPost(url, null);
            JSONObject obj1 = JSONObject.parseObject(resJson);
            JSONArray listArray = obj1.getJSONArray("result");
            String js = JSONObject.toJSONString(listArray, SerializerFeature.WriteClassName);
            List<CfpaProduct> list = JSONObject.parseArray(js, CfpaProduct.class);
            return list;
        } catch (Exception e) {
            log.error("queryAllCfpaProduct", e);
        }

        return null;
    }
}
