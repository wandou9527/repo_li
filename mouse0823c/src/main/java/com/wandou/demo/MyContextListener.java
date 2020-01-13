package com.wandou.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 2020-01-08
 * 1方式
 */

@Slf4j
@Component
public class MyContextListener implements ApplicationListener<MyContextEvent> {

//    @Async
    @Override
    public void onApplicationEvent(MyContextEvent myContextEvent) {
        System.out.println("1方式  listener this MyContextEvent....");
        log.info("1方式 listener this MyContextEvent....");
        log.info("1方式 监听者接到: " + myContextEvent.toString() + "\n 有人来注册要给生成账号");
        //此处异常影响生产者后续代码 传统spring事件方式
//        throw new RuntimeException("1方式异常");
    }
}

