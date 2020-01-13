package com.wandou.demo;

import lombok.extern.slf4j.Slf4j;
import org.greenrobot.eventbus.Subscribe;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 2020-01-08
 * 2方式
 */

@Slf4j
@Component
public class EventListener {

//    @Async
    @Subscribe
    public void onMessageEvent(String event) {
        log.info("2方式 EventBus Listener 收到 Subscribe message: {}", event);
        //此处加异常并不影响生产者后续代码 EventBus方式
        throw new RuntimeException("2方式 异常");
    }
}


