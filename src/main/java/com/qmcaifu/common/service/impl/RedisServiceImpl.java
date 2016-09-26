package com.qmcaifu.common.service.impl;

import com.alibaba.fastjson.JSON;

import com.qmcaifu.common.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by nihao on 2016/9/19.
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private JedisPool jedisPool;

    public void set(String key, Object value) {
        Jedis res = jedisPool.getResource();
        res.set(key, JSON.toJSONString(value));
        res.close();
    }

    public void set(String key, Object value, int expireSecs) {
        Jedis res = jedisPool.getResource();
        res.set(key, JSON.toJSONString(value));
        res.expire(key, expireSecs);
        res.close();
    }

    public <T> T get(String key, Class<T> clazz) {
        Jedis res = jedisPool.getResource();
        T result = JSON.parseObject(res.get(key), clazz);
        res.close();
        return result;
    }

    public String get(String key) {
        Jedis res = jedisPool.getResource();
        String result = res.get(key);
        res.close();
        return result;
    }

    public Boolean exists(String key) {
        Jedis res = jedisPool.getResource();
        Boolean result = res.exists(key);
        res.close();
        return result;
    }

    public String del(String key) {
        Jedis res = jedisPool.getResource();
        Long result = res.del(key);
        res.close();
        return result+"";
    }

}
