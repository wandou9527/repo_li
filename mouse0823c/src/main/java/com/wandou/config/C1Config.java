package com.wandou.config;

import org.greenrobot.eventbus.EventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/**
 * @author liming
 * @date 2018/8/28 15:43
 * @description
 */
@Component
public class C1Config {
    /**
     * 通用异步执行线程池
     *
     * @return
     */
    @Bean(name = "cPool")
    public Executor futureTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setAllowCoreThreadTimeOut(true);
        executor.setCorePoolSize(40);
        executor.setKeepAliveSeconds(900);
        executor.setMaxPoolSize(1000);
        executor.setQueueCapacity(100);
        executor.setAwaitTerminationSeconds(3);
//        executor.setThreadNamePrefix("cPool");
        executor.setRejectedExecutionHandler((r, e) -> {
            new RejectedExecutionException("当前线程已满，请稍后重试");
        });
        return executor;
    }

    /**
     * 定时任务线程池
     *
     * @return
     */
    @Bean(name = "scheduleExecutor")//名字会在日志里显示
    public ThreadPoolTaskExecutor scheduleExecutor() {
//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setAllowCoreThreadTimeOut(true);
        executor.setCorePoolSize(10);
        executor.setKeepAliveSeconds(900);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(10000);
        executor.setAwaitTerminationSeconds(3);
//        executor.setThreadNamePrefix("schedule-");
        executor.setRejectedExecutionHandler((r, e) -> {
            new RejectedExecutionException("当前线程已满，请稍后重试");
        });
        return executor;
    }

    /**
     * 三方jar eventBus
     *
     * @return
     */
    @Bean
    public EventBus eventBus(){
        return new EventBus();
    }

//    @Bean
//    public AnnotationConfigApplicationContext annotationConfigApplicationContext() {
//        //获取IOC容器
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        //注册监听者
//        context.register(MyContextListener.class);
//        //刷新容器
//        context.refresh();
//        return context;
//    }

}
