package com.viewol.pojo;

import java.util.Date;

/**
 * Created by lenovo on 2018/7/18.
 * 问卷调查的结果
 */
public class UserAnswer {

    private int userId;

    private String answer;

    private Date  cTime;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }
}
