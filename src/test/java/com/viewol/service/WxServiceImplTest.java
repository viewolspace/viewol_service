package com.viewol.service;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.viewol.base.BaseTestClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class WxServiceImplTest extends BaseTestClass {

    private IWxService wxService = (IWxService) getInstance("wxService");


    @Test
    public void getSessionInfo() {
        WxMaJscode2SessionResult result = wxService.getSessionInfo("061DV9vD0BCb6e2sFQuD009evD0DV9vE");
        System.out.println(result.toString());
    }

    @Test
    public void getUserInfo() {
    }

    @Test
    public void getTokenFromDb() {
    }

    @Test
    public void getJsapiTicket() {
    }

    @Test
    public void isFollow() {
    }

    @Test
    public void getUserInfo1() {
    }

    @Test
    public void getUserInfo2() {
    }

    @Test
    public void getAccessToken() {
    }
}