package com.onebank.taskmaster.controlplane.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ConditionalOnDatabaseEnabled
@ComponentScan(basePackages = "com.onebank.taskmaster.controlplane", includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = OnDatabaseIntegration.class))
public class ControlPlaneConfig {
}
