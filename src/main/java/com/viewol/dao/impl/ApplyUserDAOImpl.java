package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.IApplyUserDAO;
import com.viewol.pojo.ApplyUser;
import com.viewol.pojo.query.ApplyUserQuery;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository("applyUserDAO")
public class ApplyUserDAOImpl extends BaseDAO<ApplyUser> implements IApplyUserDAO {

    @Override
    public int addApplyUser(ApplyUser applyUser) {

        int result = super.insert(applyUser);
        if (result > 0) {
            applyUser.setId(result);
            return result;
        } else {
            return 0;
        }
    }

    @Override
    public ApplyUser getApplyUser(int id) {
        return super.get(id);
    }

    @Override
    public int updateStatus(int id, int status) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("status", status);
        return super.updateBy("updateStatus", map);
    }

    @Override
    public ApplyUser isApply(String phone) {
        Map<String, Object> map = new HashMap<>();
        map.put("phone", phone);
        return super.findUniqueBy("isApply", map);
    }

    @Override
    public PageHolder<ApplyUser> queryBUser(ApplyUserQuery query) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", query.getStatus());
        return super.pagedQuery("findByParams", map, query.getPageIndex(), query.getPageSize());
    }
}
