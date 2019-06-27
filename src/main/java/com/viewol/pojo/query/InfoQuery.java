package com.viewol.pojo.query;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2019/6/27.
 */
public class InfoQuery {
    private String title;
    private Date startTime;
    private Date endTime;
    private Integer status;


    private Integer classify = 1;

    private Integer companyId;

    private int pageIndex = 1;

    private int pageSize = 20;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getClassify() {
        return classify;
    }

    public void setClassify(Integer classify) {
        this.classify = classify;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
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

    public Map<String,Object> map(){
        Map<String,Object> map = new HashMap<>();

        if(title!=null){
            map.put("title",title);
        }

        if(startTime!=null){
            map.put("startTime",startTime);
        }

        if(endTime!=null){
            map.put("endTime",endTime);
        }

        if(status!=null){
            map.put("status",status);
        }

        if(status!=null){
            map.put("status",status);
        }

        if(classify!=null){
            map.put("classify",classify);
        }

        if(companyId!=null){
            map.put("companyId",companyId);
        }

        return map;
    }
}
