package com.viewol.pojo;

/**
 * Created by lenovo on 2018/7/10.
 */
public class ScheduleVO extends Schedule {

    private Integer  RecommendScheduleId ;

    public Integer getRecommendScheduleId() {
        return RecommendScheduleId;
    }

    public void setRecommendScheduleId(Integer recommendScheduleId) {
        RecommendScheduleId = recommendScheduleId;
    }

    @Override
    public String toString() {
        return "ScheduleVO{" +
                "RecommendScheduleId=" + RecommendScheduleId +
                '}' + super.toString();
    }
}
