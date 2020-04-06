package com.wandou.demo;

import com.wandou.model.po.UserPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 2020-01-08
 * 3方式
 * https://segmentfault.com/a/1190000011433514?utm_source=tag-newest
 */

@Slf4j
@Component
public class RegisterListener implements ApplicationListener<UserRegisterEvent> {
    /**
     * 实现监听
     *
     * @param userRegisterEvent
     */
    @Async
    @Override
    public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {
        //获取注册用户对象
        UserPO user = userRegisterEvent.getUser();

        //../省略逻辑

        //输出注册用户信息
        System.out.println("注册信息，用户名：" + user.getUsername() + "，密码：" + user.getPassword());
        log.info("3方式，收到注册信息，用户名：" + user.getUsername() + "，密码：" + user.getPassword());
        //不加@Async情况下，此处异常影响生产者后续代码
        throw new RuntimeException("3方式接收处异常");

    }
}
