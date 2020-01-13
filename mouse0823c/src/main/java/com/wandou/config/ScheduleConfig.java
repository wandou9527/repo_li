//package com.wandou.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.SchedulingConfigurer;
//import org.springframework.scheduling.config.ScheduledTaskRegistrar;
//
//import java.util.concurrent.Executors;
//
///**
// * 貌似并没有起效，看日志线程还是listener的线程池，在定时的方法加了@Async里面没加参数
// * 2020-01-09 11:16:30.047  INFO 19872 --- [sync-listener-1] com.wandou.job.DemoJob                   : 3方式 发送完
// */
//
//@Configuration
////所有的定时任务都放在一个线程池中，定时任务启动时使用不同都线程。
//public class ScheduleConfig implements SchedulingConfigurer {
//
//
//    @Override
//    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//        //设定一个长度10的定时任务线程池
//        taskRegistrar.setScheduler(Executors.newScheduledThreadPool(10));
//    }
//}
