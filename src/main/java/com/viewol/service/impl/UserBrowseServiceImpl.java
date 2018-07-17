package com.viewol.service.impl;

import com.viewol.dao.ICompanyDAO;
import com.viewol.dao.IProductDAO;
import com.viewol.dao.IUserBrowseDAO;
import com.viewol.pojo.Company;
import com.viewol.pojo.Product;
import com.viewol.pojo.UserBrowse;
import com.viewol.pojo.UserCollection;
import com.viewol.service.IUserBrowseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2018/7/17.
 */
@Service("userBrowseService")
public class UserBrowseServiceImpl implements IUserBrowseService {

    @Resource
    private IProductDAO productDAO;

    @Resource
    private IUserBrowseDAO userBrowseDAO;

    @Resource
    private ICompanyDAO companyDAO;

    @Override
    public int addUserBrowse(int userId, int type, int thirdId) {
        UserBrowse userBrowse = new UserBrowse();
        userBrowse.setUserId(userId);
        userBrowse.setType(type);
        userBrowse.setThirdId(thirdId);

        if(type== UserCollection.TYPE_COM){
            Product p = productDAO.getProduct(thirdId);
            if(p==null){
                return 0;
            }

            userBrowse.setName(p.getName());
            userBrowse.setImage(p.getImageView());

        }else{
            Company company = companyDAO.getCompany(thirdId);
            if(company==null){
                return 0;
            }
            userBrowse.setName(company.getName());
            userBrowse.setImage(company.getLogoView());
        }
        return userBrowseDAO.addUserBrowse(userBrowse);
    }

    @Override
    public List<UserBrowse> listUserBrowse(int userId, int type, int num, int lastId) {
        return userBrowseDAO.listUserBrowse(userId, type, num, lastId);
    }
}
