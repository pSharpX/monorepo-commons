package com.onebank.taskmaster.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@ConfigurationProperties(prefix = "task-master")
@Validated
public class TaskMasterConfigProperties {
    private Database database;
    private Notification notification;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Database {
        private Boolean enabled = false;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Notification {
        private Boolean enabled = false;
        private String engine;
    }
}
