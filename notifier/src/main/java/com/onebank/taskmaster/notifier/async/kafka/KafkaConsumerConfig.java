package com.onebank.taskmaster.notifier.async.kafka;

import com.onebank.taskmaster.notifier.async.ConditionalOnKafkaEnabled;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
@ConditionalOnKafkaEnabled
public class KafkaConsumerConfig {

    @Bean
    @ConfigurationProperties(prefix = "task-master.notification.kafka.consumer")
    public Properties kafkaConsumerProperties() {
        return new Properties();
    }
}
