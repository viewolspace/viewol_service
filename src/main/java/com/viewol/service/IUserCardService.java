package com.viewol.service;

import com.viewol.pojo.UserCard;
import com.viewol.pojo.UserCardVO;
import com.viewol.pojo.query.UserCardQuery;
import com.youguu.core.util.PageHolder;

import java.util.List;

/**
 * Created by lenovo on 2018/7/9.
 */
public interface IUserCardService {

    int addUserCard(int fUserId,int bUserId,int companyId);

    int addUserCard(UserCard userCard);

    PageHolder<UserCardVO> queryUserCard(UserCardQuery query);

    List<UserCardVO> listUserCard(UserCardQuery query);
}
