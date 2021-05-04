package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.IAdMediaDAO;
import com.viewol.pojo.AdMedia;
import com.viewol.pojo.query.AdMediaQuery;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2019/7/25.
 */
@Repository("adMediaDAO")
public class AdMediaDAOImpl extends BaseDAO<AdMedia> implements IAdMediaDAO {

    @Override
    public int addAdMedias(List<AdMedia> list) {
        return super.batchInsert(list,"batchInsert");
    }

    @Override
    public int delAdmedia(int companyId) {
        return super.deleteBy("deleteByCompanyId",companyId);
    }

    @Override
    public List<AdMedia> listByCompanyId(int companyId) {
        return super.findBy("selectByCompanyId",companyId);
    }

    @Override
    public PageHolder<AdMedia> queryAdMedia(AdMediaQuery query) {
        return super.pagedQuery("findByParams",query.map(),query.getPageIndex(),query.getPageSize());
    }
}
