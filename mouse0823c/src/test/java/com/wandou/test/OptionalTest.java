package com.wandou.test;

import org.junit.Test;

import java.util.Optional;

/**
 * @author liming
 * @date 2021/6/2
 * @description
 */
public class OptionalTest {

    @Test
    public void t1() {
        Optional<Integer> m1 = Optional.of(129);

        Optional<Object> m2 = Optional.empty();

        Integer m1Value = m1.orElseGet(() -> {
            System.out.println("or else m1");
            return 0;
        });

        Object m2Value = m2.orElseGet(() -> {
            System.out.println("or else m2");
            return 0;
        });

        System.out.println("m1Value = " + m1Value);
        System.out.println("m2Value = " + m2Value);
    }
}
