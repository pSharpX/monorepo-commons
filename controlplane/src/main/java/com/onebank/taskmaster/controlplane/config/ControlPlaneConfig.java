package com.onebank.taskmaster.controlplane.config;

import com.onebank.taskmaster.controlplane.converter.CreateTaskRequestConverter;
import com.onebank.taskmaster.controlplane.converter.TaskDetailsConverter;
import com.onebank.taskmaster.controlplane.repository.TagRepository;
import com.onebank.taskmaster.controlplane.repository.TaskRepository;
import com.onebank.taskmaster.controlplane.service.*;
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
    public CreateTask createPersistentTaskService(TaskRepository taskRepository, TagRepository tagRepository, CreateTaskRequestConverter converter) {
        return new CreatePersistentTaskService(taskRepository, tagRepository, converter);
    }

    @Bean
    @Primary
    public SearchTask searchPersistentTaskService(TaskRepository taskRepository, TaskDetailsConverter converter) {
        return new SearchPersistentTaskService(taskRepository, converter);
    }
}
