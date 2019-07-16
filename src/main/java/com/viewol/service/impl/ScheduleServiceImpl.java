package com.viewol.service.impl;

import com.alibaba.fastjson.JSON;
import com.viewol.dao.ICompanyDAO;
import com.viewol.dao.IRecommendScheduleDAO;
import com.viewol.dao.IScheduleDAO;
import com.viewol.dao.IScheduleUserDAO;
import com.viewol.pojo.*;
import com.viewol.pojo.query.RecommendScheduleQuery;
import com.viewol.pojo.query.ScheduleQuery;
import com.viewol.service.IScheduleService;
import com.viewol.util.DateUtil;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
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

    @Resource
    private IScheduleUserDAO scheduleUserDAO;


    @Override
    public boolean hasApplySchedule(int expoId,int companyId) {
        ScheduleQuery query = new ScheduleQuery();
        query.setCompanyId(companyId);
        query.setStatus(Schedule.STATUS_TRIAL);
        List<Schedule> list =  scheduleDAO.listSchedule(expoId,query);
        if(list!=null &&list.size()>0){
            return true;
        }else{
            return false;
        }
    }



    @Override
    public int applySchedule(int expoId,int companyId, String title, String place, String content, String startTime, String endTime) {
        //判断公司是否有权限申请活动
        Company company = companyDAO.getCompany(companyId);
        if(company==null){
            return -1;
        }
        if(company.getCanApply()==Company.CANAPPLY_NO){
            return -98;
        }

        //判断公司今天申请的数量是否已经上限

        if(this.comTodayNum(companyId) >= 2){
            return -99;
        }


        Schedule schedule = new Schedule();
        schedule.setType(Schedule.TYPE_COM);
        schedule.setStatus(Schedule.STATUS_OK);
        schedule.setCompanyId(companyId);
        schedule.setCompanyName(company.getName());
        schedule.setPlace(place);
        schedule.setTitle(title);
        schedule.setContentView(content);
        schedule.setsTime(DateUtil.parseDate(startTime, DateUtil.FORMAT_FULL));
        schedule.seteTime(DateUtil.parseDate(endTime, DateUtil.FORMAT_FULL));

        return scheduleDAO.addSchedule(expoId,schedule);
    }

    @Override
    public int addSchedule(int expoId,String title, String place, String content, String startTime, String endTime) {
        Schedule schedule = new Schedule();
        schedule.setType(Schedule.TYPE_HOST);
        schedule.setStatus(Schedule.STATUS_OK);
        schedule.setCompanyId(-1);
        schedule.setCompanyName(Schedule.HOSTNAME);
        schedule.setPlace(place);
        schedule.setTitle(title);
        schedule.setContentView(content);
        schedule.setsTime(DateUtil.parseDate(startTime, DateUtil.FORMAT_FULL));
        schedule.seteTime(DateUtil.parseDate(endTime, DateUtil.FORMAT_FULL));
        return scheduleDAO.addSchedule(expoId,schedule);
    }

    @Override
    public Schedule getSchedule(int id) {
        return scheduleDAO.getSchedule(id);
    }


    @Override
    public ScheduleVO getScheduleByUid(int scheduleId, int userId) {

        Schedule s = scheduleDAO.getSchedule(scheduleId);

        if(s!=null){
            ScheduleVO svo = JSON.parseObject(JSON.toJSONString(s),ScheduleVO.class);
            if(userId<=0){
                return svo;
            }
            //放开展商的报名
//            if(svo.getType().equals(Schedule.TYPE_COM)){
//                return svo;
//            }

            svo.setApplyStatus(ScheduleVO.APPLY_STATUS_CAN); //主办方的可以参与


            if(svo.geteTime().before(new Date())){//活动已经结束
                svo.setApplyStatus(ScheduleVO.APPLY_STATUS_END);
                return svo;
            }

            boolean isjoin = this.isJoinSchedule(userId,scheduleId);

            if(isjoin){
                svo.setApplyStatus(ScheduleVO.APPLY_STATUS_YES);
            }

            return svo;

        }




        return null;
    }

    @Override
    public int delSchedule(int id) {
        return scheduleDAO.delSchedule(id);
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
    public PageHolder<Schedule> querySchedule(int expoId,ScheduleQuery query) {
        return scheduleDAO.querySchedule(expoId,query);
    }

    @Override
    public PageHolder<ScheduleVO> queryRecommendSchedule(int expoId,RecommendScheduleQuery query) {
        return scheduleDAO.queryRecommendSchedule(expoId,query);
    }


    @Override
    public PageHolder<ScheduleUser> queryScheduleUser(int scheduleId, int pageIndex, int pageSize) {
        return scheduleUserDAO.queryScheduleUser(scheduleId, pageIndex, pageSize);
    }
    //TODO 是否关注
    @Override
    public int applyJoin(int userId, int scheduleId, boolean needReminder) {

        Schedule schedule = scheduleDAO.getSchedule(scheduleId);

        if(schedule==null){
            return -98;
        }

        if(schedule.geteTime().before(new Date())){
            return -97;
        }

        boolean isjoin = this.isJoinSchedule(userId,scheduleId);

        if(isjoin){
            return -99;
        }

        ScheduleUser scheduleUser = new ScheduleUser();
        scheduleUser.setUserId(userId);
        scheduleUser.setScheduleId(scheduleId);
        if(needReminder){
            Date d = schedule.getsTime();
            Calendar c = Calendar.getInstance();
            c.setTime(d);
            c.add(Calendar.MINUTE,-10);
            scheduleUser.setReminderTime(c.getTime());
        }

        return scheduleUserDAO.applyJoin(scheduleUser);
    }

    @Override
    public boolean isJoinSchedule(int userId, int scheduleId) {
        int result = scheduleUserDAO.isJoinSchedule(userId, scheduleId);
        if(result>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<Schedule> queryNowHostSchedule(int expoId) {
        return scheduleDAO.queryNowHostSchedule(expoId);
    }

    @Override
    public List<ScheduleVO> queryNowRecommendSchedule(int expoId,int type) {
        return scheduleDAO.queryNowRecommendSchedule(expoId,type);
    }


    @Override
    public List<Schedule> listSchedule(int expoId,String time, String date, int type, String keyword,long seq, int num,
                                       int companyId, int status,String endTime,String place) {
        ScheduleQuery query = new ScheduleQuery();
        query.setType(type);
        query.setSeq(seq);
        query.setTime(time);
        query.setEndTtime(endTime);
        query.setDate(date);
        query.setKeyword(keyword);
        query.setPlace(place);

        //如果不是这三个状态，则查询全部
        if(Schedule.STATUS_OK == status || Schedule.STATUS_TRIAL == status || Schedule.STATUS_BACK == status){
            query.setStatus(status);
        }

        query.setCompanyId(companyId);
        query.setPageSize(num);

        return scheduleDAO.listSchedule(expoId,query);
    }

    @Override
    public int updateReminderFlag(int id, int reminderFlag) {
        return scheduleUserDAO.updateReminderFlag(id, reminderFlag);
    }

    @Override
    public int comTodayNum(int comId) {
        return scheduleDAO.comTodayNum(comId);
    }

    @Override
    public List<ScheduleUser> queryNeedReminder() {
        return scheduleUserDAO.queryNeedReminder();
    }

    @Override
    public List<Schedule> queryUserSchedule(int userId, int startNum, int pageSize) {
        return scheduleUserDAO.queryUserSchedule(userId, startNum, pageSize);
    }
}
