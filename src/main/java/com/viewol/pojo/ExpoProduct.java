package com.viewol.pojo;

import java.util.Date;

/**
 * Created by lenovo on 2019/6/20.
 * 公司展会对应关系
 */
public class ExpoProduct {

    private int expoId;

    private int productId;

    private Date cTime;

    public int getExpoId() {
        return expoId;
    }

    public void setExpoId(int expoId) {
        this.expoId = expoId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }
}
