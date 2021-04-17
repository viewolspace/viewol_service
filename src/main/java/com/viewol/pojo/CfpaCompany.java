package com.viewol.pojo;

public class CfpaCompany {
    private String tyshxydm;//	统一信用代码（唯一标识）
    private String zwgsmc;//	公司中文名称
    private String ywgsmc;//	公司英文名称
    private String src;//	公司LOGO（二进制流或线下处理）
    private String qyjj;//	公司介绍
    private String zwh;//	公司展位号
    private String frdb;//	法人代表
    private String frdbdh;//	法人代表电话
    private String lxr;//	联系人
    private String lxrsj;//	联系人手机
    private String sjzt;//	状态: 0 停用，1 有效。

    public String getTyshxydm() {
        return tyshxydm;
    }

    public void setTyshxydm(String tyshxydm) {
        this.tyshxydm = tyshxydm;
    }

    public String getZwgsmc() {
        return zwgsmc;
    }

    public void setZwgsmc(String zwgsmc) {
        this.zwgsmc = zwgsmc;
    }

    public String getYwgsmc() {
        return ywgsmc;
    }

    public void setYwgsmc(String ywgsmc) {
        this.ywgsmc = ywgsmc;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getQyjj() {
        return qyjj;
    }

    public void setQyjj(String qyjj) {
        this.qyjj = qyjj;
    }

    public String getZwh() {
        return zwh;
    }

    public void setZwh(String zwh) {
        this.zwh = zwh;
    }

    public String getFrdb() {
        return frdb;
    }

    public void setFrdb(String frdb) {
        this.frdb = frdb;
    }

    public String getFrdbdh() {
        return frdbdh;
    }

    public void setFrdbdh(String frdbdh) {
        this.frdbdh = frdbdh;
    }

    public String getLxr() {
        return lxr;
    }

    public void setLxr(String lxr) {
        this.lxr = lxr;
    }

    public String getLxrsj() {
        return lxrsj;
    }

    public void setLxrsj(String lxrsj) {
        this.lxrsj = lxrsj;
    }

    public String getSjzt() {
        return sjzt;
    }

    public void setSjzt(String sjzt) {
        this.sjzt = sjzt;
    }
}
