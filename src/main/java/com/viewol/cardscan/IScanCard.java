package com.viewol.cardscan;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * Created by lenovo on 2018/8/8.
 */
public interface IScanCard {
    /**
     * key: base64
     * @param param
     * @return
     */
    JSONObject scan(Map<String,String> param);
}
