package com.viewol.pojo;

import java.util.Date;

//非展商 申请用户
public class ApplyUser {



    private  int id;
    private String companyName;
    private String companyPic;
    private String phone;
    private String name;
    private int status;
    private Date cTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyPic() {
        return companyPic;
    }

    public void setCompanyPic(String companyPic) {
        this.companyPic = companyPic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    @Override
    public String toString() {
        return "ApplyUser{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", companyPic='" + companyPic + '\'' +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", cTime=" + cTime +
                '}';
    }
}
