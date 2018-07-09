package com.viewol.dao;

import com.viewol.base.BaseTestClass;
import com.viewol.pojo.UserCard;
import com.viewol.pojo.UserCardVO;
import com.viewol.pojo.query.UserCardQuery;
import com.youguu.core.util.PageHolder;
import org.junit.Test;

/**
 * Created by lenovo on 2018/6/28.
 */
public class UserCardDAOImplTest extends BaseTestClass{

    private IUserCardDAO dao = (IUserCardDAO)getInstance("userCardDAO");

    @Test
    public void addUserCard(){
        UserCard userCard = new UserCard();
        userCard.setCompanyId(1);
        userCard.setfUserId(3);
        userCard.setbUserId(1);
        System.out.println(dao.addUserCard(userCard));
    }


    @Test
    public void listUserCard(){
        UserCardQuery query = new UserCardQuery();
        query.setLastId(4);
        query.setCompanyId(1);
        query.setPageSize(1);
        System.out.println(dao.listUserCard(query));
    }


    @Test
    public void queryUserCard(){
        UserCardQuery query = new UserCardQuery();
        query.setCompanyId(1);
        query.setPageSize(1);
        query.setPageIndex(3);
        PageHolder<UserCardVO> list = dao.queryUserCard(query);
        System.out.println(list);
        for (UserCardVO vo:list.getList()){
            System.out.println(vo);
        }
    }




}
