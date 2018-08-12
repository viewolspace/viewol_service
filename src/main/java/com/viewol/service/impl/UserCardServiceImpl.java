package com.viewol.service.impl;

import com.viewol.dao.IUserCardDAO;
import com.viewol.pojo.UserCard;
import com.viewol.pojo.UserCardVO;
import com.viewol.pojo.query.UserCardQuery;
import com.viewol.service.IUserCardService;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2018/7/9.
 */
@Service("userCardService")
public class UserCardServiceImpl implements IUserCardService {

    @Resource
    private IUserCardDAO iUserCardDAO;

    @Override
    public int addUserCard(int fUserId, int bUserId, int companyId) {



        UserCard userCard = new UserCard();
        userCard.setbUserId(bUserId);
        userCard.setfUserId(fUserId);
        userCard.setCompanyId(companyId);
        return iUserCardDAO.addUserCard(userCard);
    }

    @Override
    public int addUserCard(UserCard userCard) {
        return iUserCardDAO.addUserCard(userCard);
    }

    @Override
    public PageHolder<UserCardVO> queryUserCard(UserCardQuery query) {
        return iUserCardDAO.queryUserCard(query);
    }

    @Override
    public List<UserCardVO> listUserCard(UserCardQuery query) {
        return iUserCardDAO.listUserCard(query);
    }
}
