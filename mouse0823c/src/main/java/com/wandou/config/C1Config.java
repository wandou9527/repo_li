package com.wandou.config;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.RejectedExecutionException;

/**
 * @author liming
 * @date 2018/8/28 15:43
 * @description
 */
@Component
public class C1Config {
    /**
     * 异步执行线程池
     *
     * @return
     */
    @Bean(name = "futureTaskExecutor")
    public ThreadPoolTaskExecutor futureTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setAllowCoreThreadTimeOut(true);
        executor.setCorePoolSize(40);
        executor.setKeepAliveSeconds(900);
        executor.setMaxPoolSize(1000);
        executor.setQueueCapacity(100);
        executor.setAwaitTerminationSeconds(3);
        executor.setRejectedExecutionHandler((r, e) -> {
            new RejectedExecutionException("当前线程已满，请稍后重试");
        });
        return executor;
    }
}
