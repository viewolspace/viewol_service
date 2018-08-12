package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.IUserCollectionDAO;
import com.viewol.pojo.UserCollection;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/7/16.
 */
@Repository("userCollectionDAO")
public class UserCollectionDAOImpl extends BaseDAO<UserCollection> implements IUserCollectionDAO {
    @Override
    public int addUserCollection(UserCollection userCollection) {
        userCollection.setcTime(new Date());
        int result = super.insert(userCollection);
        if(result > 0){
            return userCollection.getId();
        }
        return 0;
    }

    @Override
    public int delUserCollection(int userId, int type, int thirdId) {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("type",type);
        map.put("thirdId",thirdId);
        return super.deleteBy("deleteByMap",map);
    }

    @Override
    public int isCollection(int userId, int type, int thirdId) {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("type",type);
        map.put("thirdId",thirdId);
        UserCollection userCollection = super.findUniqueBy("isCollection",map);
        if(userCollection!=null){
            return 1;
        }
        return 0;
    }

    @Override
    public List<UserCollection> listUserCollection(int userId, int type, int num, int lastId) {
        if(lastId <= 0){
            lastId = Integer.MAX_VALUE;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("type",type);
        map.put("num",num);
        map.put("lastId",lastId);
        return super.findBy("listUserCollection",map);
    }
}
