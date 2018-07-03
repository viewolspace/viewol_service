package com.viewol.pojo;

import java.util.Date;

/**
 * Created by lenovo on 2018/7/2.
 */
public class Recommend {

    public static final int TYPE_COM = 1 ; //展商

    public static final int TYPE_PRODUCT = 2 ; //产品

    private int id;
    private int type;//1 展商  2 产品
    private int thirdId;
    private String name;
    private String image;
    private String categoryId;
    private Date cTime;
    private Date mTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getThirdId() {
        return thirdId;
    }

    public void setThirdId(int thirdId) {
        this.thirdId = thirdId;
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

    public Date getmTime() {
        return mTime;
    }

    public void setmTime(Date mTime) {
        this.mTime = mTime;
    }

    @Override
    public String toString() {
        return "Recommend{" +
                "id=" + id +
                ", type=" + type +
                ", thirdId=" + thirdId +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", cTime=" + cTime +
                ", mTime=" + mTime +
                '}';
    }
}
