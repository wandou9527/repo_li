package com.wandou.service;

/**
 * @author liming
 * @date 2020-04-04
 * @description
 */
public interface UserService {

    /**
     * 完善用户信息 id等 一般用于异步调用 定时任务等
     */
    void perfectUserInfo();

}
