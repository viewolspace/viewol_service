package com.viewol.pojo;

import com.viewol.util.ImageUtils;

import java.util.Date;

/**
 * Created by lenovo on 2018/6/29.
 */
public class Company {

    public static final int CANAPPLY_YES = 1;
    public static final int CANAPPLY_NO = 0;

    public static final int ISRECOMMEND_YES = 1;
    public static final int ISRECOMMEND_NO = 0;

    private Integer id;
    private String name;
    private String shortName; //简称
    private String logo;
    private String banner; //形象图
    private String image;  //列表图
    private String place;  //展馆的位置
    private String placeSvg;
    private Integer productNum;
    private Integer canApply; //1 允许申请活动  0 不允许
    private Integer isRecommend; //是否推荐展商 1 推荐 0 非推荐
    private Integer recommendNum; //推荐位置
    private String content;
    private Date cTime;
    private Date mTime;
    private long seq;
    private int award;
    private int topNum;
    private String show;

    private String logoView;
    private String bannerView;
    private String imageView;
    private String contentView;

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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
        this.logoView = ImageUtils.addUrlImage(logo);
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
        this.bannerView = ImageUtils.addUrlImage(banner);
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
        this.imageView = ImageUtils.addUrlImage(image);
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

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    public Integer getCanApply() {
        return canApply;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.contentView = ImageUtils.addUrlContent(content);
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

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    public String getLogoView() {
        return logoView;
    }

    public void setLogoView(String logoView) {
        this.logoView = logoView;
        this.logo = ImageUtils.diffUrlImage(this.logoView);
    }

    public String getBannerView() {
        return bannerView;
    }

    public void setBannerView(String bannerView) {
        this.bannerView = bannerView;
        this.banner = ImageUtils.diffUrlImage(this.bannerView);
    }

    public String getImageView() {
        return imageView;
    }

    public void setImageView(String imageView) {
        this.imageView = imageView;
        this.image = ImageUtils.diffUrlImage(this.imageView);
    }

    public String getContentView() {
        return contentView;
    }

    public void setContentView(String contentView) {
        this.contentView = contentView;
        this.content = ImageUtils.diffUrlContent(contentView);
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getTopNum() {
        return topNum;
    }

    public void setTopNum(int topNum) {
        this.topNum = topNum;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", logo='" + logo + '\'' +
                ", banner='" + banner + '\'' +
                ", image='" + image + '\'' +
                ", place='" + place + '\'' +
                ", placeSvg='" + placeSvg + '\'' +
                ", productNum=" + productNum +
                ", canApply=" + canApply +
                ", isRecommend=" + isRecommend +
                ", recommendNum=" + recommendNum +
                ", content='" + content + '\'' +
                ", cTime=" + cTime +
                ", mTime=" + mTime +
                ", seq=" + seq +
                ", award=" + award +
                ", topNum=" + topNum +
                ", logoView='" + logoView + '\'' +
                ", bannerView='" + bannerView + '\'' +
                ", imageView='" + imageView + '\'' +
                ", contentView='" + contentView + '\'' +
                '}';
    }


    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }
}
