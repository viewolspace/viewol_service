package com.viewol.service.impl;

import com.viewol.dao.ICompanyDAO;
import com.viewol.dao.IProductDAO;
import com.viewol.dao.IUserInteractDAO;
import com.viewol.pojo.FUser;
import com.viewol.pojo.UserInteract;
import com.viewol.service.IFUserService;
import com.viewol.service.IUserInteractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2019/7/4.
 */
@Service("userInteractService")
public class UserInteractServiceImpl implements IUserInteractService {

    @Resource
    private IUserInteractDAO userInteractDAO;

    @Resource
    private IProductDAO productDAO;

    @Resource
    private ICompanyDAO companyDAO;

    @Resource
    private IFUserService ifUserService;

    @Override
    public UserInteract getUserInteract(int userId, int thirdId, int classify, int type) {
        return userInteractDAO.getUserInteract(userId, thirdId, classify, type);
    }

    @Transactional("viewolTX")
    @Override
    public int userInteract(int userId, int thirdId, int classify, int type) {

        UserInteract userInteract = userInteractDAO.getUserInteract(userId, thirdId, classify, type);

        FUser user = ifUserService.getFuser(userId);

        if(userInteract==null && user!=null){

            userInteract = new UserInteract();
            userInteract.setUserId(userId);
            userInteract.setThirdId(thirdId);
            userInteract.setClassify(classify);
            userInteract.setType(type);
            userInteract.setUserName(user.getUserName());
            userInteract.setHeadImgUrl(user.getHeadImgUrl());

            switch (classify){
                case UserInteract.CLASSIFY_PRODUCT:
                    switch (type){
                        case UserInteract.TYPE_PRAISE:
                            productDAO.incPraiseNum(thirdId);
                            break;
                        case UserInteract.TYPE_SEE:
                            productDAO.incSeeNum(thirdId);
                            break;
                    }
                    break;
                case UserInteract.CLASSIFY_COMPANY:
                    switch (type){
                        case UserInteract.TYPE_PRAISE:
                            companyDAO.incPraiseNum(thirdId);
                            break;
                        case UserInteract.TYPE_SEE:
                            companyDAO.incSeeNum(thirdId);
                            break;
                    }
                    break;
            }

            return userInteractDAO.addUserInteract(userInteract);
        }

        return 0;
    }


    @Override
    public int userComment(int userId, int classify,int thirdId, String comment) {

        FUser user = ifUserService.getFuser(userId);

        if(user!=null){
            UserInteract userInteract = new UserInteract();
            userInteract.setUserId(userId);
            userInteract.setThirdId(thirdId);
            userInteract.setClassify(classify);
            userInteract.setType(UserInteract.TYPE_COMMENT);
            userInteract.setUserName(user.getUserName());
            userInteract.setHeadImgUrl(user.getHeadImgUrl());
            userInteract.setComment(comment);

            switch (classify){
                case UserInteract.CLASSIFY_PRODUCT:
                    productDAO.incCommentNum(thirdId);
                    break;
                case UserInteract.CLASSIFY_COMPANY:
                    productDAO.incCommentNum(thirdId);
                    break;
            }

            return userInteractDAO.addUserInteract(userInteract);
        }


        return 0;
    }



    @Override
    public List<UserInteract> queryList(int thirdId, int classify, int type, int num) {
        return userInteractDAO.queryList(thirdId, classify, type, num);
    }

    @Override
    public List<UserInteract> queryUserInteract(int userId, int thirdId, int classify) {
        return userInteractDAO.queryUserInteract(userId, thirdId, classify);
    }
}
