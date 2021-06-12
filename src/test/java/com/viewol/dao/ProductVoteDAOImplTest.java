package com.viewol.dao;

import com.viewol.base.BaseTestClass;
import org.junit.Test;

/**
 * Created by lenovo on 2018/6/28.
 */
public class ProductVoteDAOImplTest extends BaseTestClass{

    private IProductVoteDAO dao = (IProductVoteDAO)getInstance("productVoteDAO");




    @Test
    public void addVote(){
        System.out.println(dao.addVote("123",111));
    }

    @Test
    public void voteNum(){
        System.out.println(dao.voteNum("123"));
    }

    @Test
    public void allNum(){
        System.out.println(dao.allNum());
    }

    @Test
    public void hasVote(){
        System.out.println(dao.hasVote("123",12));
    }


    @Test
    public void todayHasVote(){
        System.out.println(dao.todayHasVote("123"));
    }


}
