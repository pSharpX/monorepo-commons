package com.onebank.taskmaster.controlplane;

import com.onebank.taskmaster.controlplane.config.OnDatabaseIntegration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@OpenAPIDefinition(servers = {@Server(url = "/")})
@EnableConfigurationProperties
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "com.onebank.taskmaster.controlplane", excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = OnDatabaseIntegration.class))
public class ControlPlaneApplication {
	public static void main(String[] args) {
		SpringApplication.run(ControlPlaneApplication.class, args);
	}
}
