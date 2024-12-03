package com.onebank.taskmaster.notifier.consumer.sms;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class SmsNotifierConsumerApplicationTests {

	@Test
	void contextLoads() {
	}

}
