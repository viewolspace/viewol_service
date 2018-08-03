package com.viewol.service;

import com.viewol.base.BaseTestClass;
import com.viewol.pojo.UserSession;
import com.viewol.service.IProductService;
import com.viewol.service.IUserSessionService;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserSessionServiceImplTest extends BaseTestClass {

    private IUserSessionService userSessionService = (IUserSessionService) getInstance("userSessionService");

    @Test
    public void saveSession() {
        userSessionService.saveSession(111, UserSession.TYPE_MA);
    }

    @Test
    public void updateSession() {
        userSessionService.updateSession(111, UserSession.TYPE_MA);
    }

    @Test
    public void getSession() {
        UserSession session = userSessionService.getSession(111);
        System.out.println(session);
    }
}