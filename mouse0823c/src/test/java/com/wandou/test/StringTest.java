package com.wandou.test;

import org.junit.Test;

/**
 * @author liming
 * @date 2018/8/25 17:40
 * @description
 */
public class StringTest {
    @Test
    public void m1() {
        System.out.println();
        String str = "你好";
        for (int i = 0; i < str.length(); i++) {
            System.out.println((int) str.charAt(i));
        }
    }
}
