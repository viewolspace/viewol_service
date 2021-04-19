package com.viewol.service;

import com.viewol.pojo.CfpaCompany;
import com.viewol.pojo.CfpaProduct;

import java.util.List;

public interface CfpaService {

    /**
     * 展商基本信息（全量）
     *
     * @return
     */
    List<CfpaCompany> queryAllCfpaCompany();


    /**
     * 获取展商基本信息
     *
     * @param userNum 统一信用代码（唯一标识）
     * @return
     */
    CfpaCompany getCfpaCompany(String userNum);

    /**
     * 获取展商产品信息
     *
     * @param userNum 统一信用代码（唯一标识）
     * @return
     */
    List<CfpaProduct> getCfpaProduct(String userNum);

    /**
     * 获取展商产品信息（全量）
     *
     * @return
     */
    List<CfpaCompany> queryAllCfpaProduct();

    /**
     * 下载图片地址
     * @param path 相对路径
     * @return
     */
    void downloadImg(String path);
}
