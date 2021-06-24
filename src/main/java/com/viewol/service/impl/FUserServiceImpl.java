package com.viewol.service.impl;

import com.viewol.dao.IFUserBindDAO;
import com.viewol.dao.IFUserDAO;
import com.viewol.dao.IUserAnswerDAO;
import com.viewol.pojo.FUser;
import com.viewol.pojo.FUserBind;
import com.viewol.pojo.UserAnswer;
import com.viewol.pojo.query.FUserQuery;
import com.viewol.service.IFUserService;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by lenovo on 2018/7/9.
 */
@Service("fUserService")
public class FUserServiceImpl implements IFUserService {

    @Resource
    private IFUserDAO ifUserDAO;

    @Resource
    private IFUserBindDAO ifUserBindDAO;

    @Resource
    private IUserAnswerDAO userAnswerDAO;


    @Override
    public FUser getFuser(int uid) {
        return ifUserDAO.getFuser(uid);
    }

    @Transactional("viewolTX")
    @Override
    public int addFUser(String openId, String uuid, int type) {
        FUser fuser = new FUser();
        fuser.setcTime(new Date());
        fuser.setUuid(uuid);

        int uid = ifUserDAO.addFUser(fuser);

        FUserBind fUserBind = new FUserBind();
        fUserBind.setUserId(uid);
        fUserBind.setOpenId(openId);
        fUserBind.setUuid(uuid);
        fUserBind.setcTime(new Date());
        fUserBind.setType(type);
        int result = ifUserBindDAO.addFUserBind(fUserBind);
        return uid;
    }

    @Override
    public int addFuserBind(int userId,String openId, String uuid, int type) {
        FUserBind fUserBind = new FUserBind();
        fUserBind.setUserId(userId);
        fUserBind.setOpenId(openId);
        fUserBind.setUuid(uuid);
        fUserBind.setcTime(new Date());
        fUserBind.setType(type);
        int result = ifUserBindDAO.addFUserBind(fUserBind);
        return 1;
    }

    @Transactional("viewolTX")
    @Override
    public int addFUser(FUser fuser, String openId, String uuid , int type) {
        fuser.setcTime(new Date());
        fuser.setUuid(uuid);

        int uid = ifUserDAO.addFUser(fuser);

        FUserBind fUserBind = new FUserBind();
        fUserBind.setUserId(uid);
        fUserBind.setOpenId(openId);
        fUserBind.setUuid(uuid);
        fUserBind.setcTime(new Date());
        fUserBind.setType(type);
        int result = ifUserBindDAO.addFUserBind(fUserBind);
        return uid;
    }

    @Transactional("viewolTX")
    @Override
    public int addFUser(FUser fuser, String answer, String openId, String uuid, int type) {
        fuser.setcTime(new Date());
        fuser.setUuid(uuid);

        int uid = ifUserDAO.addFUser(fuser);

        FUserBind fUserBind = new FUserBind();
        fUserBind.setUserId(uid);
        fUserBind.setOpenId(openId);
        fUserBind.setUuid(uuid);
        fUserBind.setcTime(new Date());
        fUserBind.setType(type);
        int result = ifUserBindDAO.addFUserBind(fUserBind);

        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setUserId(uid);
        userAnswer.setAnswer(answer);
        userAnswerDAO.addUserAnswer(userAnswer);
        return uid;
    }

    @Override
    public int updateUser(FUser fuser) {
        return ifUserDAO.updateFUser(fuser);
    }

    @Transactional("viewolTX")
    @Override
    public int updateUser(FUser fuser, String answer) {
        int result = ifUserDAO.updateFUser(fuser);
        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setUserId(fuser.getUserId());
        userAnswer.setAnswer(answer);
        userAnswerDAO.addUserAnswer(userAnswer);
        return result;
    }

    @Override
    public String getOpenId(int uid,int type) {
        FUserBind userBind = ifUserBindDAO.getOpenId(uid, type);
        if(userBind==null){
            return null;
        }else{
            return userBind.getOpenId();
        }
    }

    @Override
    public PageHolder<FUser> querFUser(FUserQuery query) {
        return ifUserDAO.querFUser(query);
    }

    @Override
    public FUser getUserByUuid(String uuid) {
        return ifUserDAO.getUserByUuid(uuid);
    }

    @Override
    public FUser getUserByOpenId(String openId, int type) {
        FUserBind userBind = ifUserBindDAO.getFUserBind(openId, type);
        if(userBind!=null){
            int userId = userBind.getUserId();
            return ifUserDAO.getFuser(userId);
        }
        return null;
    }

    @Override
    public int inviteeNum(int userId) {
        return ifUserDAO.inviteeNum(userId);
    }
}
