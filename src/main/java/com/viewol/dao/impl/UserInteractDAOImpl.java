package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.IUserInteractDAO;
import com.viewol.pojo.UserInteract;
import com.viewol.pojo.query.UserInteractQuery;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2019/7/4.
 */
@Repository("userInteractDAO")
public class UserInteractDAOImpl extends BaseDAO<UserInteract> implements IUserInteractDAO {
    @Override
    public int addUserInteract(UserInteract userInteract) {
        userInteract.setcTime(new Date());
        int result = super.insert(userInteract);
        return userInteract.getId();
    }

    @Override
    public List<UserInteract> queryList(int thirdId, int classify, int type, int num) {
        Map<String, Object> map = new HashMap<>();
        map.put("thirdId", thirdId);
        map.put("classify", classify);
        map.put("type", type);
        map.put("num", num);
        return super.findBy("listUserInteract", map);
    }

    @Override
    public List<UserInteract> queryUserInteract(int userId, int thirdId, int classify) {
        Map<String, Object> map = new HashMap<>();
        map.put("thirdId", thirdId);
        map.put("classify", classify);
        map.put("userId", userId);
        map.put("num", 5);
        return super.findBy("listUserInteract", map);
    }

    @Override
    public UserInteract getUserInteract(int userId, int thirdId, int classify, int type) {
        Map<String, Object> map = new HashMap<>();
        map.put("thirdId", thirdId);
        map.put("classify", classify);
        map.put("userId", userId);
        map.put("type", type);
        map.put("num", 1);
        return super.findUniqueBy("listUserInteract", map);
    }

    @Override
    public int reply(int id, String reply) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("reply", reply);

        return super.updateBy("updateReplay", map);
    }

    @Override
    public List<UserInteract> queryComList(int companyId, int thirdId, int classify, int type, int maxId, int num) {
        Map<String, Object> map = new HashMap<>();
        map.put("thirdId", thirdId);
        map.put("classify", classify);
        map.put("companyId", companyId);
        map.put("type", type);
        map.put("num", num);
        map.put("maxId", maxId);
        return super.findBy("listUserInteract", map);
    }

    @Override
    public PageHolder<UserInteract> queryUserInteract(UserInteractQuery query) {
        return this.pagedQuery("findByParams", query.map(), query.getPageIndex(), query.getPageSize());
    }
}
