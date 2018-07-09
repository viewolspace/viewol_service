package com.viewol.pojo;

import java.util.Date;

/**
 * Created by lenovo on 2018/7/9.
 */
public class UserCardVO {
    private int id;
    private int bUserId;
    private int companyId;
    private int fUserId;
    private Date cTime;

    //客户基本信息
    private String fUserName;
    private String fPhone;
    private String FCompany;
    private String fPosition;
    private String fEmail;
    private int    FAge;
    private int FCompanyId;

    //展商业务员基本信息
    private String BUserName;
    private String BPhone;
    private String BPosition;

    //展商基本信息
    private String  logo;
    private String  name;
    private String  shortName; //简称

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

    public String getfUserName() {
        return fUserName;
    }

    public void setfUserName(String fUserName) {
        this.fUserName = fUserName;
    }

    public String getfPhone() {
        return fPhone;
    }

    public void setfPhone(String fPhone) {
        this.fPhone = fPhone;
    }

    public String getFCompany() {
        return FCompany;
    }

    public void setFCompany(String FCompany) {
        this.FCompany = FCompany;
    }

    public String getfPosition() {
        return fPosition;
    }

    public void setfPosition(String fPosition) {
        this.fPosition = fPosition;
    }

    public String getfEmail() {
        return fEmail;
    }

    public void setfEmail(String fEmail) {
        this.fEmail = fEmail;
    }

    public int getFAge() {
        return FAge;
    }

    public void setFAge(int FAge) {
        this.FAge = FAge;
    }

    public int getFCompanyId() {
        return FCompanyId;
    }

    public void setFCompanyId(int FCompanyId) {
        this.FCompanyId = FCompanyId;
    }

    public String getBUserName() {
        return BUserName;
    }

    public void setBUserName(String BUserName) {
        this.BUserName = BUserName;
    }

    public String getBPhone() {
        return BPhone;
    }

    public void setBPhone(String BPhone) {
        this.BPhone = BPhone;
    }

    public String getBPosition() {
        return BPosition;
    }

    public void setBPosition(String BPosition) {
        this.BPosition = BPosition;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public String toString() {
        return "UserCardVO{" +
                "id=" + id +
                ", bUserId=" + bUserId +
                ", companyId=" + companyId +
                ", fUserId=" + fUserId +
                ", cTime=" + cTime +
                ", fUserName='" + fUserName + '\'' +
                ", fPhone='" + fPhone + '\'' +
                ", FCompany='" + FCompany + '\'' +
                ", fPosition='" + fPosition + '\'' +
                ", fEmail='" + fEmail + '\'' +
                ", FAge=" + FAge +
                ", FCompanyId=" + FCompanyId +
                ", BUserName='" + BUserName + '\'' +
                ", BPhone='" + BPhone + '\'' +
                ", BPosition='" + BPosition + '\'' +
                ", logo='" + logo + '\'' +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                '}';
    }
}
