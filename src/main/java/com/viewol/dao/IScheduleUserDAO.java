package com.viewol.dao;

import com.viewol.pojo.ScheduleUser;
import com.youguu.core.util.PageHolder;

/**
 * Created by lenovo on 2018/7/3.
 */
public interface IScheduleUserDAO {

    PageHolder<ScheduleUser> queryScheduleUser(int scheduleId,int pageIndex,int pageSize);

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

}
