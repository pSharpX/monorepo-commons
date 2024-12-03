package com.onebank.taskmaster.notifier.consumer.sms;

import com.onebank.taskmaster.consumer.sms.SmsNotifierConsumerApplication;
import org.springframework.boot.SpringApplication;

public class TestNotifierApplication {

	public static void main(String[] args) {
		SpringApplication.from(SmsNotifierConsumerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
