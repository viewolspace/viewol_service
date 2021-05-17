package com.viewol.service.impl;

import com.viewol.dao.ITechReportDAO;
import com.viewol.pojo.TechReport;
import com.viewol.pojo.query.TechReportQuery;
import com.viewol.service.ITechReportService;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("techReportService")
public class TechReportServiceImpl implements ITechReportService {
    @Resource
    private ITechReportDAO techReportDAO;

    @Override
    public TechReport getTechReport(int id) {
        return techReportDAO.getTechReport(id);
    }

    @Override
    public int addTechReport(TechReport techReport) {
        return techReportDAO.addTechReport(techReport);
    }

    @Override
    public int deleteTechReport(int id) {
        return techReportDAO.deleteTechReport(id);
    }

    @Override
    public int updateTechReport(TechReport techReport) {
        return techReportDAO.updateTechReport(techReport);
    }

    @Override
    public PageHolder<TechReport> queryTechReport(TechReportQuery query) {
        return techReportDAO.queryTechReport(query);
    }
}
