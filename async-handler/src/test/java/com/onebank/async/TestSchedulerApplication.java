package com.onebank.async;

import org.springframework.boot.SpringApplication;

public class TestSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.from(AsyncHandlerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
