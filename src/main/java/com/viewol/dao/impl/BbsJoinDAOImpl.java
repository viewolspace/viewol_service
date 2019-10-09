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
    public BbsJoin getBbsJoin(String phone) {
        Map<String,String> map = new HashMap<>();
        map.put("phone",phone);
        return super.findUniqueBy("selectByPhone",map);
    }

    @Override
    public int addBbsJoin(BbsJoin bbsJoin) {
        return super.insert(bbsJoin);
    }

    @Override
    public int signIn(int id,int status) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("status",status);
        return super.updateBy("updateStatus",map);
    }
}
