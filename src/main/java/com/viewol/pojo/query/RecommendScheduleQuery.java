package com.viewol.pojo.query;

/**
 * Created by lenovo on 2018/6/28.
 */
public class RecommendScheduleQuery {

    private String time;
    private Integer type;

    private int pageIndex = 1;

    private int pageSize = 20;


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
}
