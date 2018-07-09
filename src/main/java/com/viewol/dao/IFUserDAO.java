package com.viewol.dao;

import com.viewol.pojo.FUser;
import com.viewol.pojo.query.FUserQuery;
import com.youguu.core.util.PageHolder;

/**
 * Created by lenovo on 2018/7/5.
 */
public interface IFUserDAO {

    int addFUser(FUser user);

    int updateFUser(FUser user);

    FUser getFuser(int userId);

    FUser getUserByUuid(String uuid);

    PageHolder<FUser> querFUser(FUserQuery query);
}
