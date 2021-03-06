package com.viewol.wx.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.WxMaInMemoryConfig;
import com.viewol.dao.IWxTokenDAO;
import com.viewol.pojo.WxToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.Resource;

/**
 * 微信小程序配置
 */
@Configuration
@PropertySource(value={"classpath:/properties/wxMa.properties"})
public class WxMaNo2Configuration {
	@Resource
	private IWxTokenDAO wxTokenDAO;

	@Value("${ma2.appId}")
	private String appId;

	@Value("${ma2.appSecret}")
	private String appSecret;

	@Bean
	public WxMaInMemoryConfig wxMaNo2ConfigStorage() {
		WxMaInMysqlConfig wxMaInMysqlConfig = new WxMaInMysqlConfig();
		wxMaInMysqlConfig.setAppid(this.appId);
		wxMaInMysqlConfig.setSecret(this.appSecret);

		WxToken wxToken = wxTokenDAO.getWxToken(this.appId);
		if (wxToken != null) {
			wxMaInMysqlConfig.setToken(wxToken.getToken());
		}

		return wxMaInMysqlConfig;
	}

	@Bean("wxMaNo2Service")
	public WxMaService wxMaNo2Service() {
		WxMaService wxMaService = new WxMaServiceImpl();
		wxMaService.setWxMaConfig(wxMaNo2ConfigStorage());
		return wxMaService;
	}
}
