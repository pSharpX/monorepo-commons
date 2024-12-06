package com.onebank.taskmaster.config;

import com.onebank.taskmaster.notifier.config.EnableNotifier;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnNotificationEnabled
@EnableNotifier
public class TaskMasterConfig {
}
