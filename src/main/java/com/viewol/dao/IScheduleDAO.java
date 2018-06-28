package com.viewol.dao;

import com.viewol.pojo.Schedule;
import com.viewol.pojo.query.RecommendScheduleQuery;
import com.viewol.pojo.query.ScheduleQuery;
import com.youguu.core.util.PageHolder;

/**
 * Created by lenovo on 2018/6/28.
 */
public interface IScheduleDAO {

    /**
     * 添加活动
     * @param schedule
     * @return
     */
    int addSchedule(Schedule schedule);

    /**
     * 查询结果
     * @param id
     * @return
     */
    Schedule getSchedule(int id);

    /**
     * 修改活动
     * @param schedule
     * @return
     */
    int updateSchedule(Schedule schedule);

    /**
     * 活动审核
     * @param id
     * @param status
     * @return
     */
    int updateStatus(int id,int status);

    /**
     * 管理平台查询
     * @return
     */
    PageHolder<Schedule> querySchedule(ScheduleQuery query);


    /**
     * 管理平台查询推荐数据
     * @param query
     * @return
     */
    PageHolder<Schedule> queryRecommendSchedule(RecommendScheduleQuery query);
}
