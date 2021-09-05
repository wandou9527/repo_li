package com.wandou.demo.concurrent;

import java.util.concurrent.Semaphore;

/**
 * 信号量
 * tryAcquire消耗一个次数，release是释放一个次数，相当于限流
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        boolean acquireFlag = semaphore.tryAcquire();
        boolean acquireFlag1 = semaphore.tryAcquire(5);
        System.out.println("acquireFlag = " + acquireFlag);
        System.out.println("acquireFlag1 = " + acquireFlag1);

        System.out.println("semaphore = " + semaphore);
    }
}
