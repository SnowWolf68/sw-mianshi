package com.snwolf.mianshi;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author <a href="https://github.com/SnowWolf68">SnowWolf68</a>
 * @Version: V1.0
 * @Date: 11/25/2024
 * @Description: 测试Redis
 */
@SpringBootTest
@Slf4j
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testSet(){
        stringRedisTemplate.opsForValue().set("zhangsan", "aaa");
    }

    @Test
    public void testGet(){
        String str = stringRedisTemplate.opsForValue().get("zhangsan");
        log.info(str);
    }
}
