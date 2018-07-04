package com.viewol.pojo;

import java.util.Date;

/**
 * Created by lenovo on 2018/7/3.
 */
public class ScheduleUser extends FUser{


    public static final int REMINDER_YES = 0; //需要提醒

    public static final int REMINDER_NO = 1; //不需要提醒

    private int id;

    private int scheduleId;

    private Date reminderTime;

    private Date cTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Date getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(Date reminderTime) {
        this.reminderTime = reminderTime;
    }

    @Override
    public Date getcTime() {
        return cTime;
    }

    @Override
    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    @Override
    public String toString() {
        return "ScheduleUser{" +
                "id=" + id +
                ", scheduleId=" + scheduleId +
                ", reminderTime=" + reminderTime +
                ", cTime=" + cTime +
                '}' + super.toString();
    }
}
