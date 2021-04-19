package com.viewol.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.viewol.pojo.CfpaCompany;
import com.viewol.pojo.CfpaProduct;
import com.viewol.service.CfpaService;
import com.viewol.util.APIHttpClient;
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
            String resJson = APIHttpClient.post(url, "{}");

            JSONObject obj = JSONObject.parseObject(resJson);
            String code = obj.getString("code");
            if ("00000000".equals(code)) {
                JSONArray listArray = obj.getJSONArray("result");
                List<CfpaCompany> list = JSONObject.parseArray(listArray.toJSONString(), CfpaCompany.class);
                return list;
            }
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
        String resJson = APIHttpClient.post(url, JSON.toJSONString(paramMap));
        log.info("获取展商数据：", resJson);
        JSONObject obj = JSONObject.parseObject(resJson);
        String code = obj.getString("code");
        if ("00000000".equals(code)) {
            JSONObject row = (JSONObject) obj.getJSONArray("result").get(0);
            CfpaCompany cfpaCompany = JSONObject.parseObject(row.toJSONString(), CfpaCompany.class);
            return cfpaCompany;
        }
        return null;
    }

    @Override
    public List<CfpaProduct> getCfpaProduct(String userNum) {
        String url = "http://101.39.228.80:18088/qyjbxx/listAllCpjs";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("tyshxydm", userNum);
        String resJson = APIHttpClient.post(url, JSON.toJSONString(paramMap));

        log.info("获取产品数据：", resJson);
        JSONObject obj = JSONObject.parseObject(resJson);
        String code = obj.getString("code");
        if ("00000000".equals(code)) {
            JSONObject row = (JSONObject) obj.getJSONArray("result").get(0);
            String productStr = row.getJSONArray("qycpjsVOs").toJSONString();
            List<CfpaProduct> list = JSONObject.parseArray(productStr, CfpaProduct.class);
            return list;
        }
        return null;
    }

    @Override
    public List<CfpaCompany> queryAllCfpaProduct() {
        try {
            String url = "http://101.39.228.80:18088/qyjbxx/listAllCpjs";
            String resJson = APIHttpClient.post(url, "{}");
            System.out.println(resJson);
            JSONObject obj = JSONObject.parseObject(resJson);
            String code = obj.getString("code");
            if ("00000000".equals(code)) {
                JSONArray listArray = obj.getJSONArray("result");
                List<CfpaCompany> list = JSONObject.parseArray(listArray.toJSONString(), CfpaCompany.class);
                return list;
            }
        } catch (Exception e) {
            log.error("queryAllCfpaProduct", e);
        }

        return null;
    }
}
