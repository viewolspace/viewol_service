package com.viewol.wx.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.WxMaInMemoryConfig;
import com.viewol.dao.IWxTokenDAO;
import com.viewol.pojo.WxToken;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * 微信小程序配置
 */
//@Configuration
public class WxMaConfiguration {
	@Resource
	private IWxTokenDAO wxTokenDAO;

//	@Value("#{wxMaProperties.appId}")
	private String appId;

//	@Value("#{wxMaProperties.appSecret}")
	private String appSecret;

	@Bean
	public WxMaInMemoryConfig wxMpConfigStorage() {
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
	public WxMaService wxMpService() {
		WxMaService wxMaService = new WxMaServiceImpl();
		wxMaService.setWxMaConfig(wxMpConfigStorage());
		return wxMaService;
	}
}
