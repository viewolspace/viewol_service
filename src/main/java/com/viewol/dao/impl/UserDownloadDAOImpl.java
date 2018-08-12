package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.IUserDownloadDAO;
import com.viewol.pojo.UserDownload;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/7/17.
 */
@Repository("userDownloadDAO")
public class UserDownloadDAOImpl extends BaseDAO<UserDownload> implements IUserDownloadDAO {
    @Override
    public int addUserDownload(UserDownload userDownload) {
        userDownload.setcTime(new Date());
        int result = super.insert(userDownload);
        if(result>0){
            return userDownload.getId();
        }
        return 0;
    }

    @Override
    public UserDownload getUserDownload(int userId, int productId) {

        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("productId",productId);
        return super.findUniqueBy("isDownload",map);
    }

    @Override
    public List<UserDownload> listDownload(int userId, int num, int lastId) {

        if(lastId<=0){
            lastId = Integer.MAX_VALUE;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("num",num);
        map.put("lastId",lastId);
        return super.findBy("listDownload",map);
    }

    @Override
    public List<UserDownload> queryByIds(List<Integer> ids) {
        Map<String,Object> map = new HashMap<>();
        map.put("ids",ids);
        return super.findBy("queryByIds",map);
    }
}
