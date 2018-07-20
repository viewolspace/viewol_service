package com.viewol.wx.config;

import com.viewol.dao.IWxTokenDAO;
import com.viewol.pojo.WxToken;
import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * 微信公众号配置
 */
@Configuration
public class WxMpConfiguration {
	@Resource
	private IWxTokenDAO wxTokenDAO;

	@Value("#{wxMpProperties.appId}")
	private String appId;

	@Value("#{wxMpProperties.appSecret}")
	private String appSecret;

	@Bean
	public WxMpConfigStorage wxMpConfigStorage() {
		WxMpInMysqlConfigStorage configStorage = new WxMpInMysqlConfigStorage();
		configStorage.setAppId(this.appId);
		configStorage.setSecret(this.appSecret);

		WxToken wxToken = wxTokenDAO.getWxToken(this.appId);
		if(wxToken != null){
			configStorage.setToken(wxToken.getToken());
			configStorage.setJsapiTicket(wxToken.getJsapiTicket());
		}

		return configStorage;
	}

	@Bean
	public WxMpService wxMpService() {
		WxMpService wxMpService = new WxMpServiceImpl();
		wxMpService.setWxMpConfigStorage(wxMpConfigStorage());
		return wxMpService;
	}
}
