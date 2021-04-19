package com.viewol.util;

import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class APIHttpClient {
    private static final Log logger = LogFactory.getLog(APIHttpClient.class);

    /**
     * 调用 API
     *
     * @param parameters
     * @return
     */
    public static String post(String apiURL, String parameters) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost method = new HttpPost(apiURL);

        String body = null;
        logger.info("parameters:" + parameters);

        if (method != null & parameters != null && !"".equals(parameters.trim())) {
            try {
                // 建立一个NameValuePair数组，用于存储欲传送的参数
                method.addHeader("Content-type", "application/json; charset=utf-8");
                method.setHeader("Accept", "application/json");
                method.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));
                long startTime = System.currentTimeMillis();

                HttpResponse response = httpClient.execute(method);
                long endTime = System.currentTimeMillis();
                int statusCode = response.getStatusLine().getStatusCode();

                logger.info("statusCode:" + statusCode);
                logger.info("调用API 花费时间(单位：毫秒)：" + (endTime - startTime));
                if (statusCode != HttpStatus.SC_OK) {
                    logger.error("Method failed:" + response.getStatusLine());
                }

                // Read the response body
                body = EntityUtils.toString(response.getEntity());

            } catch (IOException e) {
                logger.error("网络异常", e);
            }

        }
        return body;
    }
}