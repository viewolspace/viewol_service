package com.viewol.service;

import com.viewol.base.ContextLoader;
import com.viewol.wx.config.WxMaConfiguration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class WxConfigurationTest {



    @Test
    public void getConfigure(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ContextLoader.class);
        WxMaConfiguration configuration = ctx.getBean(WxMaConfiguration.class);
        System.out.println(configuration);
    }


}
