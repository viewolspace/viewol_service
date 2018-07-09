package com.viewol.service.impl;

import com.viewol.dao.IFUserBindDAO;
import com.viewol.dao.IFUserDAO;
import com.viewol.pojo.FUser;
import com.viewol.pojo.FUserBind;
import com.viewol.pojo.query.FUserQuery;
import com.viewol.service.IFUserService;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by lenovo on 2018/7/9.
 */
@Service("fUserService")
public class FUserServiceImpl implements IFUserService {

    @Resource
    private IFUserDAO ifUserDAO;

    @Resource
    private IFUserBindDAO ifUserBindDAO;


    @Override
    public FUser getFuser(int uid) {
        return ifUserDAO.getFuser(uid);
    }

    @Transactional("viewolTX")
    @Override
    public int addFUser(FUser fuser, String openId, String uuid , int type) {
        fuser.setcTime(new Date());
        fuser.setUuid(uuid);

        int uid = ifUserDAO.addFUser(fuser);

        FUserBind fUserBind = new FUserBind();
        fUserBind.setUserId(uid);
        fUserBind.setOpenId(openId);
        fUserBind.setUuid(uuid);
        fUserBind.setcTime(new Date());
        fUserBind.setType(type);
        int result = ifUserBindDAO.addFUserBind(fUserBind);
        return result;
    }

    @Override
    public int updateUser(FUser fuser) {
        return ifUserDAO.updateFUser(fuser);
    }

    @Override
    public String getOpenId(int uid,int type) {
        FUserBind userBind = ifUserBindDAO.getOpenId(uid, type);
        if(userBind==null){
            return null;
        }else{
            return userBind.getOpenId();
        }
    }

    @Override
    public PageHolder<FUser> querFUser(FUserQuery query) {
        return ifUserDAO.querFUser(query);
    }
}