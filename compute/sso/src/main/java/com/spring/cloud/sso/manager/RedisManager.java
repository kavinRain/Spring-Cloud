package com.spring.cloud.sso.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/6/3.
 */
@Component
public class RedisManager {

    @Autowired
    private StringRedisTemplate template;



}
