package com.viewol.pojo;

import java.util.Date;

/**
 * Created by lenovo on 2018/7/9.
 */
public class BUser {

    public final static int STATUS_TRIAL = 0 ; //审核中
    public final static int STATUS_OK = 1 ; //通过
    public final static int STATUS_BACK = -1 ; //打回

    private  int userId;
    private String userName;
    private String phone;
    private int companyId;
    private int status;
    private String position;
    private Date cTime;
    private Date mTime;
    private String openId;
    private String uuid;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    @Override
    public String toString() {
        return "BUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                ", companyId=" + companyId +
                ", status=" + status +
                ", position='" + position + '\'' +
                ", cTime=" + cTime +
                ", mTime=" + mTime +
                ", openId='" + openId + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
