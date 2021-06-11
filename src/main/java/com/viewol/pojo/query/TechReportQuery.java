package com.viewol.pojo.query;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class TechReportQuery {
    private String phone;//手机号
    private String email;//邮箱
    private String openId;//微信
    private String name;//报告人姓名
    private int companyId;
    private String companyName;

    private int pageIndex = 1;
    private int pageSize = 20;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Map<String, Object> map() {
        Map<String, Object> map = new HashMap<>();

        if (!StringUtils.isEmpty(phone)) {
            map.put("phone", phone);
        }

        if (!StringUtils.isEmpty(email)) {
            map.put("email", email);
        }

        if (!StringUtils.isEmpty(openId)) {
            map.put("openId", openId);
        }

        if (!StringUtils.isEmpty(name)) {
            map.put("name", name);
        }

        if (companyId > 0) {
            map.put("companyId", companyId);
        }

        if (!StringUtils.isEmpty(companyName)) {
            map.put("companyName", companyName);
        }
        return map;
    }
}
