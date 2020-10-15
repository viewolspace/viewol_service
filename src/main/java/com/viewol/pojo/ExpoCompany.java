package com.viewol.pojo;

import java.util.Date;

/**
 * Created by lenovo on 2019/6/20.
 * 公司展会对应关系
 */
public class ExpoCompany {

    private int expoId;

    private int companyId;

    private Date cTime;

    public int getExpoId() {
        return expoId;
    }

    public void setExpoId(int expoId) {
        this.expoId = expoId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }
}
