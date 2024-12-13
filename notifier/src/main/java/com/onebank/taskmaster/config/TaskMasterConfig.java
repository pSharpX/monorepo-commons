package com.onebank.taskmaster.config;

import com.onebank.taskmaster.notifier.config.EnableNotifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;


import java.util.Optional;

@Configuration
@ConditionalOnDatabaseEnabled
@EnableNotifier
public class TaskMasterConfig {
    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> Optional.of("current-user"); // Replace with actual logic
    }
}
