package com.viewol.pojo;

/**
 * Created by lenovo on 2019/7/8.
 * 企业历程
 */

public class CompanyProgress {

    private String times;

    private String des;

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "CompanyProgress{" +
                "times='" + times + '\'' +
                ", des='" + des + '\'' +
                '}';
    }
}
