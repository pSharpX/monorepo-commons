package com.onebank.taskmaster.controlplane.cache;

import com.onebank.taskmaster.controlplane.service.SearchTask;
import com.onebank.taskmaster.controlplane.service.SearchTaskFacade;
import com.onebank.taskmaster.controlplane.service.SearchTaskFacadeService;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

@Configuration
@ConditionalOnRedisEnabled
@Import(CacheAutoConfiguration.class)
@EnableCaching
public class RedisCacheConfig {
    @Bean
    @Primary
    public SearchTaskFacade searchCachedTaskService(SearchTask searchTask) {
        return new SearchTaskFacadeService(searchTask);
    }
}
