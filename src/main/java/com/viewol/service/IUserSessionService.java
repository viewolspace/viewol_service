package com.viewol.service;

import com.viewol.pojo.UserSession;

public interface IUserSessionService {
    int saveSession(int userId, int type);

    int updateSession(int userId, int type);

    UserSession getSession(int userId);
}
