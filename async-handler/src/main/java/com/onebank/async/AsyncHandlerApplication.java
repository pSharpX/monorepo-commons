package com.onebank.async;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@OpenAPIDefinition(servers = {@Server(url = "/")})
@EnableConfigurationProperties
@SpringBootApplication
public class AsyncHandlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsyncHandlerApplication.class, args);
	}

}
