package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.IWxTokenDAO;
import com.viewol.pojo.WxToken;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2018/7/19.
 */
@Repository("wxTokenDAO")
public class WxTokenDAOImpl extends BaseDAO<WxToken> implements IWxTokenDAO {
    @Override
    public int updateToken(String appId, String token) {
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("tokenTime", new Date());
        map.put("appId", appId);
        map.put("cTime", new Date());
        return super.updateBy("uodateToken", map);
    }

    @Override
    public int updateJsapiTicket(String appId, String jsapiTicket) {
        Map<String, Object> map = new HashMap<>();
        map.put("jsapiTicket", jsapiTicket);
        map.put("ticketTime", new Date());
        map.put("appId", appId);
        map.put("cTime", new Date());
        return super.updateBy("uodateJsapiTicket", map);
    }

    @Override
    public WxToken getWxToken(String appId) {
        return findUniqueBy("getWxToken", appId);
    }
}
