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
     * @param num 位数
     * @return
     */
    public static String genCode(int num) {
        if (num == 0) {
            num = 4;
        }
        int code = 0;
        switch (num) {
            case 4:
                code = new Random().nextInt(9000) + 1000;
                break;
            default:
                break;
        }
        return String.valueOf(code);
    }
}
