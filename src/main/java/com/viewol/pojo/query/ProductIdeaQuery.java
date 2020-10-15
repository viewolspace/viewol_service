package com.viewol.pojo.query;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2019/7/25.
 */
public class ProductIdeaQuery {

    private Integer status ;

    private String productName;

    private int pageIndex = 1;

    private int pageSize = 20;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

        if(status!=null){
            map.put("status",status);
        }

        if(productName!=null){
            map.put("productName",productName);
        }

        return map;
    }
}
