package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.IUserAnswerDAO;
import com.viewol.pojo.UserAnswer;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by lenovo on 2018/7/18.
 */
@Repository("userAnswerDAO")
public class UserAnswerDAOImpl extends BaseDAO<UserAnswer> implements IUserAnswerDAO {
    @Override
    public int addUserAnswer(UserAnswer userAnswer) {
        userAnswer.setcTime(new Date());
        return super.insert(userAnswer);
    }
}
