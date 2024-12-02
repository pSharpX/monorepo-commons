package com.onebank.taskmaster.config;

import com.onebank.taskmaster.controlplane.config.EnableControlPlane;
import com.onebank.taskmaster.notifier.config.EnableNotifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@ConditionalOnDatabaseEnabled
@EnableControlPlane
@EnableNotifier
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class TaskMasterConfig {
    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> Optional.of("current-user"); // Replace with actual logic
    }
}
