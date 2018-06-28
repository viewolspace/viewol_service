package com.viewol.pojo;

import java.util.Date;

/**
 * Created by lenovo on 2018/6/27.
 * 展商
 */
public class Company {

    public static final int CANAPPLY_YES = 1;

    public static final int CANAPPLY_NO = 0;

    private  Integer id;
    private  String  name;
    private  String  logo;
    private  String  banner; //形象图 通栏banner
    private  String  image; //推荐位的展示图 和查询列表的展示图
    private  String  place; //展馆的位置
    private  String  placeSvg;
    private  Integer  productNum; //数量
    private  Integer  canApply; //1 允许申请活动  0 不允许
    private Integer isRecommend; //0 非推荐  1 推荐
    private Integer recommendNum; //推荐的顺序号
    private  Date  cTime;
    private  Date  mTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPlaceSvg() {
        return placeSvg;
    }

    public void setPlaceSvg(String placeSvg) {
        this.placeSvg = placeSvg;
    }

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }

    public int getCanApply() {
        return canApply;
    }

    public void setCanApply(int canApply) {
        this.canApply = canApply;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public Date getmTime() {
        return mTime;
    }

    public void setmTime(Date mTime) {
        this.mTime = mTime;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    public void setCanApply(Integer canApply) {
        this.canApply = canApply;
    }

    public Integer getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }

    public Integer getRecommendNum() {
        return recommendNum;
    }

    public void setRecommendNum(Integer recommendNum) {
        this.recommendNum = recommendNum;
    }
}
