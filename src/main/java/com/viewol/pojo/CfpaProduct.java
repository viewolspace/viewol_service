package com.viewol.pojo;

public class CfpaProduct {
    private String uuid;
    private String tyshxydm;//	展商公司统一信用代码（唯一标识）
    private String src;//	产品图片（二进制流或线下处理）
    private String cpjj;//	产品介绍
    private String cplx;//	产品类型
    private String cplxmc;//	产品类型名称

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTyshxydm() {
        return tyshxydm;
    }

    public void setTyshxydm(String tyshxydm) {
        this.tyshxydm = tyshxydm;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getCpjj() {
        return cpjj;
    }

    public void setCpjj(String cpjj) {
        this.cpjj = cpjj;
    }

    public String getCplx() {
        return cplx;
    }

    public void setCplx(String cplx) {
        this.cplx = cplx;
    }

    public String getCplxmc() {
        return cplxmc;
    }

    public void setCplxmc(String cplxmc) {
        this.cplxmc = cplxmc;
    }
}
