package com.viewol.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2019/7/29.
 */
public class CiecImpl {
    public JSONObject getUserFromNobile(String mobile){
        JSONObject json = null;
        try {
            String jsoncommond ="{"
                    +"\"request\":{"
                    +" \"aPPID\":\"FIRE\","
                    +" \"aPPKEY\":\"FIREq1w2E#R$\","
                    +" \"command\":\"rslistvinfozz\","
                    +" \"openID\":\""+mobile+"\","
                    + "\"source\":\"WEB\","
                    +" \"projno\":\"92072\""
                    +" }," +"\"data\":{"
                    +" \"SPECT_MOBILE\":\""+mobile+"\""
                    +" } }";
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost("http://weixin.ciec.com.cn:8080/ciecWS/sAPICall");
            List nvps = new ArrayList();
            nvps.add(new BasicNameValuePair("jsoncommond", jsoncommond));

            httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
            CloseableHttpResponse response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String APIresult = "";
            if (entity != null) {
                APIresult = EntityUtils.toString(entity, "utf-8");
                JSONObject json_tem = JSON.parseObject(APIresult);
                JSONObject res = json_tem.getJSONObject("return");
                String retCode = res.getString("retCode");
                if("api00".equals(retCode)){
                    JSONArray ja = json_tem.getJSONArray("data");
                    if (ja.size()>0){
                        json =  ja.getJSONObject(0);
                    }
                }
            }
            System.out.println(APIresult);
            EntityUtils.consume((org.apache.http.HttpEntity) entity);
            response.close();
            response.close();
            httpclient.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return json;
    }
}
