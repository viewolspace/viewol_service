package com.viewol.dao;

public interface IProductVoteDAO {

    int addVote(String openId,int productId);

    int voteNum(String openId);

    boolean hasVote(String openId,int productId);

    boolean todayHasVote(String openId);

    int  allNum();
}
