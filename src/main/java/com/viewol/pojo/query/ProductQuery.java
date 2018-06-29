package com.viewol.pojo.query;

/**
 * Created by lenovo on 2018/6/29.
 */
public class ProductQuery {

    private String categoryId;

    private Integer company_id;

    private String name;

    private Integer status;

    private int pageIndex = 1;

    private int pageSize = 20;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
