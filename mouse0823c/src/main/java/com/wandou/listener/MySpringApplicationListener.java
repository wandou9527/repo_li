package com.wandou.listener;

import com.alibaba.fastjson.JSON;
import com.wandou.config.wechat.properties.WxMaWandouiProperties;
import com.wandou.constant.NameConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * springboot 的事件监听者
 */

@Slf4j
@Component
public class MySpringApplicationListener {

    @Autowired
    private NameConst nameConst;
    @Autowired
    private WxMaWandouiProperties wxMaWandouiProperties;


    @EventListener
    @Async
    public void applicationStartedEvent(ApplicationStartedEvent applicationStartedEvent) {
        log.info("ApplicationStartedEvent 收到消息, 初始化list, applicationStartedEvent:{}, source: {}",
                applicationStartedEvent,
                JSON.toJSONString(applicationStartedEvent.getSource()));
        nameConst.decodeList(null);
        log.info("appId:{}", wxMaWandouiProperties.getAppId());
    }

    @EventListener
    @Async
    public void applicationStartingEvent(ApplicationStartingEvent applicationStartingEvent) {
        log.info("接到 ApplicationStartingEvent ");
    }

    @EventListener
    @Async
    public void applicationReadyEvent(ApplicationReadyEvent applicationReadyEvent) {
        log.info("接到 ApplicationReadyEvent");
    }

}
