package com.viewol.pojo;

import java.util.Date;

/**
 * Created by lenovo on 2018/6/27.
 * 展商的图文介绍
 */
public class CompanyDetail {

    private Integer id; //展商的id
    private String  content;
    private Date cTime;
    private  Date  mTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
}
