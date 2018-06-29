package com.viewol.pojo.query;

/**
 * Created by lenovo on 2018/6/29.
 */
public class CompanyQuery {
    private String name;

    private String categoryId;

    private int lastCompanyId; //客户端查询使用

    private int pageIndex = 1;

    private int pageSize = 20;

    public int getLastCompanyId() {
        return lastCompanyId;
    }

    public void setLastCompanyId(int lastCompanyId) {
        this.lastCompanyId = lastCompanyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
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
