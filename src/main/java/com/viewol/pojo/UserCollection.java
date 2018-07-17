package com.viewol.pojo;

import com.viewol.util.ImageUtils;

import java.util.Date;

/**
 * Created by lenovo on 2018/7/16.
 */
public class UserCollection {

    public static final int TYPE_COM = 1;

    public static final int TYPE_PRODUCT = 2;

    private int id;
    private int userId;
    private int type; //1 展商  2 产品
    private int thirdId;
    private String name;
    private String image;
    private Date cTime;

    private String imageView;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
        this.imageView = ImageUtils.addUrlImage(image);
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public String getImageView() {
        return imageView;
    }

    public void setImageView(String imageView) {
        this.imageView = imageView;
    }

    @Override
    public String toString() {
        return "UserCollection{" +
                "id=" + id +
                ", userId=" + userId +
                ", type=" + type +
                ", thirdId=" + thirdId +
                ", name=" + name +
                ", image=" + image +
                ", cTime=" + cTime +
                '}';
    }
}
