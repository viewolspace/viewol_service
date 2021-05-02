package com.viewol.service.impl;

import com.viewol.dao.IAdMediaDAO;
import com.viewol.pojo.AdMedia;
import com.viewol.pojo.query.AdMediaQuery;
import com.viewol.service.IAdMediaService;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("adMediaService")
public class AdMediaServiceImpl implements IAdMediaService {

    @Resource
    private IAdMediaDAO dao;

    @Override
    public int addAdMedias(List<AdMedia> list) {
        return dao.addAdMedias(list);
    }

    @Override
    public int delAdmedia(int companyId) {
        return dao.delAdmedia(companyId);
    }

    @Override
    public List<AdMedia> listByCompanyId(int companyId) {
        return dao.listByCompanyId(companyId);
    }

    @Override
    public PageHolder<AdMedia> queryAdMedia(AdMediaQuery query) {
        return dao.queryAdMedia(query);
    }
}
