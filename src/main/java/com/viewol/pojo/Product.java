package com.viewol.pojo;

import java.util.Date;

/**
 * Created by lenovo on 2018/6/29.
 */
public class Product {

    public static final int STATUS_ON = 0 ; //上架
    public static final int STATUS_OFF = 1 ; //下架

    private Integer id;
    private Integer company_id;
    private String category_id;
    private Integer status; //0 上架  1 下架
    private String name;
    private String image;
    private String content;
    private String pdf_url;
    private String pdf_name;
    private Integer is_recommend;
    private Integer recommend_num;
    private Date c_time;
    private Date m_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
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

    public String getPdf_url() {
        return pdf_url;
    }

    public void setPdf_url(String pdf_url) {
        this.pdf_url = pdf_url;
    }

    public String getPdf_name() {
        return pdf_name;
    }

    public void setPdf_name(String pdf_name) {
        this.pdf_name = pdf_name;
    }

    public Integer getIs_recommend() {
        return is_recommend;
    }

    public void setIs_recommend(Integer is_recommend) {
        this.is_recommend = is_recommend;
    }

    public Integer getRecommend_num() {
        return recommend_num;
    }

    public void setRecommend_num(Integer recommend_num) {
        this.recommend_num = recommend_num;
    }

    public Date getC_time() {
        return c_time;
    }

    public void setC_time(Date c_time) {
        this.c_time = c_time;
    }

    public Date getM_time() {
        return m_time;
    }

    public void setM_time(Date m_time) {
        this.m_time = m_time;
    }
}
