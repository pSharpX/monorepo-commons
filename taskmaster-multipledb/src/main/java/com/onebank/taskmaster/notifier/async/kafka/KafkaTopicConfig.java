package com.onebank.taskmaster.notifier.async.kafka;

import com.onebank.taskmaster.helpers.StreamUtils;
import com.onebank.taskmaster.notifier.async.ConditionalOnKafkaEnabled;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.Map;
import java.util.Properties;

@Configuration
@ConditionalOnKafkaEnabled
public class KafkaTopicConfig {

    @Bean(name = "kafkaProperties")
    @ConfigurationProperties(prefix = "task-master.notification.kafka")
    public Properties kafkaProperties() {
        return new Properties();
    }

    @Bean
    @KafkaProvisioningEnabled
    public KafkaAdmin kafkaAdmin(@Qualifier("kafkaProperties") Properties kafkaProperties) {
        Map<String, Object> configProps = StreamUtils.streamConvert(kafkaProperties);
        return new KafkaAdmin(configProps);
    }

    @Bean
    @KafkaProvisioningEnabled
    public NewTopic defaultTaskMasterNotificationTopic(@Qualifier("kafkaProperties") Properties kafkaProperties) {
        return new NewTopic(kafkaProperties.getProperty("topic"), 1, (short) 1);
    }
}
