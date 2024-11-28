package com.onebank.taskmaster.controlplane.config;

import com.onebank.taskmaster.controlplane.model.AppIdentifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@OnDatabaseIntegration
@EnableJpaRepositories(basePackages = "com.onebank.taskmaster.controlplane")
@EnableJpaAuditing
public class ControlPlaneDataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "task-master.datasource.control-plane-1")
    public DataSourceProperties controlPlane01DataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "task-master.datasource.control-plane-2")
    public DataSourceProperties controlPlane02DataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource controlPlaneDataSource(DataSourceProperties controlPlane01DataSourceProperties, DataSourceProperties controlPlane02DataSourceProperties) {
        AbstractRoutingDataSource routingDataSource = new TenantRoutingDataSource();

        Map<Object, Object> dataSources = new HashMap<>();
        DataSource controlPlane01DataSource = controlPlane01DataSourceProperties.initializeDataSourceBuilder().build();
        DataSource controlPlane02DataSource = controlPlane02DataSourceProperties.initializeDataSourceBuilder().build();
        dataSources.put(AppIdentifier.CONTROL_PLANE_1, controlPlane01DataSource);
        dataSources.put(AppIdentifier.CONTROL_PLANE_2, controlPlane02DataSource);

        routingDataSource.setDefaultTargetDataSource(controlPlane01DataSource);
        routingDataSource.setTargetDataSources(dataSources);

        routingDataSource.afterPropertiesSet();
        return routingDataSource;
    }
}
