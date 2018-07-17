package com.viewol.service.impl;

import com.viewol.dao.IProductDAO;
import com.viewol.dao.IUserDownloadDAO;
import com.viewol.pojo.Product;
import com.viewol.pojo.UserDownload;
import com.viewol.service.IUserDownloadService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2018/7/17.
 */
@Service("userDownloadService")
public class UserDownloadServiceImpl implements IUserDownloadService {

    @Resource
    private IUserDownloadDAO userDownloadDAO;

    @Resource
    private IProductDAO productDAO;

    @Override
    public int addUserDownload(int userId, int productId) {
        UserDownload userDownload = userDownloadDAO.getUserDownload(userId, productId);

        if(userDownload==null){
            Product product = productDAO.getProduct(productId);
            if(product!=null){
                userDownload = new UserDownload();
                userDownload.setUserId(userId);
                userDownload.setProductName(product.getName());
                userDownload.setProductId(productId);
                userDownload.setImage(product.getImage());
                userDownload.setPdfUrl(product.getPdfUrl());
                return userDownloadDAO.addUserDownload(userDownload);
            }

        }


        return 0;
    }

    @Override
    public List<UserDownload> listDownload(int userId, int num, int lastId) {
        return userDownloadDAO.listDownload(userId, num, lastId);
    }

    @Override
    public List<UserDownload> queryByIds(List<Integer> ids) {
        return userDownloadDAO.queryByIds(ids);
    }
}
