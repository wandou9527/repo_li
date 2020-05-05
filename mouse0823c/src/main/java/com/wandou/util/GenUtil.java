package com.wandou.util;

import com.wandou.common.BizException;
import com.wandou.enumeration.ReturnCodeEnum;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author liming
 * @date 2018/8/26 10:53
 * @description
 */

@Component
public class GenUtil {
    @Autowired
    private RedisUtil redisUtil;

    public static final String ORDER_NO_PREFIX = "11";
    public static final String SKU_PREFIX = "12";


    /**
     * 生产随机码
     *
     * @param num 位数 默认4
     * @return
     */
    public static String genCode(int num) {
        int code;
        switch (num) {
            case 4:
                code = new Random().nextInt(9000) + 1000;
                break;
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

    /**
     * 生成商品sku
     *
     * @return sku
     */
    public Long genSkuNo() {
        Long randomIncId = redisUtil.randomIncId();
        long skuNo = NumberUtils.toLong(SKU_PREFIX + randomIncId);
        if (skuNo <= 0) {
            throw new BizException(ReturnCodeEnum.ERROR);
        }
        return skuNo;
    }
}
