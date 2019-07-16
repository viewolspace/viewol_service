package com.viewol.dao;

import com.viewol.pojo.Schedule;
import com.viewol.pojo.ScheduleUser;
import com.youguu.core.util.PageHolder;

import java.util.List;

/**
 * Created by lenovo on 2018/7/3.
 */
public interface IScheduleUserDAO {

    PageHolder<ScheduleUser> queryScheduleUser(int scheduleId,int pageIndex,int pageSize);


    List<Schedule> queryUserSchedule(int userId,int startNum,int pageSize);

    /**
     * 报名参加活动
     * 0 提醒 1不提醒
     * @return
     */
    int applyJoin(ScheduleUser scheduleUser);

    /**
     * 是否参加活动了
     * @param userId
     * @param scheduleId
     * @return
     */
    int isJoinSchedule(int userId,int scheduleId);


    /**
     * 修改提现标识
     * @param id
     * @param reminderFlag 0 未通知 1已通知 2通知失败
     * @return
     */
    int updateReminderFlag(int id, int reminderFlag);


    List<ScheduleUser> queryNeedReminder();

}
