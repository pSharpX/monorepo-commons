package com.onebank.taskmaster.notifier;

import com.onebank.taskmaster.consumer.EmailNotifierConsumerApplication;
import org.springframework.boot.SpringApplication;

public class TestNotifierApplication {

	public static void main(String[] args) {
		SpringApplication.from(EmailNotifierConsumerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
