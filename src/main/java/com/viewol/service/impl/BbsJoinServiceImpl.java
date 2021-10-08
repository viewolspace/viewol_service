package com.viewol.service.impl;

import com.viewol.dao.IBbsJoinDAO;
import com.viewol.pojo.BbsJoin;
import com.viewol.service.IBbsJoinService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2019/10/9.
 */
@Service("bbsJoinService")
public class BbsJoinServiceImpl implements IBbsJoinService{

    @Resource
    private IBbsJoinDAO bbsJoinDAO;

    @Override
    public BbsJoin getBbsJoin(int id) {
        return bbsJoinDAO.getBbsJoin(id);
    }

    @Override
    public BbsJoin getBbsJoin(String phone,int bbsId) {
        return bbsJoinDAO.getBbsJoin(phone,bbsId);
    }

    @Override
    public int addBbsJoin(BbsJoin bbsJoin) {
        return bbsJoinDAO.addBbsJoin(bbsJoin);
    }

    @Override
    public int signIn(String phone,int bbsId) {
        BbsJoin bbsJoin = bbsJoinDAO.getBbsJoin(phone,bbsId);
        if(bbsJoin==null){
            return -99;
        }

        return bbsJoinDAO.signIn(bbsJoin.getId(),1);
    }

    @Override
    public List<BbsJoin> listBbsJoin(int bbsId) {
        return bbsJoinDAO.listBbsJoin(bbsId);
    }
}
