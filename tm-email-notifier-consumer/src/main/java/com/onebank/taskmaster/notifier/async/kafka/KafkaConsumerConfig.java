package com.onebank.taskmaster.notifier.async.kafka;

import com.onebank.taskmaster.helpers.StreamUtils;
import com.onebank.taskmaster.notifier.config.ConditionalOnKafkaEnabled;
import com.onebank.taskmaster.notifier.model.NotificationChannel;
import com.onebank.taskmaster.notifier.model.senders.NotificationMessage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.Properties;

@Configuration
@ConditionalOnKafkaEnabled
@EnableKafka
public class KafkaConsumerConfig {

    @Bean
    @ConfigurationProperties(prefix = "task-master.notification.kafka.consumer")
    public Properties kafkaConsumerProperties() {
        return new Properties();
    }

    @Bean
    public ConsumerFactory<String, NotificationMessage> consumerFactory(@Qualifier("kafkaConsumerProperties") Properties kafkaConsumerProperties) {
        return new DefaultKafkaConsumerFactory<>(StreamUtils.streamConvert(kafkaConsumerProperties));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, NotificationMessage> kafkaListenerContainerFactory(ConsumerFactory<String, NotificationMessage> consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<String, NotificationMessage> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        factory.setRecordFilterStrategy(consumerRecord -> NotificationChannel.EMAIL.equals(consumerRecord.value().getChannel()));
        return factory;
    }
}