package com.onebank.taskmaster.controlplane.config;

import jakarta.validation.constraints.NotEmpty;
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

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Database {
        private Boolean enabled = false;
        @NotEmpty
        private String defaultTenant;
    }
}
