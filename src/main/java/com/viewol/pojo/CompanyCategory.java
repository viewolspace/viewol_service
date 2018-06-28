package com.viewol.pojo;

import java.util.Date;

/**
 * Created by lenovo on 2018/6/28.
 */
public class CompanyCategory {

    private Integer id;
    private Integer companyId;
    private String categoryId;
    private Date    cTime;

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

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    @Override
    public String toString() {
        return "CompanyCategory{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", categoryId=" + categoryId +
                ", cTime=" + cTime +
                '}';
    }
}
