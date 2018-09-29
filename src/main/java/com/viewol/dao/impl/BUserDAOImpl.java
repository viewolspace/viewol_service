package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.IBUserDAO;
import com.viewol.pojo.BUser;
import com.viewol.pojo.query.BUserQuery;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/7/9.
 */
@Repository("bUserDAO")
public class BUserDAOImpl extends BaseDAO<BUser> implements IBUserDAO {
    @Override
    public List<BUser> listByCom(int comId) {
        Map<String,Object> map = new HashMap<>();
        map.put("companyId",comId);
        return super.findBy("listByCom",map);
    }

    @Override
    public BUser getFirstBuser(int comId) {
        Map<String,Object> map = new HashMap<>();
        map.put("companyId",comId);
        return super.findUniqueBy("getFirstBuser",map);
    }

    @Override
    public BUser getBUser(int uid) {
        return super.get(uid);
    }

    @Override
    public BUser getBUser(String openId) {
        Map<String,Object> map = new HashMap<>();
        map.put("openId",openId);
        return super.findUniqueBy("getUserByOpenId",map);
    }

    @Override
    public int addBUser(BUser user) {
        Date  d = new Date();
        user.setcTime(d);
        user.setmTime(d);
        int result = super.insert(user);
        if(result > 0){
            return user.getUserId();
        }else{
            return 0;
        }
    }

    @Override
    public int upDateBUser(BUser user) {
        user.setmTime(new Date());
        return super.update(user);
    }

    @Override
    public int setStatus(int userId, int status) {
        Map<String,Object> map = new HashMap<>();
        map.put("status",status);
        map.put("mTime",new Date());
        map.put("userId",userId);
        return super.updateBy("setStatus",map);
    }

    @Override
    public PageHolder<BUser> queryBUser(BUserQuery query) {
        Map<String,Object> map =new HashMap<>();
        map.put("userName",query.getUserName());
        map.put("phone",query.getPhone());
        map.put("companyId",query.getCompanyId());
        map.put("status",query.getStatus());

        return super.pagedQuery("findByParams", map, query.getPageIndex(), query.getPageSize());
    }
}
