package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.ICompanyCategoryDAO;
import com.viewol.pojo.CompanyCategory;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/6/28.
 */
@Repository("companyCategoryDAO")
public class CompanyCategoryDAOImpl extends BaseDAO<CompanyCategory> implements ICompanyCategoryDAO {

    @Override
    public int addCompanyCategoryList(List<CompanyCategory> companyCategorys) {
        for (CompanyCategory c:companyCategorys){
            c.setcTime(new Date());
        }
        return super.batchInsert(companyCategorys, "batchInsert");
    }

    @Override
    public int delCompanyCategory(int id) {
        return super.delete(id);
    }

    @Override
    public int delAllCompanyCategory(int companyId) {
        Map<String, Object> map = new HashMap<>();
        map.put("companyId", companyId);
        return super.deleteBy("deleteAllCom",map);
    }

    @Override
    public List<CompanyCategory> queryCategory(int companyId) {
        Map<String, Object> map = new HashMap<>();
        map.put("companyId", companyId);
        return super.findBy("selectByCom",map);
    }
}
