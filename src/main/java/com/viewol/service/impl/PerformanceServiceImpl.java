package com.viewol.service.impl;

import com.viewol.dao.IPerformanceDAO;
import com.viewol.pojo.Performance;
import com.viewol.pojo.query.PerformanceQuery;
import com.viewol.service.IPerformanceService;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("performanceService")
public class PerformanceServiceImpl implements IPerformanceService {
    @Resource
    private IPerformanceDAO performanceDAO;

    @Override
    public Performance getPerformance(int id) {
        return performanceDAO.getPerformance(id);
    }

    @Override
    public int addPerformance(Performance performance) {
        return performanceDAO.addPerformance(performance);
    }

    @Override
    public int deletePerformance(int id) {
        return performanceDAO.deletePerformance(id);
    }

    @Override
    public int updatePerformance(Performance performance) {
        return performanceDAO.updatePerformance(performance);
    }

    @Override
    public PageHolder<Performance> queryPerformance(PerformanceQuery query) {
        return performanceDAO.queryPerformance(query);
    }
}
