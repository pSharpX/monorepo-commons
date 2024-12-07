package com.onebank.taskmaster.config;

import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnNotificationEnabled
@EnableNotifier
public class TaskMasterConfig {
}
