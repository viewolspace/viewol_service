package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.IScheduleUserDAO;
import com.viewol.pojo.ScheduleUser;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/7/3.
 */
@Repository("scheduleUserDAO")
public class ScheduleUserDAOImpl extends BaseDAO<ScheduleUser> implements IScheduleUserDAO {
    @Override
    public PageHolder<ScheduleUser> queryScheduleUser(int scheduleId, int pageIndex, int pageSize) {
        Map<String,Object> map = new HashMap<>();
        map.put("scheduleId",scheduleId);
        return super.pagedQuery("findByParams",map,pageIndex,pageSize);
    }

    @Override
    public int applyJoin(ScheduleUser scheduleUser) {
        scheduleUser.setcTime(new Date());
        int result = super.insert(scheduleUser);
        if(result > 0){
            return scheduleUser.getId();
        }else{
            return 0;
        }

    }

    @Override
    public int isJoinSchedule(int userId, int scheduleId) {
        Map<String,Object> map = new HashMap<>();
        map.put("scheduleId",scheduleId);
        map.put("userId",userId);
        ScheduleUser scheduleUser = super.findUniqueBy("isJoinSchedule",map);
        if(scheduleUser==null){
            return 0;
        }else{
            return 1;
        }

    }

    @Override
    public int updateReminderFlag(int id) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        return super.updateBy("updateReminderFlag",map);
    }

    @Override
    public List<ScheduleUser> queryNeedReminder() {
        return super.findBy("queryNeedReminder",null);
    }
}
