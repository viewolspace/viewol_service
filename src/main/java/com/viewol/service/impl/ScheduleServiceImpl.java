package com.viewol.service.impl;

import com.viewol.dao.ICompanyDAO;
import com.viewol.dao.IRecommendScheduleDAO;
import com.viewol.dao.IScheduleDAO;
import com.viewol.pojo.Company;
import com.viewol.pojo.RecommendSchedule;
import com.viewol.pojo.Schedule;
import com.viewol.pojo.query.RecommendScheduleQuery;
import com.viewol.pojo.query.ScheduleQuery;
import com.viewol.service.IScheduleService;
import com.viewol.util.DateUtil;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2018/7/3.
 */
@Service("scheduleService")
public class ScheduleServiceImpl implements IScheduleService {

    @Resource
    private IScheduleDAO scheduleDAO;

    @Resource
    private IRecommendScheduleDAO recommendScheduleDAO;

    @Resource
    private ICompanyDAO companyDAO;


    @Override
    public boolean hasApplySchedule(int companyId) {
        ScheduleQuery query = new ScheduleQuery();
        query.setCompanyId(1);
        query.setStatus(Schedule.STATUS_TRIAL);
        List<Schedule> list =  scheduleDAO.listSchedule(query);
        if(list!=null &&list.size()>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int applySchedule(int companyId, String title, String place, String content, String startTime, String endTime) {
        //判断公司是否已经有未审核的活动

        if(hasApplySchedule(companyId)){
            return -99;
        }

        Company company = companyDAO.getCompany(companyId);
        if(company==null){
            return -1;
        }
        Schedule schedule = new Schedule();
        schedule.setType(Schedule.TYPE_COM);
        schedule.setStatus(Schedule.STATUS_TRIAL);
        schedule.setCompanyId(companyId);
        schedule.setCompanyName(company.getName());
        schedule.setPlace(place);
        schedule.setTitle(title);
        schedule.setContent(content);
        schedule.setsTime(DateUtil.parseDate(startTime, DateUtil.FORMAT_FULL));
        schedule.seteTime(DateUtil.parseDate(endTime, DateUtil.FORMAT_FULL));

        return scheduleDAO.addSchedule(schedule);
    }

    @Override
    public int addSchedule(String title, String place, String content, String startTime, String endTime) {
        Schedule schedule = new Schedule();
        schedule.setType(Schedule.TYPE_COM);
        schedule.setStatus(Schedule.STATUS_OK);
        schedule.setCompanyId(-1);
        schedule.setCompanyName(Schedule.HOSTNAME);
        schedule.setPlace(place);
        schedule.setTitle(title);
        schedule.setContent(content);
        schedule.setsTime(DateUtil.parseDate(startTime, DateUtil.FORMAT_FULL));
        schedule.seteTime(DateUtil.parseDate(endTime, DateUtil.FORMAT_FULL));
        return scheduleDAO.addSchedule(schedule);
    }

    @Override
    public Schedule getSchedule(int id) {
        return scheduleDAO.getSchedule(id);
    }

    @Override
    public int updateSchedule(Schedule schedule) {
        return scheduleDAO.updateSchedule(schedule);
    }

    @Override
    public int updateStatus(int id, int status) {
        return scheduleDAO.updateStatus(id,status);
    }

    @Override
    public int addRecommendSchedule(int type, int scheduleId, String startTime, String endTime) {
        //判断当前活动是否是展商 并且 是否是审核通过
        Schedule schedule = scheduleDAO.getSchedule(scheduleId);
        if(schedule==null){
            return -1;
        }
        if(schedule.getStatus()!=Schedule.STATUS_OK){
            return -99;
        }

        RecommendSchedule recommendSchedule = new RecommendSchedule();
        recommendSchedule.setType(type);
        recommendSchedule.setScheduleId(scheduleId);
        recommendSchedule.setsTime(DateUtil.parseDate(startTime, DateUtil.FORMAT_FULL));
        recommendSchedule.seteTime(DateUtil.parseDate(endTime, DateUtil.FORMAT_FULL));
        return recommendScheduleDAO.addRecommendSchedule(recommendSchedule);
    }

    @Override
    public int delRecommendSchedule(int id) {
        return recommendScheduleDAO.delRecommendSchedule(id);
    }

    @Override
    public PageHolder<Schedule> querySchedule(ScheduleQuery query) {
        return scheduleDAO.querySchedule(query);
    }

    @Override
    public PageHolder<Schedule> queryRecommendSchedule(RecommendScheduleQuery query) {
        return scheduleDAO.queryRecommendSchedule(query);
    }
}
