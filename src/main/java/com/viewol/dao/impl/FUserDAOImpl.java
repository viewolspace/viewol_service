package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.IFUserDAO;
import com.viewol.pojo.FUser;
import com.viewol.pojo.query.FUserQuery;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2018/7/5.
 */
@Repository("fUserDAO")
public class FUserDAOImpl extends BaseDAO<FUser> implements IFUserDAO {
    @Override
    public int addFUser(FUser user) {
        user.setcTime(new Date());
        int result = super.insert(user);
        if(result>0){
            return user.getUserId();
        }else{
            return 0;
        }
    }

    @Override
    public int updateFUser(FUser user) {
        user.setmTime(new Date());
        return super.update(user);
    }

    @Override
    public FUser getFuser(int userId) {
        return super.get(userId);
    }

    @Override
    public FUser getUserByUuid(String uuid) {
        Map<String,Object> map =new HashMap<>();
        map.put("uuid",uuid);

        return super.findUniqueBy("getUserByUuid",map);
    }

    @Override
    public PageHolder<FUser> querFUser(FUserQuery query) {
        Map<String,Object> map =new HashMap<>();
        map.put("userName",query.getUserName());
//        map.put("phone",query.getPhone());
        map.put("company",query.getCompany());
        map.put("email",query.getEmail());

        return super.pagedQuery("findByParams",map,query.getPageIndex(),query.getPageSize());
    }
}
