package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.IScheduleDAO;
import com.viewol.pojo.Schedule;
import com.viewol.pojo.query.RecommendScheduleQuery;
import com.viewol.pojo.query.ScheduleQuery;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2018/6/28.
 */
@Repository("scheduleDAO")
public class ScheduleDAOImpl extends BaseDAO<Schedule> implements IScheduleDAO {

    @Override
    public int addSchedule(Schedule schedule) {
        schedule.setcTime(new Date());
        return super.insert(schedule);
    }

    @Override
    public Schedule getSchedule(int id) {
        return super.get(id);
    }

    @Override
    public int updateSchedule(Schedule schedule) {

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
    public PageHolder<Schedule> querySchedule(ScheduleQuery query) {

        Map<String,Object> map = new HashMap<>();
        map.put("time",query.getType());
        map.put("companyId",query.getCompanyId());
        map.put("type",query.getType());
        map.put("status",query.getStatus());
        map.put("keyword",query.getKeyword());

        return super.pagedQuery("findByParams",map,query.getPageIndex(),query.getPageSize());
    }

    @Override
    public PageHolder<Schedule> queryRecommendSchedule(RecommendScheduleQuery query) {
        Map<String,Object> map = new HashMap<>();
        map.put("time",query.getType());
        map.put("type",query.getTime());
        return super.pagedQuery("findRecommen",map,query.getPageIndex(),query.getPageSize());

    }
}
