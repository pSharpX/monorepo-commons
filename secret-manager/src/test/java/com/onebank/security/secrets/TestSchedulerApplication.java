package com.onebank.security.secrets;

import org.springframework.boot.SpringApplication;

public class TestSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.from(SecretManagerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
