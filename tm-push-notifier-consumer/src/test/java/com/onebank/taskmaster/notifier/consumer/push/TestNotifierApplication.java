package com.onebank.taskmaster.notifier.consumer.push;

import org.springframework.boot.SpringApplication;

public class TestNotifierApplication {

	public static void main(String[] args) {
		SpringApplication.from(PushNotifierConsumerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
