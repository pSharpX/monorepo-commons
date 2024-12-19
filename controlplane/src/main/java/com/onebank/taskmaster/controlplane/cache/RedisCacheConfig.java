package com.onebank.taskmaster.controlplane.cache;

import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ConditionalOnRedisEnabled
@Import(CacheAutoConfiguration.class)
@EnableCaching
public class RedisCacheConfig {
}
