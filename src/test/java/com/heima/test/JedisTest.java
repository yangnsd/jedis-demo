package com.heima.test;

import com.heima.jedis.util.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * ClassName: JedisTest
 * Package: com.heima.test
 * Description:
 *
 * @Author: yangjingsai
 * @Create: 2023/3/17 - 21:46
 * @Version: v1.0
 */
public class JedisTest {

    private Jedis jedis;

    @BeforeEach
    void setUp() {
        //1.建立连接
        /*jedis = new Jedis("192.168.227.132",6379);
        //2.设置密码
        jedis.auth("123456");*/
        jedis = JedisConnectionFactory.getJedis();
        //3.选择库
        jedis.select(0);
    }
    
    @Test
    void testString(){
        // 存入数据
        String result = jedis.set("name", "胡歌");
        System.out.println("result = " + result);
        // 获取数据
        String name = jedis.get("name");
        System.out.println("name = " + name);
    }
    
    @Test
    public void testHash(){
        // 插入hash数据
        jedis.hset("user:1","name","Jack");
        jedis.hset("user:1","age","21");
        //获取
        Map<String, String> stringStringMap = jedis.hgetAll("user:1");
        System.out.println(stringStringMap);
    }

    @AfterEach
    void tearDown() {
        if(jedis != null){
            jedis.close();
        }
    }
}
