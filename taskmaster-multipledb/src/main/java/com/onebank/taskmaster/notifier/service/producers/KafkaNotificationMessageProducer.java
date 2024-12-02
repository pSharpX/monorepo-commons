package com.onebank.taskmaster.notifier.service.producers;

import com.onebank.taskmaster.notifier.async.ConditionalOnKafkaEnabled;
import com.onebank.taskmaster.notifier.model.AbstractMessage;
import com.onebank.taskmaster.notifier.model.senders.NotificationMessage;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.Properties;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
@ConditionalOnKafkaEnabled
public class KafkaNotificationMessageProducer implements NotificationMessageProducer {
    private final KafkaTemplate<String, AbstractMessage> kafkaTemplate;
    @Qualifier("kafkaProperties")
    private final Properties kafkaProperties;

    @Override
    public void sendMessage(@NonNull NotificationMessage notification) {
        CompletableFuture<SendResult<String, AbstractMessage>> future = kafkaTemplate.send(kafkaProperties.getProperty("topic"), notification);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.debug("Sent message=[{}] with offset=[{}]", notification, result.getRecordMetadata().offset());
            } else {
                log.debug("Unable to send message=[{}] due to : {}", notification, ex.getMessage());
            }
        });
    }
}
