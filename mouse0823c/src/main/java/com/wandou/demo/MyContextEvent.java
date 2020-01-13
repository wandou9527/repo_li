package com.wandou.demo;

import org.springframework.context.ApplicationEvent;

/**
 * 2020-01-08
 * https://blog.csdn.net/fw19940314/article/details/100010397
 */

public class MyContextEvent extends ApplicationEvent {

    public MyContextEvent(Object source) {
        super(source);
//        System.out.println("source message->" + source.toString());
    }
}


