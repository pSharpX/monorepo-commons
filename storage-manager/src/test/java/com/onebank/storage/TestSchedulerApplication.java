package com.onebank.storage;

import org.springframework.boot.SpringApplication;

public class TestSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.from(StorageManagerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
