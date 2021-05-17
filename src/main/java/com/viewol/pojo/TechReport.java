package com.viewol.pojo;

import java.util.Date;

public class TechReport {
    private int id;//自增主键
    private String phone;//手机号
    private String email;//邮箱
    private String openId;//微信
    private String title;//技术报告题目
    private String name;//报告人姓名
    private String postion;//报告人职务
    private String summary;//技术报告大纲（约200字）
    private String forumTitle;//论坛名称
    private String forumRoom;//论坛位置
    private String forumTime;//论坛时间
    private int forumNum;//论坛参加人数
    private Date updateTime;//修改时间
    private Date createTime;//创建时间
    private int companyId;
    private String companyName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostion() {
        return postion;
    }

    public void setPostion(String postion) {
        this.postion = postion;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getForumTitle() {
        return forumTitle;
    }

    public void setForumTitle(String forumTitle) {
        this.forumTitle = forumTitle;
    }

    public String getForumRoom() {
        return forumRoom;
    }

    public void setForumRoom(String forumRoom) {
        this.forumRoom = forumRoom;
    }

    public String getForumTime() {
        return forumTime;
    }

    public void setForumTime(String forumTime) {
        this.forumTime = forumTime;
    }

    public int getForumNum() {
        return forumNum;
    }

    public void setForumNum(int forumNum) {
        this.forumNum = forumNum;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
