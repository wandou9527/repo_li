package com.wandou.util;

import com.wandou.constant.RedisConst;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author liming
 * @date 2020-04-04 周六
 */

@Component
public class RedisUtil {
    @Autowired
    private RedisTemplate redisTemplate;

    public Long increment(String key, long delta) {
        Long increment = redisTemplate.opsForValue().increment(key, delta);
        return increment;
    }


    /**
     * 获取随机有序的id
     *
     * @return
     */
    public Long randomIncId() {
        Long increment = redisTemplate.opsForValue().increment(RedisConst.RANDOM_INC_ID_KEY,
                RandomUtils.nextLong(5L, 11L));
        return increment;
    }


}
