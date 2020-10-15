package com.viewol.pojo;

import java.util.Date;

public class Info implements Comparable<Info> {

    private int id;
    private String title;
    private String summary;
    private Date pubTime;
    private String picUrl;
    private String contentUrl;
    private Date createTime;
    private String md5Str;

    private int status;

    private Date mTime;

    private String content;

    private int classify;

    private int companyId;
    private int site;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMd5Str() {
        return md5Str;
    }

    public void setMd5Str(String md5Str) {
        this.md5Str = md5Str;
    }

    @Override
    public int compareTo(Info o) {
        //自定义比较方法，如果认为此实体本身大则返回1，否则返回-1
        if (this.pubTime.getTime() >= o.getPubTime().getTime()) {
            return 1;
        }
        return -1;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getmTime() {
        return mTime;
    }

    public void setmTime(Date mTime) {
        this.mTime = mTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getClassify() {
        return classify;
    }

    public void setClassify(int classify) {
        this.classify = classify;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getSite() {
        return site;
    }

    public void setSite(int site) {
        this.site = site;
    }
}
