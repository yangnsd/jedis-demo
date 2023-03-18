package com.heima.jedis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * ClassName: JedisConnectionFactory
 * Package: com.heima.jedis.util
 * Description:
 *
 * @Author: yangjingsai
 * @Create: 2023/3/17 - 22:03
 * @Version: v1.0
 */
public class JedisConnectionFactory {
    private static final JedisPool jedisPool;
    static {
        // 配置连接池
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(8);
        jedisPoolConfig.setMaxIdle(8);
        jedisPoolConfig.setMinIdle(0);
        jedisPoolConfig.setMaxWaitMillis(1000);
        // 创建连接池对象
        jedisPool = new JedisPool(jedisPoolConfig,
                "192.168.227.132",6379,1000,"123456");
    }

    public static Jedis getJedis(){
        return jedisPool.getResource();
    }

}
