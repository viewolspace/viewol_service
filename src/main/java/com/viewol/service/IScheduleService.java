package com.viewol.service;

import com.viewol.pojo.Schedule;
import com.viewol.pojo.ScheduleUser;
import com.viewol.pojo.ScheduleVO;
import com.viewol.pojo.query.RecommendScheduleQuery;
import com.viewol.pojo.query.ScheduleQuery;
import com.youguu.core.util.PageHolder;

/**
 * Created by lenovo on 2018/7/3.
 */
public interface IScheduleService {

    /**
     * 判断公司是否有正在审核的活动
     * @param companyId
     * @return
     */
    boolean hasApplySchedule(int companyId);

    /**
     * 展商申请活动
     * 时间格式：yyyy-MM-dd HH:mi:ss
     * -99 表示已经有申请的活动没有推过审核
     * -98 表示公司没有申请活动的权限
     * @return
     */
    int applySchedule(int companyId,String title,String place,String content,String startTime,String endTime);

    /**
     * 主办方添加
     * @param title
     * @param place
     * @param content
     * @param startTime yyyy-MM-dd HH:mi:ss
     * @param endTime
     * @return
     */
    int addSchedule(String title,String place,String content,String startTime,String endTime);


    /**
     * 查看单个活动
     * @param id
     * @return
     */
    Schedule getSchedule(int id);

    int delSchedule(int id);

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
     * 添加推荐 或者 置顶活动
     * -99 此活动没有审核通过
     * @param type
     * @param scheduleId
     * @param startTime
     * @param endTime
     * @return
     */
    int addRecommendSchedule(int type,int scheduleId,String startTime,String endTime);

    /**
     * 删除推荐 或者 置顶活动
     * @param id
     * @return
     */
    int delRecommendSchedule(int id);


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
    PageHolder<ScheduleVO> queryRecommendSchedule(RecommendScheduleQuery query);

    /**
     * 查询报名活动的用户
     * @param scheduleId
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageHolder<ScheduleUser> queryScheduleUser(int scheduleId,int pageIndex,int pageSize);

    /**
     * 报名参加活动
     * -99 表示已经参加了活动
     * -98 没有这个活动
     * -97 活动已经结束
     * @param userId
     * @param scheduleId
     * @param needReminder 是否需要提醒
     * @return
     */
    int applyJoin(int userId,int scheduleId,boolean needReminder);

    /**
     * 是否参加活动了
     * @param userId
     * @param scheduleId
     * @return
     */
    boolean isJoinSchedule(int userId,int scheduleId);
}
