package com.wandou.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liming
 * @date 2018/8/25 17:40
 * @description
 */
public class StringTest {

    private String a = "{\"firstOrderNo\":\"123nnn\", \"uuu\":\"vvv\"}";

    /**
     * char 转 int
     */
    @Test
    public void m1() {
        System.out.println();
        String str = "你好";
        for (int i = 0; i < str.length(); i++) {
            System.out.println((int) str.charAt(i));
        }
    }

    @Test
    public void m2() {
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalTime time = LocalTime.parse("23:00:01");
        System.out.println("time = " + time);

        Map<String, LocalTime> map = new HashMap<>();
        map.put("start", localTime);
        map.put("end", time);
        String jsonStr = JSON.toJSONString(map);
        System.out.println("jsonStr = " + jsonStr);
    }
}
