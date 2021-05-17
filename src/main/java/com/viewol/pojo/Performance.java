package com.viewol.pojo;

import java.util.Date;

public class Performance {
    private int id; //自增主键
    private String phone; //手机号
    private String email; //邮箱
    private String openId; //微信
    private String performanceCategory; //展演类别
    private String performanceProduct; //展演产品
    private String feature; //产品优势及特性
    private Double area; //所需面积（平米）
    private String needHelp; //需辅助服务及功能需求
    private String performanceTime; //展演时段
    private String adPositon; //广告位置
    private String adMethod; //广告方式
    private Date updateTime; //修改时间
    private Date createTime; //创建时间
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

    public String getPerformanceCategory() {
        return performanceCategory;
    }

    public void setPerformanceCategory(String performanceCategory) {
        this.performanceCategory = performanceCategory;
    }

    public String getPerformanceProduct() {
        return performanceProduct;
    }

    public void setPerformanceProduct(String performanceProduct) {
        this.performanceProduct = performanceProduct;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getNeedHelp() {
        return needHelp;
    }

    public void setNeedHelp(String needHelp) {
        this.needHelp = needHelp;
    }

    public String getPerformanceTime() {
        return performanceTime;
    }

    public void setPerformanceTime(String performanceTime) {
        this.performanceTime = performanceTime;
    }

    public String getAdPositon() {
        return adPositon;
    }

    public void setAdPositon(String adPositon) {
        this.adPositon = adPositon;
    }

    public String getAdMethod() {
        return adMethod;
    }

    public void setAdMethod(String adMethod) {
        this.adMethod = adMethod;
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
