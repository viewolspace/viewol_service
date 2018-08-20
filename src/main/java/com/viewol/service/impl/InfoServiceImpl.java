package com.viewol.service.impl;

import com.viewol.dao.IInfoDAO;
import com.viewol.pojo.Info;
import com.viewol.service.IInfoService;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("infoService")
public class InfoServiceImpl implements IInfoService {

    @Resource
    private IInfoDAO infoDAO;

    @Override
    public int save(Info info) {
        return infoDAO.save(info);
    }

    @Override
    public PageHolder<Info> queryInfo(String title, String startTime, String endTime, int pageIndex, int pageSize) {
        return infoDAO.queryInfo(title, startTime, endTime, pageIndex, pageSize);
    }

    @Override
    public List<Info> listInfo(int lastSeq, int pageSize) {
        return infoDAO.listInfo(lastSeq, pageSize);
    }
}
