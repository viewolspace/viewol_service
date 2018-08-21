package com.viewol.dao;

import com.viewol.base.BaseTestClass;
import com.viewol.pojo.WxToken;
import org.junit.Test;

import static org.junit.Assert.*;

public class WxTokenDAOImplTest extends BaseTestClass {

    private IWxTokenDAO dao = (IWxTokenDAO)getInstance("wxTokenDAO");


    @Test
    public void updateToken() {
        dao.updateToken("1111111111111", "33333333333333333333333333333444444444444");
    }

    @Test
    public void uodateJsapiTicket() {
        dao.updateJsapiTicket("1111111111111","ssssssssssssssssssssssssssssss");
    }

    @Test
    public void getWxToken() {
        WxToken wxToken = dao.getWxToken("1111111111111");
        System.out.println(wxToken.getToken());
    }
}