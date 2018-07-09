package com.viewol.pojo;

import java.util.Date;

/**
 * Created by lenovo on 2018/6/27.
 */
public class Schedule {

    public static final int TYPE_HOST = 0; //主办方
    public static final int TYPE_COM = 1; //展商

    public static final int STATUS_OK = 1; //审核通过
    public static final int STATUS_BACK = -1; //打回
    public static final int STATUS_TRIAL = 0; //审核

    public static final String HOSTNAME = "主办方";

    private Integer  id ;
    private Integer companyId;
    private Integer type;//0 主办方 1 展商
    private String companyName;
    private String title;
    private Date cTime;
    private Integer status; //0 待审 -1 打回 1 审核通过
    private Date sTime;
    private Date eTime;
    private String content;
    private String place; //位置信息
    private Integer vType; //不是数据库字段 等同于RecommendSchedule的type字段

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getsTime() {
        return sTime;
    }

    public void setsTime(Date sTime) {
        this.sTime = sTime;
    }

    public Date geteTime() {
        return eTime;
    }

    public void seteTime(Date eTime) {
        this.eTime = eTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
