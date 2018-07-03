package com.viewol.pojo.query;

/**
 * Created by lenovo on 2018/7/3.
 */
public class RecommendQuery {

    private Integer type;//1 展商  2 产品

    private String categoryId;

    private int pageIndex = 1;

    private int pageSize = 20;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
