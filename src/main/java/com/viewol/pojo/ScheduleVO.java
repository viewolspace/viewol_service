package com.viewol.pojo;

import java.util.Date;

/**
 * Created by lenovo on 2018/7/10.
 */
public class ScheduleVO extends Schedule {


    public static final int APPLY_STATUS_NO = 0 ; //不能报名

    public static final int APPLY_STATUS_CAN = 1 ; //可以报名

    public static final int APPLY_STATUS_YES = 2 ; //已经报名

    private Integer  RecommendScheduleId ;

    private Date recommendSTime;

    private Date recommendETime;

    private int applyStatus; //0 不允许报名  1 可以报名  2 已经报名

    public Integer getRecommendScheduleId() {
        return RecommendScheduleId;
    }

    public void setRecommendScheduleId(Integer recommendScheduleId) {
        RecommendScheduleId = recommendScheduleId;
    }

    public Date getRecommendSTime() {
        return recommendSTime;
    }

    public void setRecommendSTime(Date recommendSTime) {
        this.recommendSTime = recommendSTime;
    }

    public Date getRecommendETime() {
        return recommendETime;
    }

    public void setRecommendETime(Date recommendETime) {
        this.recommendETime = recommendETime;
    }


    public int getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(int applyStatus) {
        this.applyStatus = applyStatus;
    }

    @Override
    public String toString() {
        return "ScheduleVO{" +
                "RecommendScheduleId=" + RecommendScheduleId +
                ", recommendSTime=" + recommendSTime +
                ", recommendETime=" + recommendETime +
                '}' +  super.toString();
    }
}
