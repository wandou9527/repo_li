package com.wandou.test;

import org.junit.Test;

import java.util.Random;
import java.util.TreeSet;

/**
 * @author liming
 * @date 2018/8/25 18:37
 * @description
 */
public class DemoTest {
    @Test
    public void m1() {
        TreeSet<Integer> treeSet = new TreeSet();
        for (int i = 0; i < 1000; i++) {
            treeSet.add(new Random().nextInt(9000) + 1000);
        }
        System.out.println(treeSet);
    }

    /**
     * 获取随机数
     */
    @Test
    public void m2() {
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            System.out.println(random.nextInt(100));
        }
    }
}
