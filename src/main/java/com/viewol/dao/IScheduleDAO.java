package com.viewol.dao;

import com.viewol.pojo.Schedule;
import com.viewol.pojo.ScheduleVO;
import com.viewol.pojo.query.RecommendScheduleQuery;
import com.viewol.pojo.query.ScheduleQuery;
import com.youguu.core.util.PageHolder;

import java.util.List;

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

    int delSchedule(int id);

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
     * 查询
     * @param query
     * 入参
     * time
     * date
     * keyword
     * type
     * @return
     */
    List<Schedule> listSchedule(ScheduleQuery query);

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
     * 客户端使用查询当前推荐的展商活动
     * @param type 1 置顶  2推荐
     * @return
     */
    List<ScheduleVO> queryNowRecommendSchedule(int type);


    /**
     * 首页使用的接口 ， 查询主办方当前的活动 和 将要进行的活动
     * @return
     */
    List<Schedule> queryNowHostSchedule();


    int comTodayNum(int  comId);
}
