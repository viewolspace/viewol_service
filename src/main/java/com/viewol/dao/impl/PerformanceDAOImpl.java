package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.IPerformanceDAO;
import com.viewol.pojo.Performance;
import com.viewol.pojo.query.PerformanceQuery;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Repository;

@Repository("performanceDAO")
public class PerformanceDAOImpl extends BaseDAO<Performance> implements IPerformanceDAO {
    @Override
    public Performance getPerformance(int id) {
        return this.get(id);
    }

    @Override
    public int addPerformance(Performance performance) {
        return this.insert(performance);
    }

    @Override
    public int deletePerformance(int id) {
        return this.delete(id);
    }

    @Override
    public int updatePerformance(Performance performance) {
        return this.update(performance);
    }

    @Override
    public PageHolder<Performance> queryPerformance(PerformanceQuery query) {
        return this.pagedQuery("findByParams", query.map(), query.getPageIndex(), query.getPageSize());
    }
}
