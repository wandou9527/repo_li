package com.wandou.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author liming
 * @date 2020-03-29
 * @description
 */
public class DateUtil {

    public static Date getStartTimeOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();

    }
}
