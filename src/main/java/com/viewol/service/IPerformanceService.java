package com.viewol.service;

import com.viewol.pojo.Performance;
import com.viewol.pojo.query.PerformanceQuery;
import com.youguu.core.util.PageHolder;

public interface IPerformanceService {
    Performance getPerformance(int id);

    int addPerformance(Performance performance);

    int deletePerformance(int id);

    int updatePerformance(Performance performance);

    PageHolder<Performance> queryPerformance(PerformanceQuery query);
}
