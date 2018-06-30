package com.viewol.pojo;

import java.util.Date;

/**
 * Created by lenovo on 2018/6/29.
 */
public class Product {

    public static final int STATUS_ON = 0 ; //上架
    public static final int STATUS_OFF = 1 ; //下架

    private Integer id;
    private Integer companyId;
    private String categoryId;
    private Integer status; //0 上架  1 下架
    private String name;
    private String image;
    private String content;
    private String pdfUrl;
    private String pdfName;
    private Integer isRecommend;
    private Integer recommendNum;
    private Date cTime;
    private Date mTime;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public String getPdfName() {
        return pdfName;
    }

    public void setPdfName(String pdfName) {
        this.pdfName = pdfName;
    }

    public Integer getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }

    public Integer getRecommendNum() {
        return recommendNum;
    }

    public void setRecommendNum(Integer recommendNum) {
        this.recommendNum = recommendNum;
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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", categoryId='" + categoryId + '\'' +
                ", status=" + status +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", content='" + content + '\'' +
                ", pdfUrl='" + pdfUrl + '\'' +
                ", pdfName='" + pdfName + '\'' +
                ", isRecommend=" + isRecommend +
                ", recommendNum=" + recommendNum +
                ", cTime=" + cTime +
                ", mTime=" + mTime +
                '}';
    }
}
