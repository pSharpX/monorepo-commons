package com.onebank.taskmaster.controlplane.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnNotificationEnabled
@EnableFeignClients(basePackages = "com.onebank.taskmaster.controlplane.provider")
public class NotificationConfig {
}
