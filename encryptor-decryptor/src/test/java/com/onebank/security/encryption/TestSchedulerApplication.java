package com.onebank.security.encryption;

import org.springframework.boot.SpringApplication;

public class TestSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.from(EncryptionApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
