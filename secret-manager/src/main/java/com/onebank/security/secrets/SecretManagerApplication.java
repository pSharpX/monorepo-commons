package com.onebank.security.secrets;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@OpenAPIDefinition(servers = {@Server(url = "/")})
@EnableConfigurationProperties
@SpringBootApplication
public class SecretManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecretManagerApplication.class, args);
	}

}
