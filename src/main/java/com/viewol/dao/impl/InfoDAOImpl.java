package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.IInfoDAO;
import com.viewol.pojo.Info;
import com.viewol.pojo.query.InfoQuery;
import com.youguu.core.util.MD5;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("infoDAO")
public class InfoDAOImpl extends BaseDAO<Info> implements IInfoDAO {
    @Override
    public int save(int classify,Info info) {
        info.setClassify(classify);
        info.setmTime(new Date());
        info.setMd5Str(new MD5().getMD5ofStr(info.getTitle()));
        return this.insert(info);
    }

    @Override
    public PageHolder<Info> queryInfo(InfoQuery query) {


        return this.pagedQuery("findByParams", query.map(), query.getPageIndex(), query.getPageSize());
    }

    @Override
    public int updateInfo(Info info) {
        return super.update(info);
    }

    @Override
    public int deleteInfo(int id) {
        return super.delete(id);
    }

    @Override
    public List<Info> listInfo(int classify,int lastSeq, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("classify", classify);
        map.put("lastSeq", lastSeq);
        map.put("pageSize", pageSize);
        return this.findBy("listInfo", map);
    }

    @Override
    public Info getInfo(int id) {
        return super.get(id);
    }

    @Override
    public int updateStatus(int id, int status) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("status", status);
        map.put("mTime", new Date());
        return super.updateBy("updateStatus",map);
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
