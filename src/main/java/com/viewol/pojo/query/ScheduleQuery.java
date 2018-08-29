package com.viewol.pojo.query;

/**
 * Created by lenovo on 2018/6/28.
 */
public class ScheduleQuery {

    //时间 -- 处于此区间
    private String time;

    //时间 -- 处于此区间
    private String endTtime;

    //日期 查询这一天的所有的活动
    private String date;

    private Integer companyId ;

    private Integer type;

    private Integer status;

    private String keyword;

    private long seq;

    private int pageIndex = 1;

    private int pageSize = 20;


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
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

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEndTtime() {
        return endTtime;
    }

    public void setEndTtime(String endTtime) {
        this.endTtime = endTtime;
    }
}
