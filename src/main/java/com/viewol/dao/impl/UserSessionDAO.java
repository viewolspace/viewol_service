package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.IUserSessionDAO;
import com.viewol.pojo.UserSession;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository("userSessionDAO")
public class UserSessionDAO extends BaseDAO<UserSession> implements IUserSessionDAO {
    @Override
    public int saveSession(int userId, String session, int type) {
        UserSession userSession = new UserSession();
        userSession.setUserId(userId);
        userSession.setSessionId(session);
        userSession.setType(type);
        userSession.setRefreshTime(new Date());
        userSession.setCreateTime(new Date());
        return this.insert(userSession);
    }

    @Override
    public int updateSession(int userId, String session, int type) {
        UserSession userSession = new UserSession();
        userSession.setUserId(userId);
        userSession.setSessionId(session);
        userSession.setType(type);
        userSession.setRefreshTime(new Date());
        return this.update(userSession);
    }

    @Override
    public UserSession getSession(int userId) {
        return this.get(userId);
    }
}

