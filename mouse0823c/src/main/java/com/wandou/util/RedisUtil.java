package com.wandou.util;

import com.wandou.constant.RedisConst;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author liming
 * @date 2020-04-04 周六
 */

@Component
public class RedisUtil {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

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
                RandomUtils.nextLong(11L, 21L));
        return increment;
    }

    public long getUserIdByToken(String token) {
        Object value = redisTemplate.opsForValue().get(RedisConst.TOKEN_KEY + token);
        if (value == null) {
            return 0L;
        }
        return NumberUtils.toLong(value.toString());
    }

    public void set(String key, Object value, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }


}
