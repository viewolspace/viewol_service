package com.viewol.dao;

import com.viewol.base.BaseTestClass;
import com.viewol.pojo.Schedule;
import com.viewol.pojo.ScheduleVO;
import com.viewol.pojo.query.RecommendScheduleQuery;
import com.viewol.pojo.query.ScheduleQuery;
import com.youguu.core.util.PageHolder;
import org.junit.Test;

import java.util.Date;

/**
 * Created by lenovo on 2018/6/28.
 */
public class ScheduleDAOImplTest extends BaseTestClass{

    private IScheduleDAO dao = (IScheduleDAO)getInstance("scheduleDAO");

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
    public void addSchedule(){
        dao.addSchedule(2,getSchedule());
    }

    @Test
    public void updateSchedule(){
        dao.updateSchedule(getSchedule());
    }

    @Test
    public void updateStatus(){
        dao.updateStatus(1,-1);

    }

    @Test
    public void querySchedule(){
        ScheduleQuery query = new ScheduleQuery();
        query.setKeyword("一个");
//        query.setPageIndex(2);
//        query.setPageSize(1);
        System.out.println(dao.querySchedule(2,query));
    }


    @Test
    public void queryRecommendSchedule(){
        RecommendScheduleQuery query = new RecommendScheduleQuery();
        query.setType(1);
        PageHolder<ScheduleVO> pageHolder = dao.queryRecommendSchedule(2,query);
        for(ScheduleVO vo:pageHolder.getList()){
            System.out.println(vo);
        }
//        System.out.println(dao.queryRecommendSchedule(query));
    }


    @Test
    public void listSchedule(){
        ScheduleQuery query = new ScheduleQuery();
        query.setType(1);
        System.out.println(dao.listSchedule(2,query));
    }


    @Test
    public void queryNowHostSchedule(){
        System.out.println(dao.queryNowHostSchedule(2));
    }


    @Test
    public void queryNowRecommendSchedule(){
        System.out.println(dao.queryNowRecommendSchedule(2,1));
    }
}
