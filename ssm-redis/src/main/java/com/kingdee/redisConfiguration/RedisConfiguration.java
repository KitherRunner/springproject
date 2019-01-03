package com.kingdee.redisConfiguration;

import com.kingdee.bean.Employee;
import com.kingdee.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
public class RedisConfiguration {

    private Duration duration = Duration.ZERO;

    /**
     * 自定义redis的key-value的序列化方式
     *
     * @return
     */
    @Bean
    public RedisTemplate<Object, User> userRedisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Object, User> redisTemplate = new RedisTemplate<>();
        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(User.class);
        redisTemplate.setDefaultSerializer(serializer);
        // 必须设置
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }

    /**
     * 自定义cacheManager,使用不同的cacheManager操作不同的javaBean,对不同的javaBean使用不同的序列化方式
     * <p>
     * 出现多个cacheManager时，需要指定一个默认的cacheManager
     *
     * @param connectionFactory
     * @return
     */
    @Bean
    // 指定优先(默认)
    @Primary
    public RedisCacheManager userCacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheConfiguration cacheConfig = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(duration)
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new Jackson2JsonRedisSerializer(User.class)))
                .disableCachingNullValues();
        RedisCacheManager redisCacheManager = RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(cacheConfig).build();
        return redisCacheManager;
    }

    /**
     * 自定义操作Employee对象的cacheManager
     */
    public RedisCacheManager employeeCacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig().entryTtl(duration)
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new Jackson2JsonRedisSerializer(Employee.class)))
                .disableCachingNullValues();
        RedisCacheManager redisCacheManager = RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(config).build();
        return redisCacheManager;
    }
}
