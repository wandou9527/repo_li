package com.wandou.demo;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liming
 * @date 2021/6/24
 * @description
 */
public class GCDemo {
    public static final List<String> STR_LIST = new ArrayList<>();

    public static void gc1() {
        byte[] bytes = new byte[1024];
        STR_LIST.add(RandomStringUtils.random(RandomUtils.nextInt(100, Integer.MAX_VALUE)));
        System.out.println("gc1: " + STR_LIST.size());
    }

    public static void gc2() {
        int rand = RandomUtils.nextInt(0, 10);
        if (rand == 5) {
            byte[] bytes = new byte[RandomUtils.nextInt(1024, 20480)];
        }
    }
}
