package com.onebank.taskmaster.notifier.config;

import com.onebank.taskmaster.config.ConditionalOnDatabaseEnabled;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@ConditionalOnDatabaseEnabled
@Import(DataSourceAutoConfiguration.class)
@EnableJpaAuditing
public class NotifierConfig {
}
