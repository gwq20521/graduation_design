/**
 * 版权所有, 
 * Author: 郭 荣誉出品
 * copyright: 2018
 */
package com.design.graduation.util;

import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;

/**
 * @className: com.design.graduation.util.RedisCache
 * @description: TODO - 
 * @author: 郭伟强   E-mail:gwq20521@163.com
 * @createTime: 2018年3月9日 下午12:19:40 
 * @version: v 1.0
 * @since 
 *
 */
@Component("redisCache")
public class RedisCache {
    private int port = 6379;

    private String host = "127.0.0.1";

    private Jedis jedis = new Jedis(this.host, this.port);

    private int expiretime = 1800;

    public String cache(String key, String value) {
        String result = this.jedis.set(key, value);
        this.jedis.expire(key, this.expiretime);
        return result;
    }

    public String get(String key) {
        this.jedis.expire(key, this.expiretime);
        return this.jedis.get(key);
    }

    public static void main(String[] args) {
    }
}
