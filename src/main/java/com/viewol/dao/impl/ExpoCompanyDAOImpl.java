package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.IExpoCompanyDAO;
import com.viewol.pojo.ExpoCompany;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2019/6/20.
 */
@Repository("expoCompanyDAO")
public class ExpoCompanyDAOImpl extends BaseDAO<ExpoCompany> implements IExpoCompanyDAO{
    @Override
    public int saveExpoCompany(int expoId, int companyId) {
        ExpoCompany expoCompany = new ExpoCompany();
        expoCompany.setExpoId(expoId);
        expoCompany.setCompanyId(companyId);
        expoCompany.setcTime(new Date());
        return super.insert(expoCompany);
    }

    @Override
    public int delExpoCompany(int companyId) {
        Map<String,Object> map = new HashMap<>();
        map.put("companyId",companyId);
        return super.deleteBy("deleteExpoCompany",map);
    }
}
