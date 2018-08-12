package com.viewol.service.impl;

import com.viewol.dao.ICompanyDAO;
import com.viewol.dao.IProductDAO;
import com.viewol.dao.IUserCollectionDAO;
import com.viewol.pojo.Company;
import com.viewol.pojo.Product;
import com.viewol.pojo.UserCollection;
import com.viewol.service.IUserCollectionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2018/7/16.
 */
@Service("userCollectionService")
public class UserCollectionServiceImpl implements IUserCollectionService {

    @Resource
    private IUserCollectionDAO userCollectionDAO;

    @Resource
    private ICompanyDAO companyDAO;

    @Resource
    private IProductDAO productDAO;

    @Override
    public int addUserCollection(int userId, int type, int thirdId) {

        UserCollection userCollection = new UserCollection();
        userCollection.setUserId(userId);
        userCollection.setType(type);
        userCollection.setThirdId(thirdId);
        if(type==UserCollection.TYPE_PRODUCT){
            Product p = productDAO.getProduct(thirdId);
            if(p==null){
                return 0;
            }

            userCollection.setName(p.getName());
            userCollection.setImage(p.getImageView());

        }else{
            Company company = companyDAO.getCompany(thirdId);
            if(company==null){
                return 0;
            }
            userCollection.setName(company.getName());
            userCollection.setImage(company.getLogoView());
        }

        return userCollectionDAO.addUserCollection(userCollection);
    }

    @Override
    public int delUserCollection(int userId, int type, int thirdId) {
        return userCollectionDAO.delUserCollection(userId, type, thirdId);
    }

    @Override
    public int isCollection(int userId, int type, int thirdId) {
        return userCollectionDAO.isCollection(userId, type, thirdId);
    }

    @Override
    public List<UserCollection> listUserCollection(int userId, int type, int num, int lastId) {
        return userCollectionDAO.listUserCollection(userId, type, num, lastId);
    }
}
