package com.viewol.cardscan;


import com.alibaba.fastjson.JSONObject;
import com.viewol.util.Base64Img;
import com.youguu.core.pojo.Response;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2018/7/9.
 */
public class ScanTestHW {




    public static Response<String> sendPost(String url, Map<String, String> head,JSONObject params, String charset) {
        Response res = new Response();
        StringBuilder result = new StringBuilder();
        BufferedReader in = null;

        try {
            URL e2 = new URL(url);
            HttpURLConnection connection = (HttpURLConnection)e2.openConnection();
            connection.setRequestMethod("POST");
            for(Map.Entry<String,String> entry:head.entrySet()){
                connection.setRequestProperty(entry.getKey(), entry.getValue());
            }

            connection.setConnectTimeout(10000);
            connection.setReadTimeout(15000);
            connection.setDoOutput(true);
            connection.connect();
            String param = null;
            if(params != null && params.size() > 0) {
                StringBuilder code = new StringBuilder();


                code.append(params.toJSONString());
                byte[] line1 = code.toString().getBytes();
                connection.getOutputStream().write(line1);
            }

            int code1 = connection.getResponseCode();
            System.out.println(code1);
            if(code1 == 200) {
                in = new BufferedReader(new InputStreamReader(connection.getInputStream(), charset));

                String line2;
                while((line2 = in.readLine()) != null) {
                    result.append(line2);
                }

                res.setCode("0000");
                res.setMsg("ok");
                res.setT(result.toString());
            } else {
                res.setCode("1001");
                res.setMsg("返回码异常:" + code1);
            }
        } catch (SocketTimeoutException var22) {
            res.setCode("1001");
            res.setMsg("连接超时");
            var22.printStackTrace();
        } catch (Exception var23) {
            res.setCode("1001");
            res.setMsg("连接异常");
            var23.printStackTrace();
        } finally {
            try {
                if(in != null) {
                    in.close();
                }
            } catch (Exception var21) {
                res.setCode("1002");
                res.setMsg("关闭连接异常");
                var21.printStackTrace();
            }

        }

        return res;
    }

    public static void main(String[] args) {


        String base64Img = Base64Img.GetImageStrFromPath("D:\\IMG_0562_1.JPG");

        String url = "http://businesscard.aliapi.hanvon.com/rt/ws/v1/ocr/bcard/recg?code=91f6a58d-e418-4e58-8ec2-61b583c55ba2";
        String path = "/rt/ws/v1/ocr/bcard/recg";
        String method = "POST";
        String appcode = "b1569a310a8c42afb4a62fc71f8341e9";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        JSONObject json = new JSONObject();
        json.put("uid","218.244.44.74");
        json.put("lang","chns");
        json.put("color","color");

        json.put("image", base64Img.replaceAll("\\r\\n",""));


        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            Response<String> res = sendPost(url,headers,json,"UTF-8");
            System.out.println(res.toString());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
