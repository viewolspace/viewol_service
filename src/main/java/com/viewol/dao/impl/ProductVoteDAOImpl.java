package com.viewol.dao.impl;

import com.viewol.dao.BaseDAO;
import com.viewol.dao.IProductVoteDAO;
import com.viewol.pojo.ProductVote;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Repository("productVoteDAO")
public class ProductVoteDAOImpl extends BaseDAO<ProductVote> implements IProductVoteDAO {
    @Override
    public int addVote(String openId, int productId) {
        ProductVote productVote = new ProductVote();
        productVote.setOpenId(openId);
        productVote.setProductId(productId);
        productVote.setcTime(new Date());
        return super.insert(productVote);
    }

    @Override
    public int voteNum(String openId) {
        return super.count("voteNum",openId);
    }

    @Override
    public boolean hasVote(String openId, int productId) {
        Map<String,Object> map = new HashMap<>();
        map.put("openId",openId);
        map.put("productId",productId);
        int r = super.count("hasVote",map);
        return r>0?true:false;
    }

    @Override
    public boolean todayHasVote(String openId) {

        String strDateFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);

        Map<String,Object> map = new HashMap<>();
        map.put("openId",openId);
        map.put("today",sdf.format(new Date()));
        int r = super.count("todayHasVote",map);
        return r>0?true:false;
    }

    @Override
    public int allNum() {
        return super.count("allNum",null);
    }
}
