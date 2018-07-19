package com.viewol.pojo;

import java.util.Date;

/**
 * Created by lenovo on 2018/7/19.
 */
public class WxToken {


    public final static int TYPE_WX = 1;

    public final static int TYPE_PROGRAM = 2;

    public final static int TYPE_JSPAPI = 3;

    private int type;
    private String token;
    private Date cTime;
    private Date mTime;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public Date getmTime() {
        return mTime;
    }

    public void setmTime(Date mTime) {
        this.mTime = mTime;
    }

    @Override
    public String toString() {
        return "WxToken{" +
                "type=" + type +
                ", token='" + token + '\'' +
                ", cTime=" + cTime +
                ", mTime=" + mTime +
                '}';
    }
}
