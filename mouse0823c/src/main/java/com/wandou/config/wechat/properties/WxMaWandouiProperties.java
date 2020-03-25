package com.wandou.config.wechat.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 豌豆i 小程序配置信息类
 */

@Getter
@Configuration
public class WxMaWandouiProperties {
    @Value("${wx.ma.wandoui.appId}")
    private String appId;

    @Value("${wx.ma.wandoui.secret}")
    private String secret;

}
