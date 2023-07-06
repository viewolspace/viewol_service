package com.viewol.service;

import com.viewol.pojo.ApplyUser;
import com.viewol.pojo.query.ApplyUserQuery;
import com.youguu.core.util.PageHolder;

public interface IApplyUserService {

    int addApplyUser(ApplyUser applyUser);

    int updateStatus(int id,int status);

    ApplyUser isApply(String phone);

    PageHolder<ApplyUser> queryBUser(ApplyUserQuery query);

    ApplyUser getApplyUser(int id);

}
