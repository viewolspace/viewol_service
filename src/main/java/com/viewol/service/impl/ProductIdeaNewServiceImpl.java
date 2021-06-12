package com.viewol.service.impl;

import com.viewol.dao.IProductIdeaNewDAO;
import com.viewol.dao.IProductVoteDAO;
import com.viewol.pojo.ProductIdeaNew;
import com.viewol.pojo.query.ProductIdeaNewQuery;
import com.viewol.service.IProductIdeaNewService;
import com.youguu.core.util.PageHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2019/7/25.
 */
@Service("productIdeaNewService")
public class ProductIdeaNewServiceImpl implements IProductIdeaNewService {

    @Autowired
    private IProductIdeaNewDAO productIdeaDAO;

    @Autowired
    private IProductVoteDAO iProductVoteDAO;

    @Override
    public ProductIdeaNew getProductIdea(int id) {
        return productIdeaDAO.getProductIdea(id);
    }

    @Override
    public int addProductIdea(ProductIdeaNew productIdea) {
        return productIdeaDAO.addProductIdea(productIdea);
    }

    @Override
    public int updateStatus(int productId, int status) {
        return productIdeaDAO.updateStatus(productId, status);
    }

    @Override
    public int updateProductIdea(ProductIdeaNew productIdea) {
        return productIdeaDAO.updateProductIdea(productIdea);
    }

    @Override
    public PageHolder<ProductIdeaNew> queryProductIdea(ProductIdeaNewQuery query) {
        return productIdeaDAO.queryProductIdea(query);
    }

    @Override
    public int countByCompanyId(int companyId) {
        return productIdeaDAO.countByCompanyId(companyId);
    }


    @Override
    public int vote(String openId, int productId) {
        //判断用户是否已经投股票
        boolean hasVote = iProductVoteDAO.todayHasVote(openId);
        if(hasVote){
            return -9;
        }

        //判断用户投票是否达到上限
        int voteNum = iProductVoteDAO.voteNum(openId);
        if(voteNum>=10){
            return -8;
        }

        int s = iProductVoteDAO.addVote(openId, productId);

        if(s>0){
            productIdeaDAO.updateNum(productId);
        }

        return 1;
    }

    @Override
    public List<ProductIdeaNew> list(String cid, String productName,int productId,int pageIndex,int pageSize) {

        return productIdeaDAO.list(cid,productName,productId, pageIndex, pageSize);
    }

    @Override
    public int allcount() {
        return productIdeaDAO.allcount();
    }
}
