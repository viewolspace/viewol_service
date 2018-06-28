package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.IRecommendScheduleDAO;
import com.viewol.pojo.RecommendSchedule;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by lenovo on 2018/6/28.
 */
@Repository("recommendScheduleDAO")
public class RecommendScheduleDAOImpl extends BaseDAO<RecommendSchedule> implements IRecommendScheduleDAO {

    @Override
    public int addRecommendSchedule(RecommendSchedule recommendSchedule) {
        recommendSchedule.setcTime(new Date());
        return super.insert(recommendSchedule);
    }

    @Override
    public int delRecommendSchedule(int id) {
        return super.delete(id);
    }
}
