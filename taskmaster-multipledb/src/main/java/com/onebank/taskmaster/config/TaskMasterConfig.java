package com.onebank.taskmaster.config;

import com.onebank.taskmaster.controlplane.config.EnableControlPlane;
import com.onebank.taskmaster.notifier.config.EnableNotifier;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnDatabaseEnabled
@EnableControlPlane
@EnableNotifier
public class TaskMasterConfig {
}