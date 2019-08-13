package com.viewol.service;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import cn.binarywang.wx.miniapp.util.crypt.WxMaCryptUtils;
import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import com.viewol.base.BaseTestClass;
import org.junit.Test;

public class WxServiceImplTest extends BaseTestClass {

    private IWxService wxService = (IWxService) getInstance("wxService");


    @Test
    public void getSessionInfo() {
        WxMaJscode2SessionResult result = wxService.getSessionInfo(2,"061DV9vD0BCb6e2sFQuD009evD0DV9vE");
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
        String sessionKey = "osBPTCgluDYRBhffKBJC6w==";
        String encryptedData = "av/o/WO70XJkN4MCmSjEsNN1v8eGht0/obiczXeC45bhyzk5r3oXFaZZMMUk1RD+KPU3yQdnke8Bp3sCQ37+7DstA16uwFY9kDtBs3+PZt8/LCvqizSe4AFIaino2JZd+coN46+BC0QYHzdKTtn6CA5ypr629xqNtzF4vNhvQIZq8vqFodYAZK/ZJUUeW0wYb8UKMVIt8bRE+nuw8v4USuqNho/eR2o47SGDV6v/nnleRaUMTyUNfGHByuIt6Z5YXhCEERVulywpuEO5aeYqGadFUgaA/FSQhm1tZCt2a/qQ4Qm0FBavdHEAPE3ZZpk5IMeP8+aptfQ+7NAD++COQVnbOdy4QLYY1aSQn6Bb5k5S+acvc4zmFsajtfTYnIBnQWGN5IP0q1xHxvuN9oKhjeJ6Vtg1UgXV/3XLYY102/G/JUypgqhxBsM4DtZUMQjEQ4GUsJBp4rxt3l0kYHxR2MItKaKqjrSnSqbmBCfhyl0v5G3hs4zkOCxqB5wUyB0yMIOSW+8l1d6p6SUH+W5w2g==";
        String ivStr = "XYhHo7VhLvdpXBoBIarIYw==";


        String json = WxMaCryptUtils.decrypt(sessionKey, encryptedData, ivStr);

        WxMaUserInfo userInfo = WxMaGsonBuilder.create().fromJson(json, WxMaUserInfo.class);

        wxService.getUserInfo(2,sessionKey, encryptedData, ivStr);
    }

    @Test
    public void getAccessToken() {
    }

    @Test
    public void createCompanyWxaCode(){
        wxService.createCompanyWxaCode(3,11, 2515, 4, "pages/index/page", 100);
    }
}