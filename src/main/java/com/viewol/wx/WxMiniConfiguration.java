package com.viewol.wx;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.WxMaInMemoryConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 微信小程序配置
 */
@Configuration
public class WxMiniConfiguration {
	@Value("#{wxMiniProperties.appId}")
	private String appId;

	@Value("#{wxMiniProperties.appSecret}")
	private String appSecret;

	@Value("#{wxMiniProperties.token}")
	private String token;

	@Value("#{wxMiniProperties.aesKey}")
	private String aesKey;

	@Value("#{wxMiniProperties.msgDataFormat}")
	private String msgDataFormat;

	@Bean
	public WxMaInMemoryConfig wxMpConfigStorage() {
		WxMaInMemoryConfig wxMaInMemoryConfig = new WxMaInMemoryConfig();
		wxMaInMemoryConfig.setAppid(this.appId);
		wxMaInMemoryConfig.setSecret(this.appSecret);
		wxMaInMemoryConfig.setToken(this.token);
		wxMaInMemoryConfig.setAesKey(this.aesKey);
		wxMaInMemoryConfig.setMsgDataFormat(msgDataFormat);
		return wxMaInMemoryConfig;
	}

	@Bean
	public WxMaService wxMpService() {
		WxMaService wxMaService = new WxMaServiceImpl();
		wxMaService.setWxMaConfig(wxMpConfigStorage());
		return wxMaService;
	}
}
