package com.wandou.test.service;

import com.alibaba.fastjson.JSON;
import com.wandou.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liming
 * @date 2020-05-03
 * @description
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {
    @Autowired
    private OrderService orderService;

    @Test
    public void listTest() {
        Object test = orderService.test();
        System.out.println(JSON.toJSONString(test, true));
    }

}
