package com.viewol.pojo;

import java.util.Date;

/**
 * Created by lenovo on 2018/7/5.
 */
public class FUserBind {

    public static final int TYPE_PROGRAM = 1; //小程序观展通

    public static final int TYPE_WEIXIN = 2 ; //公众号

    public static final int TYPE_PROGRAM_NO2 = 3; //小程序观展讯

    private int id;
    private int userId;
    private int type;
    private String openId;
    private String uuid;
    private Date cTime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    @Override
    public String toString() {
        return "FUserBind{" +
                "id=" + id +
                ", userId=" + userId +
                ", type=" + type +
                ", openId='" + openId + '\'' +
                ", uuid='" + uuid + '\'' +
                ", cTime=" + cTime +
                '}';
    }
}
