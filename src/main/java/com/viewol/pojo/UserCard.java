package com.viewol.pojo;

import java.util.Date;

/**
 * Created by lenovo on 2018/7/9.
 */
public class UserCard {
    private int id;
    private int bUserId;
    private int companyId;
    private int fUserId;
    private Date cTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getbUserId() {
        return bUserId;
    }

    public void setbUserId(int bUserId) {
        this.bUserId = bUserId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getfUserId() {
        return fUserId;
    }

    public void setfUserId(int fUserId) {
        this.fUserId = fUserId;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    @Override
    public String toString() {
        return "UserCard{" +
                "id=" + id +
                ", bUserId=" + bUserId +
                ", companyId=" + companyId +
                ", fUserId=" + fUserId +
                ", cTime=" + cTime +
                '}';
    }
}
