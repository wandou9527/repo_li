package com.wandou.demo;

import lombok.Data;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

/**
 * 2020-01-08
 * https://blog.csdn.net/fw19940314/article/details/100010397
 */

@ToString
public class MyContextEvent extends ApplicationEvent {

    private Object data;

    public MyContextEvent(Object source, Object data) {
        super(source);
//        System.out.println("source message->" + source.toString());
        this.data = data;
    }
}


