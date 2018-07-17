package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.IUserBrowseDAO;
import com.viewol.pojo.UserBrowse;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/7/17.
 */
@Repository("userBrowseDAO")
public class UserBrowseDAOImpl  extends BaseDAO<UserBrowse> implements IUserBrowseDAO {
    @Override
    public int addUserBrowse(UserBrowse userBrowse) {
        userBrowse.setcTime(new Date());
        return super.insert(userBrowse);
    }


    @Override
    public List<UserBrowse> listUserBrowse(int userId, int type, int num, int lastId) {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("type",type);
        map.put("num",num);
        map.put("lastId",lastId);
        return super.findBy("listUserBrowse",map);
    }
}
