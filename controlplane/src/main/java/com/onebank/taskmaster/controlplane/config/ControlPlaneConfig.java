package com.onebank.taskmaster.controlplane.config;

import com.onebank.taskmaster.controlplane.converter.CreateTaskRequestConverter;
import com.onebank.taskmaster.controlplane.repository.TaskRepository;
import com.onebank.taskmaster.controlplane.service.CreatePersistentTaskService;
import com.onebank.taskmaster.controlplane.service.CreateTask;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

@Configuration
@ConditionalOnDatabaseEnabled
@Import(DataSourceAutoConfiguration.class)
public class ControlPlaneConfig {
    @Bean
    @Primary
    public CreateTask createPersistentTaskService(TaskRepository taskRepository, CreateTaskRequestConverter converter) {
        return new CreatePersistentTaskService(taskRepository, converter);
    }
}
