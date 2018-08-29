package com.viewol.service;

import com.viewol.base.BaseTestClass;
import com.viewol.pojo.RecommendSchedule;
import com.viewol.pojo.Schedule;
import com.viewol.pojo.query.RecommendScheduleQuery;
import com.viewol.pojo.query.ScheduleQuery;
import org.junit.Test;

/**
 * Created by lenovo on 2018/6/28.
 */
public class ScheduleServiceImplTest extends BaseTestClass{

    private IScheduleService service = (IScheduleService)getInstance("scheduleService");



    @Test
    public void hasApplySchedule(){
        System.out.println(service.hasApplySchedule(1));

    }


    @Test
    public void applySchedule(){
        int companyId =1;
        String title = "第一个活动";
        String place = "酒店";
        String content = "嘉宾不少";
        String startTime = "2018-09-12 11:23:11" ;
        String endTime = "2018-09-12 12:23:11";
        System.out.println(service.applySchedule(companyId,title,place,content,startTime,endTime));
    }

    @Test
    public void addSchedule(){
        String title = "第san个活动";
        String place = "会场";
        String content = "嘉宾不少呀";
        String startTime = "2018-09-12 11:23:11" ;
        String endTime = "2018-09-12 12:23:11";
        System.out.println(service.addSchedule(title,place,content,startTime,endTime));

    }


    @Test
    public void getSchedule(){
        System.out.println(service.getSchedule(1));
    }


    @Test
    public void updateSchedule(){
        Schedule schedule = service.getSchedule(2);
        schedule.setStatus(Schedule.STATUS_OK);
        schedule.setTitle("改了一下");
        System.out.println(service.updateSchedule(schedule));
    }


    @Test
    public void updateStatus(){
        service.updateStatus(1,Schedule.STATUS_OK);
    }


    @Test
    public void addRecommendSchedule(){
        int type = RecommendSchedule.TYPE_TOP ;
        int scheduleId = 2 ;
        String startTime = "2018-09-12 11:23:11" ;
        String endTime = "2018-09-12 12:23:11";
        service.addRecommendSchedule(type,scheduleId,startTime,endTime);
    }

    @Test
    public void delRecommendSchedule(){
        service.delRecommendSchedule(1);
    }

    @Test
    public void querySchedule(){
        ScheduleQuery query = new ScheduleQuery();
        query.setStatus(1);
        query.setKeyword("卡");
        query.setCompanyId(1);
        query.setType(1);
        query.setTime("2018-09-01");
        System.out.println(service.querySchedule(query));
    }

    @Test
    public void queryRecommendSchedule(){
        RecommendScheduleQuery query = new RecommendScheduleQuery();
        query.setType(1);
        query.setTime("2018-09-12 11:45:11");
        System.out.println(service.queryRecommendSchedule(query));
    }

    @Test
    public void applyJoin(){
        System.out.println(service.applyJoin(2,2,true));
    }


    @Test
    public void updateReminderFlag(){
//        System.out.println(service.updateReminderFlag(1));
    }

    @Test
    public void queryNeedReminder(){
        System.out.println(service.queryNeedReminder());
    }

}
