package com.wandou.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 2020-01-09
 * 4方式 wk-vip
 * 使用的 3方式 event
 */

@Slf4j
@Component
public class Demo4Listener {

    @EventListener
    @Async
    public void event(UserRegisterEvent userRegisterEvent) {
        log.info("4方式收到消息： " + userRegisterEvent);
    }
}
