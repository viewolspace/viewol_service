package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.IInfoDAO;
import com.viewol.pojo.Info;
import com.youguu.core.util.MD5;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("infoDAO")
public class InfoDAOImpl extends BaseDAO<Info> implements IInfoDAO {
    @Override
    public int save(Info info) {
        info.setMd5Str(new MD5().getMD5ofStr(info.getTitle()));
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

    @Override
    public boolean isRepeat(String title) {
        Map<String, Object> map = new HashMap<>();
        map.put("md5Str", new MD5().getMD5ofStr(title));
        Info info = this.findUniqueBy("isRepeat", map);
        if(info!=null){
            return true;
        }
        return false;
    }
}
