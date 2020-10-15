package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.IBbsJoinDAO;
import com.viewol.pojo.BbsJoin;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2019/10/9.
 */
@Repository("bbsJoinDAO")
public class BbsJoinDAOImpl extends BaseDAO<BbsJoin> implements IBbsJoinDAO{

    @Override
    public BbsJoin getBbsJoin(int id) {
        return super.get(id);
    }

    @Override
    public BbsJoin getBbsJoin(String phone,int bbsId) {
        Map<String,Object> map = new HashMap<>();
        map.put("phone",phone);
        map.put("bbsId",bbsId);
        return super.findUniqueBy("selectByPhone",map);
    }

    @Override
    public int addBbsJoin(BbsJoin bbsJoin) {
        int result = super.insert(bbsJoin);
        if(result>0){
            return bbsJoin.getId();
        }
        return result;
    }

    @Override
    public int signIn(int id,int status) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("status",status);
        return super.updateBy("updateStatus",map);
    }
}
