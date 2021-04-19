package com.viewol.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.viewol.pojo.CfpaCompany;
import com.viewol.pojo.CfpaProduct;
import com.viewol.service.CfpaService;
import com.viewol.util.APIHttpClient;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("cfpaService")
public class CfpaServiceImpl implements CfpaService {
    private static final Log log = LogFactory.getLog(CfpaServiceImpl.class);

    /**
     * 测试接口地址
     */
    private String testUrl = "http://101.39.228.80:18088/";
    /**
     * 生产接口地址
     */
    private String prodUrl = "http://36.129.10.24:18086/";
    /**
     * 图片地址前缀
     */
    private String prefixImg = "http://36.129.10.24:18087/upload/";

    @Override
    public List<CfpaCompany> queryAllCfpaCompany() {
        try {
            String url = prodUrl + "qyjbxx/list";
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
        String url = prodUrl + "qyjbxx/list";
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
        String url = prodUrl + "qyjbxx/listAllCpjs";
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
            String url = prodUrl + "qyjbxx/listAllCpjs";
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

    @Override
    public void downloadImg(String path) {
        try {
            String savePath = "/data/nginx/download/viewol-img/";
            // 构造URL
            URL url = new URL(prefixImg + path);
            // 打开连接
            URLConnection con = url.openConnection();
            //设置请求超时为5s
            con.setConnectTimeout(5 * 1000);
            // 输入流
            InputStream is = con.getInputStream();

            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流
            File sf = new File(savePath + path);
            File filePath = new File(sf.getParent());
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            sf = new File(savePath);

            OutputStream os = new FileOutputStream(sf.getPath()+path);
            // 开始读取
            while ((len = is.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
            // 完毕，关闭所有链接
            os.close();
            is.close();
        } catch (Exception e) {
            log.error("图片下载失败", e);
        }

    }
}
