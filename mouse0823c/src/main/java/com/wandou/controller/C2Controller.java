package com.wandou.controller;

import com.wandou.service.C2Service;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

//import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * @author liming
 * @date 2018/8/24 15:53
 * @description 接口的 Controller
 */
@RestController
@RequestMapping("/c2")
public class C2Controller {
    private static final long LOVE_START_TIME = 1493740800000L;//20170503
    private static final int DAYS_PER_YEAR = 365;
    private static final int DAYS_PER_MONTH = 30;

    @Autowired
    private C2Service c2Service;

    private static final Logger logger = LoggerFactory.getLogger(C2Controller.class);


    @GetMapping
    public String m1() {
        return "这是个接口，返回json " + DateFormatUtils.format(new Date(), "yyyy-MM-dd");
    }

    //我跟老婆相爱多久年月日时分秒
    @RequestMapping("/love_time")
    public String loveTime() {
        long time = System.currentTimeMillis() - LOVE_START_TIME;

        long year = time / (DateUtils.MILLIS_PER_DAY * DAYS_PER_YEAR);
        time = time - (DateUtils.MILLIS_PER_DAY * DAYS_PER_YEAR * year);

        long month = time / (DateUtils.MILLIS_PER_DAY * DAYS_PER_MONTH);
        time = time - (DateUtils.MILLIS_PER_DAY * DAYS_PER_MONTH * month);

        long day = time / DateUtils.MILLIS_PER_DAY;
        time = time - (DateUtils.MILLIS_PER_DAY * day);

        long hour = time / DateUtils.MILLIS_PER_HOUR;
        time = time - (DateUtils.MILLIS_PER_HOUR * hour);

        long minute = time / DateUtils.MILLIS_PER_MINUTE;
        time = time - (DateUtils.MILLIS_PER_MINUTE * minute);

        long second = time / DateUtils.MILLIS_PER_SECOND;
        time = time - (DateUtils.MILLIS_PER_SECOND * second);//剩余的为毫秒 millisecond
        long millis = time;

        StringBuffer sb = new StringBuffer("<h1>美丽的我！</h1>");
        sb.append("<font color = \"pink\">我们已经相爱</font> ")
                .append(strong(year))
                .append("年")
                .append(strong(month))
                .append("个月")
                .append(strong(day))
                .append("天")
                .append(strong(hour))
                .append("小时")
                .append(strong(minute))
                .append("分钟")
                .append(strong(second))
                .append("秒")
                .append(strong(millis))
                .append("毫秒");

        return sb.toString();

    }

    /**
     * 将内容加粗
     */
    private String strong(String str) {
        StringBuffer stringBuffer = new StringBuffer("<b>");
        stringBuffer.append(str).append("</b>");
        return stringBuffer.toString();
    }

    /**
     * 将内容加粗
     *
     * @param number
     * @return
     */
    private String strong(Number number) {
        return strong(number.toString());
    }

    /**
     * 赞美
     *
     * @param name
     * @return
     */
    @RequestMapping("/paris")
    public String praise(@RequestParam(name = "name", required = false) String name) {
        logger.info("请求赞美 paris，参数：name：{}", name);
        String paris = c2Service.paris(name);
        logger.info("请求赞美 paris，返回值：{}", paris);
        return paris;
    }

}
