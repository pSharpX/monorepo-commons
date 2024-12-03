package com.onebank.taskmaster.notifier.consumer.email;

import org.springframework.boot.SpringApplication;

public class TestNotifierApplication {

	public static void main(String[] args) {
		SpringApplication.from(EmailNotifierConsumerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
