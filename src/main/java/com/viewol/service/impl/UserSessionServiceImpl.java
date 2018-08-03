package com.viewol.service.impl;

import com.viewol.dao.IUserSessionDAO;
import com.viewol.pojo.UserSession;
import com.viewol.service.IUserSessionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userSessionService")
public class UserSessionServiceImpl implements IUserSessionService {

    @Resource
    private IUserSessionDAO userSessionDAO;

    @Override
    public int saveSession(int userId, int type) {
        String session = "123";

        return userSessionDAO.saveSession(userId, session, type);
    }

    @Override
    public int updateSession(int userId, int type) {
        String session = "456";

        return userSessionDAO.updateSession(userId, session, type);
    }

    @Override
    public UserSession getSession(int userId) {
        return userSessionDAO.getSession(userId);
    }
}
