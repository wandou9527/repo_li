package com.wandou.test;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.util.HashSet;
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

    @Test
    public void m3Set() {
        HashSet<Character> set = new HashSet<>();

        String str = "asadfjkqwerkakl";
        for (int i = 0; i < str.length(); i++) {
            boolean add = set.add(str.charAt(i));
            if (add == false) {
                System.out.println(str.charAt(i));
                return;
            }
        }
    }

    /**
     * 判断一个数是否是2的次方
     * 58到家面试 2018-8-29 上午
     * 二进制中如果是2的次方，最高位为1，其余为0
     */
    @Test
    public void m4() {
        int[] arr = {8, 7, 16, 32, 64, 66};
        int m = 9 & 8;
        System.out.println(m);
        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];
            boolean b = (n & (n - 1)) == 0;
            System.out.println(n + " 是否是2的次方 ? " + b);
        }
    }


    /**
     * do while
     */
    @Test
    public void m5() {
        int i = 1;
        do {
            System.out.println("RandomStringUtils.randomNumeric(4) = " + RandomStringUtils.randomNumeric(4));
            i ++;
        } while (i < 5);
    }

}