package com.onebank.taskmaster.notifier.consumer.email;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class EmailNotifierConsumerApplicationTests {

	@Test
	void contextLoads() {
	}

}
