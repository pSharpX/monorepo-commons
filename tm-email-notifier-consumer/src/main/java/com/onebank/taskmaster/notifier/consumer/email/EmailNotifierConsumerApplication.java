package com.onebank.taskmaster.notifier.consumer.email;

import com.google.cloud.spring.autoconfigure.core.GcpContextAutoConfiguration;
import com.google.cloud.spring.autoconfigure.pubsub.GcpPubSubAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@EnableConfigurationProperties
@SpringBootApplication(exclude = {GcpContextAutoConfiguration.class, GcpPubSubAutoConfiguration.class})
@ComponentScan(basePackages = "com.onebank.taskmaster.config")
public class EmailNotifierConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailNotifierConsumerApplication.class, args);
	}

}
