package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.IScheduleDAO;
import com.viewol.pojo.Schedule;
import com.viewol.pojo.ScheduleVO;
import com.viewol.pojo.query.RecommendScheduleQuery;
import com.viewol.pojo.query.ScheduleQuery;
import com.viewol.util.DateUtil;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/6/28.
 */
@Repository("scheduleDAO")
public class ScheduleDAOImpl extends BaseDAO<Schedule> implements IScheduleDAO {


    private long getSeq(Schedule schedule){
        //seq 需要单独生成
        Date stime = schedule.getsTime();

        int comId = schedule.getCompanyId();

        if(comId==-1){
            long seq = DateUtil.parseDate(stime,DateUtil.FORMAT_NUM);
            return seq;
        }

        long seq = DateUtil.parseDate(stime,DateUtil.FORMAT_NUM)*100000 + comId;

        return seq;
    }
    @Override
    public int addSchedule(int expoId,Schedule schedule) {
        schedule.setcTime(new Date());
        schedule.setSeq(this.getSeq(schedule));
        schedule.setExpoId(expoId);

        return super.insert(schedule);
    }

    @Override
    public int delSchedule(int id) {
        return super.delete(id);
    }

    @Override
    public Schedule getSchedule(int id) {
        return super.get(id);
    }

    @Override
    public int updateSchedule(Schedule schedule) {
        schedule.setSeq(this.getSeq(schedule));
        return super.update(schedule);
    }

    @Override
    public int updateStatus(int id, int status) {
        Map<String,Object> map = new HashMap<>();
        map.put("status",status);
        map.put("id",id);
        return super.updateBy("updateStatus",map);
    }


    @Override
    public List<Schedule> listSchedule(int expoId,ScheduleQuery query) {
        query.setExpoId(expoId);
        Map<String,Object> map = new HashMap<>();




        if( (query.getTime()==null || query.getTime().equals("")) && (query.getEndTtime()==null || query.getEndTtime().equals(""))){
            if(query.getDate()!=null){
                map.put("date",query.getDate());
                map.put("date_end",query.getDate() + " 23:59:59");
            }
        }else{
            if(query.getTime()!=null && !query.getTime().equals("")){
                map.put("time",query.getDate() + " " + query.getTime());
            }

            if(query.getEndTtime()!=null && !query.getEndTtime().equals("")){
                map.put("endTime",query.getDate() + " " + query.getEndTtime());
            }

        }

        map.put("seq",query.getSeq());
        map.put("place",query.getPlace());
        map.put("type",query.getType());
        map.put("status",query.getStatus());
        map.put("keyword",query.getKeyword());
        map.put("companyId",query.getCompanyId());
        map.put("expoId",query.getExpoId());

        map.put("num",query.getPageSize());
        return super.findBy("listSchedule",map);
    }

    @Override
    public PageHolder<Schedule> querySchedule(int expoId,ScheduleQuery query) {
        query.setExpoId(expoId);
        Map<String,Object> map = new HashMap<>();
        map.put("time",query.getTime());
        map.put("companyId",query.getCompanyId());
        map.put("type",query.getType());
        map.put("status",query.getStatus());
        map.put("keyword",query.getKeyword());
        map.put("expoId",query.getExpoId());

        return super.pagedQuery("findByParams",map,query.getPageIndex(),query.getPageSize());
    }

    @Override
    public PageHolder<ScheduleVO> queryRecommendSchedule(int expoId,RecommendScheduleQuery query) {
        query.setExpoId(expoId);
        Map<String,Object> map = new HashMap<>();
        map.put("type",query.getType());
        map.put("time",query.getTime());
        map.put("expoId",query.getExpoId());
        return super.pagedQuery("findRecommen",map,query.getPageIndex(),query.getPageSize());

    }

    @Override
    public List<Schedule> queryNowHostSchedule(int expoId) {
        Map<String,Object> map = new HashMap<>();
        map.put("expoId",expoId);
        return super.findBy("queryNowHostSchedule",map);
    }

    @Override
    public List<ScheduleVO> queryNowRecommendSchedule(int expoId,int type) {
        Map<String,Object> map = new HashMap<>();
        map.put("type",type);
        map.put("expoId",expoId);
        return super.findBy("queryNowRecommendSchedule",map);
    }

    @Override
    public int comTodayNum(int comId) {
        Map<String,Object> map = new HashMap<>();
        map.put("companyId",comId);
        return super.count("appLimit",map);
    }
}
