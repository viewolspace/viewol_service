package com.viewol.pojo.query;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2019/7/25.
 */
public class AdMediaQuery {


    private int pageIndex = 1;

    private int pageSize = 20;

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


        return map;
    }
}
