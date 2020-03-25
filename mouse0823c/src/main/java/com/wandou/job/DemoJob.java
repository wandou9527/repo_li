//package com.wandou.job;
//
//import com.wandou.constant.CommonConst;
//import com.wandou.constant.NameConst;
//import com.wandou.demo.EventHandler;
//import com.wandou.demo.MyContextEvent;
//import com.wandou.demo.UserRegisterEvent;
//import com.wandou.model.po.UserPO;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.time.DateFormatUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
//import org.springframework.stereotype.Component;
//
//import java.io.UnsupportedEncodingException;
//import java.lang.management.ManagementFactory;
//import java.lang.management.RuntimeMXBean;
//import java.util.Date;
//
///**
// * 2020-01-08
// */
//
//@Slf4j
//@Component
//public class DemoJob {
//
//    ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
//
//    @Autowired
//    private EventHandler eventHandler;
//    @Autowired
//    private ApplicationContext applicationContext;
//
//    @Autowired
//    private NameConst nameConst;
//
//
//    /**
//     * 事件传播测试 观察者模式
//     */
//    @Async("scheduleExecutor")
//    @Scheduled(cron = "0/30 * * * * ?")
//    public void m1() throws UnsupportedEncodingException {
//        // 在没配置自定义线程池时 SimpleAsyncTaskExecutor-26
//        log.info("m1 线程: {}, Thread.activeCount(): {}", Thread.currentThread().getName(), Thread.activeCount());
//
//        String randomJinSwordsman = NameConst.getRandomJinSwordsman();
//        log.info("============ 我的定时任务执行 " + DateFormatUtils.format(new Date(), CommonConst.DATE_FORMAT_PATTERN) + " " + randomJinSwordsman);
//        log.info("我是一只小小鸟");
//
//
//        //1方式 事件发布
//        applicationContext.publishEvent(new MyContextEvent(this,"publish this event .... " + randomJinSwordsman + " 来了"));
//        log.info("1方式 发送完");
//
//
//        //2方式 eventBus方式
//        eventHandler.eventPost();
//        log.info("2方式 发送完");
//
//
//        //3方式 发布UserRegisterEvent事件
//        UserPO user = new UserPO("liming", "123456");
//        applicationContext.publishEvent(new UserRegisterEvent(this, user));
//        log.info("3方式 发送完");
//
//    }
//
//    @Async("scheduleExecutor")
//    @Scheduled(cron = "0/10 * * * * ?")
//    public void m2() {
//        try {
//            for (int i = 0; i < 2; i++) {
//                log.info("方法2 配置的武侠人物, 随机一个: {}", nameConst.getDynamicRandomJinSwordsman());
//            }
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Async("scheduleExecutor")
//    @Scheduled(cron = "0/10 * * * * ?")
//    public void m3() {
//        try {
//            for (int i = 0; i < 2; i++) {
//                log.info("方法3 配置的武侠人物, 随机一个: {}", nameConst.getDynamicRandomJinSwordsman());
//            }
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Async("scheduleExecutor")
//    @Scheduled(cron = "0/10 * * * * ?")
//    public void m4() {
//        try {
//            for (int i = 0; i < 2; i++) {
//                log.info("方法4 配置的武侠人物, 随机一个: {}", nameConst.getDynamicRandomJinSwordsman());
//            }
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Async("scheduleExecutor")
//    @Scheduled(cron = "0/10 * * * * ?")
//    public void m5() {
//        try {
//            for (int i = 0; i < 2; i++) {
//                log.info("方法5 配置的武侠人物, 随机一个: {}", nameConst.getDynamicRandomJinSwordsman());
//            }
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    /**
//     * 获取 pid
//     */
//    @Async("scheduleExecutor")
//    @Scheduled(cron = "0/25 * * * * ?")
//    public void m6() {
//        try {
//            for (int i = 0; i < 2; i++) {
//                log.info("m6");
//                RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
//                String name = runtime.getName(); // format: "pid@hostname"
//                log.info("name: {}", name);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//}
