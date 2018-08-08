package com.viewol.wx.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.WxMaInMemoryConfig;
import com.viewol.dao.IWxTokenDAO;
import com.viewol.pojo.WxToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;

/**
 * 微信小程序配置
 */
@Configuration
@PropertySource(value={"classpath:/properties/wxMa.properties"})
public class WxMaConfiguration {
	@Resource
	private IWxTokenDAO wxTokenDAO;

	@Value("${appId}")
	private String appId;

	@Value("${appSecret}")
	private String appSecret;

	@Bean
	public WxMaInMemoryConfig wxMaConfigStorage() {
		WxMaInMysqlConfig wxMaInMysqlConfig = new WxMaInMysqlConfig();
		wxMaInMysqlConfig.setAppid(this.appId);
		wxMaInMysqlConfig.setSecret(this.appSecret);

		WxToken wxToken = wxTokenDAO.getWxToken(this.appId);
		if (wxToken != null) {
			wxMaInMysqlConfig.setToken(wxToken.getToken());
		}

		return wxMaInMysqlConfig;
	}

	@Bean
	public WxMaService wxMaService() {
		WxMaService wxMaService = new WxMaServiceImpl();
		wxMaService.setWxMaConfig(wxMaConfigStorage());
		return wxMaService;
	}
}
