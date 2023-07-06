package com.viewol.service.impl;

import com.viewol.dao.IApplyUserDAO;
import com.viewol.pojo.ApplyUser;
import com.viewol.pojo.query.ApplyUserQuery;
import com.viewol.service.IApplyUserService;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("applyUserService")
public class ApplyUserServiceImpl implements IApplyUserService {

    @Resource
    private IApplyUserDAO applyUserDAO;

    @Override
    public int addApplyUser(ApplyUser applyUser) {
        return applyUserDAO.addApplyUser(applyUser);
    }

    @Override
    public int updateStatus(int id, int status) {
        return applyUserDAO.updateStatus(id, status);
    }

    @Override
    public ApplyUser isApply(String phone) {
        return applyUserDAO.isApply(phone);
    }

    @Override
    public PageHolder<ApplyUser> queryBUser(ApplyUserQuery query) {
        return applyUserDAO.queryBUser(query);
    }

    @Override
    public ApplyUser getApplyUser(int id) {
        return applyUserDAO.getApplyUser(id);
    }
}
