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
public class WxTokenDAOImpl  extends BaseDAO<WxToken> implements IWxTokenDAO {
    @Override
    public int updateToken(int type, String token) {

        Map<String,Object> map = new HashMap<>();
        map.put("token",token);
        map.put("mTime",new Date());
        map.put("type",type);
        return super.updateBy("uodateToken",map);
    }

    @Override
    public WxToken getWxToken(int type) {
        return super.get(type);
    }
}
