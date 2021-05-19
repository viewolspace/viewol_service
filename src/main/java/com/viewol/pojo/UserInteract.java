package com.viewol.pojo;

import java.util.Date;

/**
 * Created by lenovo on 2019/7/4.
 * 用户互动
 */
public class UserInteract {

    public final static int CLASSIFY_COMPANY = 1;

    public final static int CLASSIFY_PRODUCT = 2;

    public final static int TYPE_SEE = 1;

    public final static int TYPE_PRAISE = 2;

    public final static int TYPE_COMMENT = 3;



    private int id;
    private int classify;
    private int type;
    private int thirdId;
    private int userId;
    private String userName;
    private String headImgUrl;
    private String comment;
    private Date cTime;

    private String reply;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassify() {
        return classify;
    }

    public void setClassify(int classify) {
        this.classify = classify;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
}
