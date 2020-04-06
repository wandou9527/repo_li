package com.wandou.test;

import com.wandou.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liming
 * @date 2020-04-04
 * @description
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisUtil redisUtil;


    @Test
    public void m1() {
        Long aLong = redisUtil.randomIncId();
        System.out.println("aLong = " + aLong);
    }



}
