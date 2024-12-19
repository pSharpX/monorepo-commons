package com.onebank.taskmaster.controlplane.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@ConditionalOnDatabaseEnabled
@Import(DataSourceAutoConfiguration.class)
@EnableJpaAuditing
public class ControlPlaneConfig {
    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> Optional.of("current-user"); // Replace with actual logic
    }
}
