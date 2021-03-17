package com.yp.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author yipeng
 * @Date 2021/3/17 11:23
 * @Version 1.0
 * @Desc
 */
@ConditionalOnClass(Redisson.class)
@EnableConfigurationProperties(RedissonProperties.class)
@Configuration
public class RedissonAutoConfiguration {

    @Bean
    RedissonClient redissonClient(RedissonProperties redissonProperties) {
        Config config = new Config();
        String prefix = "redis://";
        if (redissonProperties.isSsl()) {
            prefix = "rediss://";
        }

        config.useSingleServer()
                .setAddress(prefix + redissonProperties.getHost() + ":" + redissonProperties.getPort())
                .setPassword(redissonProperties.getPassword())
                .setConnectTimeout(redissonProperties.getTimeout());

        return Redisson.create(config);
    }
}
