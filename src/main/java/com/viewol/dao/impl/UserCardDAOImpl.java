package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.IBUserDAO;
import com.viewol.dao.IUserCardDAO;
import com.viewol.pojo.UserCard;
import com.viewol.pojo.UserCardVO;
import com.viewol.pojo.query.UserCardQuery;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2018/7/9.
 */
@Repository("userCardDAO")
public class UserCardDAOImpl extends BaseDAO<UserCard> implements IUserCardDAO {
    @Override
    public int addUserCard(UserCard userCard) {
        userCard.setcTime(new Date());
        return super.insert(userCard);
    }

    @Override
    public PageHolder<UserCardVO> queryUserCard(UserCardQuery query) {
        return super.pagedQuery("findByParams",query.getMap(),query.getPageIndex(),query.getPageSize());
    }

    @Override
    public List<UserCardVO> listUserCard(UserCardQuery query) {
        return super.findBy("listUserCard",query.getMap());
    }
}
