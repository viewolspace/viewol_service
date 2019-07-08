package com.viewol.pojo;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2019/7/8.
 */
public class CompanyShow {

    private List<String> imgUrl;

    /**
     * 历程
     */
    private List<CompanyProgress> progresses;

    /**
     * 产品图片
     */
    private List<String> productUrl;

    public List<String> getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(List<String> imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<CompanyProgress> getProgresses() {
        return progresses;
    }

    public void setProgresses(List<CompanyProgress> progresses) {
        this.progresses = progresses;
    }

    public List<String> getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(List<String> productUrl) {
        this.productUrl = productUrl;
    }


    public String toJson(){
        return JSON.toJSONString(this);
    }

    public static CompanyShow json2Obj(String data){
        CompanyShow companyShow = JSON.parseObject(data,CompanyShow.class);
        return companyShow;
    }

    @Override
    public String toString() {
        return "CompanyShow{" +
                "imgUrl=" + imgUrl +
                ", progresses=" + progresses +
                ", productUrl=" + productUrl +
                '}';
    }

    public static void main(String[] args) {
        CompanyShow companyShow = new CompanyShow();
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        companyShow.setImgUrl(list);


        List<CompanyProgress> progresses1 = new ArrayList<>();
        CompanyProgress companyProgress = new CompanyProgress();
        companyProgress.setDes("简介");
        companyProgress.setTimes("2019");
        progresses1.add(companyProgress);
        companyShow.setProgresses(progresses1);

        list = new ArrayList<>();
        list.add("11");
        list.add("12");
        companyShow.setProductUrl(list);


        String ison = companyShow.toJson();

        System.out.println(CompanyShow.json2Obj(ison));



    }
}
