package com.viewol.pojo;

import java.util.Date;

/**
 * Created by lenovo on 2018/7/3.
 */
public class FUser {
    private int    userId;
    private String userName;
    private String phone;
    private String company;
    private String position;
    private String email;
    private int    age;
    private Date   cTime;
    private Date   mTime;
    private String uuid;
    private int companyId;
    private String headImgUrl;

    private int userJoin;

    private int invitee;

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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public int getUserJoin() {
        return userJoin;
    }

    public void setUserJoin(int userJoin) {
        this.userJoin = userJoin;
    }

    public int getInvitee() {
        return invitee;
    }

    public void setInvitee(int invitee) {
        this.invitee = invitee;
    }

    @Override
    public String toString() {
        return "FUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                ", company='" + company + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", cTime=" + cTime +
                ", mTime=" + mTime +
                ", uuid='" + uuid + '\'' +
                ", companyId=" + companyId +
                '}';
    }
}
