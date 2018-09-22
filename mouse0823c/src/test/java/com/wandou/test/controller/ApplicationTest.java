package com.wandou.test.controller;

import com.wandou.Mouse0823cApplication;
import com.wandou.controller.C2Controller;
import com.wandou.controller.IndexController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liming
 * @date 2018/9/22 17:49
 * @description
 */
//@SpringBootTest(classes = CoinServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK, properties = "eureka.client.enabled=true")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Mouse0823cApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class ApplicationTest {

    @Autowired
    private C2Controller c2Controller;
    @Autowired
    private IndexController indexController;

    @Test
    public void test1() {
        String praise = c2Controller.praise(null);
        System.out.println(praise);
    }

    @Test
    public void test2() {
        String s = indexController.m2();
        System.out.println(s);
    }

}
