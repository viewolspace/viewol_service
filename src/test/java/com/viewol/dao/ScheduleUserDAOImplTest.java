package com.viewol.dao;

import com.viewol.base.BaseTestClass;
import com.viewol.pojo.Schedule;
import com.viewol.pojo.ScheduleUser;
import org.junit.Test;

import java.util.Date;

/**
 * Created by lenovo on 2018/6/28.
 */
public class ScheduleUserDAOImplTest extends BaseTestClass{

    private IScheduleUserDAO dao = (IScheduleUserDAO)getInstance("scheduleUserDAO");

    private Schedule getSchedule(){
        Schedule schedule = new Schedule();
        schedule.setId(1);
        schedule.setCompanyName("协会1");
        schedule.setCompanyId(-1);
        schedule.setContent("测试一下1");
        schedule.setsTime(new Date());
        schedule.seteTime(new Date());
        schedule.setTitle("第一个会议1");
        schedule.setPlace("大酒店1");
        schedule.setStatus(Schedule.STATUS_OK);
        schedule.setType(Schedule.TYPE_HOST);

        return schedule;
    }

    @Test
    public void queryScheduleUser(){
        System.out.println(dao.queryScheduleUser(1, 1, 20).get(0));
    }

    @Test
    public void applyJoin(){
        ScheduleUser scheduleUser = new ScheduleUser();
        scheduleUser.setScheduleId(1);
        scheduleUser.setUserId(1);
        System.out.println(dao.applyJoin(scheduleUser));
    }


    @Test
    public void isJoinSchedule(){
        System.out.println(dao.isJoinSchedule(1,1));
    }

}
