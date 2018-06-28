package com.viewol.pojo;

import java.util.Date;

/**
 * Created by lenovo on 2018/6/27.
 */
public class RecommendSchedule {


    public static final int TYPE_TOP = 1; //置顶
    public static final int TYPE_RE = 2; //推荐

    private Integer  id;
    private Integer  scheduleId;
    private Integer  type;//1 置顶活动  2 推荐活动
    private Date sTime; //推荐开始时间
    private Date eTime; //推荐结束时间
    private Date cTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getsTime() {
        return sTime;
    }

    public void setsTime(Date sTime) {
        this.sTime = sTime;
    }

    public Date geteTime() {
        return eTime;
    }

    public void seteTime(Date eTime) {
        this.eTime = eTime;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }
}
