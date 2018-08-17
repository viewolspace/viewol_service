package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.IInfoDAO;
import com.viewol.pojo.Info;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("infoDAO")
public class InfoDAOImpl extends BaseDAO<Info> implements IInfoDAO {
    @Override
    public int save(Info info) {
        return this.insert(info);
    }

    @Override
    public PageHolder<Info> queryInfo(String title, String startTime, String endTime, int pageIndex, int pageSize) {

        Map<String, Object> map = new HashMap<>();
        map.put("title", title);
        map.put("startTime", startTime);
        map.put("endTime", endTime);
        return this.pagedQuery("findByParams", map, pageIndex, pageSize);
    }

    @Override
    public List<Info> listInfo(int lastSeq, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("lastSeq", lastSeq);
        map.put("pageSize", pageSize);
        return this.findBy("listInfo", map);
    }
}
