package com.viewol.service.impl;

import com.viewol.dao.IBUserDAO;
import com.viewol.pojo.BUser;
import com.viewol.service.IBUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2018/7/9.
 */
@Service("bUserService")
public class BUserServiceImpl implements IBUserService {

    @Resource
    private IBUserDAO ibUserDAO;

    @Override
    public List<BUser> listByCom(int comId) {
        return ibUserDAO.listByCom(comId);
    }

    @Override
    public BUser getBUser(int uid) {
        return ibUserDAO.getBUser(uid);
    }

    @Override
    public BUser getBUser(String openId) {
        return ibUserDAO.getBUser(openId);
    }

    @Override
    public int addBUser(BUser user) {
        return ibUserDAO.addBUser(user);
    }

    @Override
    public int upDateBUser(BUser user) {
        return ibUserDAO.upDateBUser(user);
    }

    @Override
    public int setStatus(int userId, int status) {
        return ibUserDAO.setStatus(userId, status);
    }
}
