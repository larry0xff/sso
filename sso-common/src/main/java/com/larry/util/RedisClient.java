package com.larry.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Redis客户端
 */
@Component
public class RedisClient {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    private static RedisClient redisClient;

    @PostConstruct
    public void init() {
        redisClient = this;
        redisClient.setRedisTemplate(redisTemplate);
    }

    /**
     * get方法
     * @param key
     * @return
     */
    public static Object get(String key) {
        return key == null ? null : redisClient.redisTemplate.opsForValue().get(key);
    }

    /**
     * set方法
     * @param key
     * @param value
     * @return
     */
    public static boolean set(String key, Object value) {
        try {
            redisClient.redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
