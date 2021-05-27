package com.viewol.pojo.query;

import java.util.HashMap;
import java.util.Map;

public class UserInteractQuery {
    private int classify;
    private int type;
    private int thirdId;
    private int companyId;

    private int pageIndex = 1;
    private int pageSize = 20;

    public int getClassify() {
        return classify;
    }

    public void setClassify(int classify) {
        this.classify = classify;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getThirdId() {
        return thirdId;
    }

    public void setThirdId(int thirdId) {
        this.thirdId = thirdId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
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

    public Map<String, Object> map() {
        Map<String, Object> map = new HashMap<>();
        map.put("companyId", companyId);

        if (classify > 0) {
            map.put("classify", classify);
        }

        if (type > 0) {
            map.put("type", type);
        }

        if (thirdId > 0) {
            map.put("thirdId", thirdId);
        }

        return map;
    }
}
