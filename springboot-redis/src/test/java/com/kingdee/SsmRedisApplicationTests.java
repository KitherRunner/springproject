package com.kingdee;

import com.kingdee.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SsmRedisApplicationTests {

    /**
     * 操作字符串类型数据的redisTemplate
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 操作key-value的redisTemplate
     */
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * key-avlue的序列化策略为json的redisTemplate
     */
    @Autowired
    private RedisTemplate userRedisTemplate;

    @Test
    public void testUserRedisTemplate() {
        /**
         * 保存对象(使用json序列化对象)
         */
        userRedisTemplate.opsForValue().set("user", new User(1, "张三", "zs123", 1));
    }

    @Test
    public void contextLoads() {
        /**
         * 操作字符串
         */
        // 追加
        //  stringRedisTemplate.opsForValue().append("username","张三");
        //  String username = stringRedisTemplate.opsForValue().get("username");
        //  System.out.println(username);

        // 删除
        // stringRedisTemplate.opsForValue().getOperations().delete("username");

        /**
         * 操作list
         */
        stringRedisTemplate.opsForList().leftPush("names", "张三");
        // 0 ~ -1：表示查询所有
        List<String> names = stringRedisTemplate.opsForList().range("names", 0, -1);
        System.out.println(names);
    }
}

