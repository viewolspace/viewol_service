package com.viewol.service.impl;

import com.viewol.dao.IInfoDAO;
import com.viewol.pojo.Info;
import com.viewol.pojo.query.InfoQuery;
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
    public int save(int classify,Info info) {
        boolean repeat = this.isRepeat(info.getTitle());
        if(!repeat){
            return infoDAO.save(classify,info);
        }
        return -1;
    }

    @Override
    public PageHolder<Info> queryInfo(InfoQuery query) {
        return infoDAO.queryInfo(query);
    }

    @Override
    public List<Info> listInfo(int classify,int lastSeq, int pageSize) {
        return infoDAO.listInfo(classify,lastSeq, pageSize);
    }

    @Override
    public Info getInfo(int id) {
        return infoDAO.getInfo(id);
    }

    @Override
    public int updateStatus(int id, int status) {
        return infoDAO.updateStatus(id,status);
    }

    @Override
    public boolean isRepeat(String title) {
        return infoDAO.isRepeat(title);
    }
}
