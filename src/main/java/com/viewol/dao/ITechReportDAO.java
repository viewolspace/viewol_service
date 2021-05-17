package com.viewol.dao;

import com.viewol.pojo.TechReport;
import com.viewol.pojo.query.TechReportQuery;
import com.youguu.core.util.PageHolder;

public interface ITechReportDAO {
    TechReport getTechReport(int id);

    int addTechReport(TechReport techReport);

    int deleteTechReport(int id);

    int updateTechReport(TechReport techReport);

    PageHolder<TechReport> queryTechReport(TechReportQuery query);
}
