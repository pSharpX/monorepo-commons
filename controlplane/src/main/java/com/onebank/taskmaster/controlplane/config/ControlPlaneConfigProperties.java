package com.onebank.taskmaster.controlplane.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@ConfigurationProperties(prefix = "control-plane")
@Validated
public class ControlPlaneConfigProperties {
    private Database database;
    private Cache cache;
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
    static class Cache {
        private Boolean enabled = false;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Notification {
        private Boolean enabled = false;
    }
}
