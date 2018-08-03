package com.viewol.service.impl;

import com.viewol.dao.IUserSessionDAO;
import com.viewol.pojo.UserSession;
import com.viewol.service.IUserSessionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service("userSessionService")
public class UserSessionServiceImpl implements IUserSessionService {

    @Resource
    private IUserSessionDAO userSessionDAO;

    @Override
    public String saveSession(int userId, int type) {
        String session = getSessionID(userId);

        int result = userSessionDAO.saveSession(userId, session, type);
        if(result>0){
            return session;
        }
        return null;
    }

    @Override
    public String updateSession(int userId, int type) {
        String session = getSessionID(userId);

        int result = userSessionDAO.updateSession(userId, session, type);
        if(result>0){
            return session;
        }
        return null;
    }

    @Override
    public UserSession getSession(int userId) {
        return userSessionDAO.getSession(userId);
    }

    /**
     * 生成登录的会话ID
     * @param userId
     * @return
     */
    private String getSessionID(int userId) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String timeStamp =  df.format(new Date());
        return timeStamp + userId;
    }
}
