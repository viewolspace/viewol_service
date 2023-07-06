package com.viewol.dao;

import com.viewol.pojo.ApplyUser;
import com.viewol.pojo.query.ApplyUserQuery;
import com.youguu.core.util.PageHolder;

public interface IApplyUserDAO {

    int addApplyUser(ApplyUser applyUser);

    int updateStatus(int id,int status);

    ApplyUser getApplyUser(int id);

    //是否申请过
    ApplyUser isApply(String phone);

    PageHolder<ApplyUser> queryBUser(ApplyUserQuery query);

}
