package com.onebank.taskmaster.notifier;

import org.springframework.boot.SpringApplication;

public class TestNotifierApplication {

	public static void main(String[] args) {
		SpringApplication.from(TaskMasterNotifierApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
