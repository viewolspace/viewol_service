package com.viewol.dao;

import com.viewol.base.BaseTestClass;
import com.viewol.pojo.RecommendSchedule;
import org.junit.Test;

import java.util.Date;

/**
 * Created by lenovo on 2018/6/28.
 */
public class RecommendScheduleDAOImplTest extends BaseTestClass {
    private IRecommendScheduleDAO dao = (IRecommendScheduleDAO)getInstance("recommendScheduleDAO");


    private RecommendSchedule getRecommendSchedule(){
        RecommendSchedule r = new RecommendSchedule();
        r.setScheduleId(1);
        r.setType(RecommendSchedule.TYPE_TOP);
        r.setsTime(new Date());
        r.seteTime(new Date());
        return r;
    }

    @Test
    public void addRecommendSchedule(){
        dao.addRecommendSchedule(getRecommendSchedule());
    }

    @Test
    public void delRecommendSchedule(){
        dao.delRecommendSchedule(1);
    }



}
