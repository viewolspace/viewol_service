package com.viewol.pojo.query;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2018/7/9.
 */
public class UserCardQuery {
    private Integer bUserId;
    private Integer companyId;
    private Integer fUserId;

    private Integer lastId;

    private int pageIndex = 1;

    private int pageSize = 20;

    public Integer getbUserId() {
        return bUserId;
    }

    public void setbUserId(Integer bUserId) {
        this.bUserId = bUserId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getfUserId() {
        return fUserId;
    }

    public void setfUserId(Integer fUserId) {
        this.fUserId = fUserId;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getLastId() {
        return lastId;
    }

    public void setLastId(Integer lastId) {
        this.lastId = lastId;
    }

    public Map<String,Object> getMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("bUserId",bUserId);
        map.put("companyId",companyId);
        map.put("fUserId",fUserId);
        map.put("lastId",lastId);  //前端使用
        map.put("num",pageSize);  //前端使用
        return map;
    }
}
