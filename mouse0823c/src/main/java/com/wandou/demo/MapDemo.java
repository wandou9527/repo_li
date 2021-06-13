package com.wandou.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liming
 * @date 2021/5/4
 * @description
 */
public class MapDemo {

    public static void main(String[] args) {
        foreach();
    }

    public static void foreach() {
        Map<String, String> map = new HashMap<>();
        map.put("liming", "李明");
        map.put("liyanhong", "李彦宏");
        map.put("lixunhuan", "李寻欢");

        map.forEach((k, v) -> {
            System.out.print(k + " ");
            System.out.print(v + " ");
            if ("lixunhuan".equals(k)) {
                System.out.print("小李飞刀");
            }
            System.out.println();
        });

    }
}
