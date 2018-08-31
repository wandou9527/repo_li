package com.wandou.util;

import java.util.Random;

/**
 * @author liming
 * @date 2018/8/26 10:53
 * @description
 */
public class GenUtil {
    /**
     * 生产随机码
     *
     * @param num 位数 默认4
     * @return
     */
    public static String genCode(int num) {
        int code;
        switch (num) {
            case 5:
                code = new Random().nextInt(90000) + 10000;
                break;
            case 6:
                code = new Random().nextInt(900000) + 100000;
                break;
            default: //默认4位
                code = new Random().nextInt(9000) + 1000;
                break;
        }
        return String.valueOf(code);
    }
}
