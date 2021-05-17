package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.ITechReportDAO;
import com.viewol.pojo.TechReport;
import com.viewol.pojo.query.TechReportQuery;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Repository;

@Repository("techReportDAO")
public class TechReportDAOImpl extends BaseDAO<TechReport> implements ITechReportDAO {
    @Override
    public TechReport getTechReport(int id) {
        return this.get(id);
    }

    @Override
    public int addTechReport(TechReport techReport) {
        return this.insert(techReport);
    }

    @Override
    public int deleteTechReport(int id) {
        return this.delete(id);
    }

    @Override
    public int updateTechReport(TechReport techReport) {
        return this.update(techReport);
    }

    @Override
    public PageHolder<TechReport> queryTechReport(TechReportQuery query) {
        return this.pagedQuery("findByParams", query.map(), query.getPageIndex(), query.getPageSize());
    }
}
