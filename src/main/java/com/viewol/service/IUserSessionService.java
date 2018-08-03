package com.viewol.service;

import com.viewol.pojo.UserSession;

public interface IUserSessionService {
    String saveSession(int userId, int type);

    String updateSession(int userId, int type);

    UserSession getSession(int userId);
}
