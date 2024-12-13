package com.onebank.taskmaster.notifier.async.kafka;

import com.onebank.taskmaster.helpers.StreamUtils;
import com.onebank.taskmaster.notifier.async.ConditionalOnKafkaEnabled;
import com.onebank.taskmaster.notifier.model.AbstractMessage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;
import java.util.Properties;

@Configuration
@ConditionalOnKafkaEnabled
public class KafkaProducerConfig {

    @Bean(name = "kafkaProducerProperties")
    @ConfigurationProperties(prefix = "task-master.notification.kafka.producer")
    public Properties kafkaProducerProperties() {
        return new Properties();
    }

    @Bean(name = "producerFactory")
    public ProducerFactory<String, AbstractMessage> producerFactory(@Qualifier("kafkaProducerProperties") Properties kafkaProducerProperties) {
        Map<String, Object> configProps = StreamUtils.streamConvert(kafkaProducerProperties);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, AbstractMessage> kafkaTemplate(@Qualifier("producerFactory") ProducerFactory<String, AbstractMessage> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }
}
