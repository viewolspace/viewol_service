package com.viewol.pojo;

import java.util.Date;

/**
 * 用户会话session
 */
public class UserSession {
    public static final int TYPE_H5 = 1;//H5登录
    public static final int TYPE_MA = 2;//小程序登录
    public static final int TYPE_MP = 3;//公众号登录

    private int userId;
    private String sessionId;
    private int type;
    private Date refreshTime;
    private Date createTime;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getRefreshTime() {
        return refreshTime;
    }

    public void setRefreshTime(Date refreshTime) {
        this.refreshTime = refreshTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserSession{" +
                "userId=" + userId +
                ", sessionId='" + sessionId + '\'' +
                ", type=" + type +
                ", refreshTime=" + refreshTime +
                ", createTime=" + createTime +
                '}';
    }
}
