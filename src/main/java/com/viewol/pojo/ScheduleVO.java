package com.viewol.pojo;

import java.util.Date;

/**
 * Created by lenovo on 2018/7/10.
 */
public class ScheduleVO extends Schedule {

    private Integer  RecommendScheduleId ;

    private Date recommendSTime;

    private Date recommendETime;

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

    @Override
    public String toString() {
        return "ScheduleVO{" +
                "RecommendScheduleId=" + RecommendScheduleId +
                ", recommendSTime=" + recommendSTime +
                ", recommendETime=" + recommendETime +
                '}' +  super.toString();
    }
}
