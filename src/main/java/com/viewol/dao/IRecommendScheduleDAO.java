package com.viewol.dao;

import com.viewol.pojo.RecommendSchedule;

/**
 * Created by lenovo on 2018/6/28.
 */
public interface IRecommendScheduleDAO {

    int addRecommendSchedule(RecommendSchedule recommendSchedule);

    int delRecommendSchedule(int id);

}
