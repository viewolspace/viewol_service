package com.viewol.service;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import cn.binarywang.wx.miniapp.util.crypt.WxMaCryptUtils;
import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import com.alibaba.fastjson.JSONObject;
import com.viewol.base.BaseTestClass;
import com.viewol.util.CiecImpl;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

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
    public void getAccessToken() throws Exception{

//        System.out.println(wxService.getAccessToken());
//        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxService.getAccessToken("HoagFKDcsGMVCIY2vOjf9hd0sNNUMLBR2gaHuMN-fL8ficJUIm9Q5bYjuoKiDqjDcdeA84CpEMzIo4FG9fKsRA");
//
//
//
//        System.out.println(wxService.getUserInfo(wxMpOAuth2AccessToken.getAccessToken(),"odb5R1kUmeQtRyDFvNxSxvlpHamM"));


        BufferedImage hb  = ImageIO.read(new FileInputStream("D:\\bj.png")); //原图

        Graphics2D g2 = hb.createGraphics();


        IWxService service = (IWxService)getInstance("wxService");

        File file = service.createPNGPublicxaCode(3,"pages/index/page","14:123",485);

        g2.drawImage(ImageIO.read(file),492,1723,null);

        //画头像
        BufferedImage bi  = ImageHandler.headImage("https://www.view-ol.com/11.png",134,134);

        g2.drawImage(bi,183,250,null);

        ImageHandler.drawString(g2,"王大锤  邀请您一起参加",462,335);



        ImageIO.write(hb, "PNG", new File( "d:\\tt.png"));
    }

    @Test
    public void createCompanyWxaCode() throws Exception{
        CiecImpl zi = new CiecImpl();
        JSONObject jsonObject = zi.getUserFromNobile("13810436365");
        System.out.println(jsonObject.toJSONString());
//        File file = wxService.createPNGPublicxaCode(3,"pages/index/page","13:123",485);
//        System.out.println(file.getPath());

//        wxService.createCompanyWxaCode(3,11, 2515, 4, "pages/index/page", 100);
//        for (int i=112;i<=126;i++){
//            wxService.createPublicxaCode(3,"pages/index/page","13:",100);
//        }



    }


}