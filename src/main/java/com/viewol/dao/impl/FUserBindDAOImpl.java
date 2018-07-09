package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.IFUserBindDAO;
import com.viewol.pojo.FUserBind;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2018/7/6.
 */
@Repository("fUserBindDAO")
public class FUserBindDAOImpl extends BaseDAO<FUserBind> implements IFUserBindDAO{
    @Override
    public int addFUserBind(FUserBind userBind) {
        userBind.setcTime(new Date());
        int result = super.insert(userBind);
        if(result>0){
            return result;
        }else{
            return 0;
        }
    }

    @Override
    public boolean isExist(int type, String openId) {
        Map<String,Object> map = new HashMap<>();
        map.put("type",type);
        map.put("openId",openId);
        FUserBind userBind = super.findUniqueBy("selectByopenId",map);
        if(userBind==null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public FUserBind getOpenId(int userId, int type) {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("type",type);
        return super.findUniqueBy("getOpenId",map);
    }
}
