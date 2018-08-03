package com.viewol.dao;

import com.viewol.pojo.UserSession;

public interface IUserSessionDAO {

    int saveSession(int userId, String session, int type);

    int updateSession(int userId, String session, int type);

    UserSession getSession(int userId);
}
