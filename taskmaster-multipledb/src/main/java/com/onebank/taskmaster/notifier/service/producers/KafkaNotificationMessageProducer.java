package com.onebank.taskmaster.notifier.service.producers;

import com.onebank.taskmaster.notifier.model.senders.NotificationMessage;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.Properties;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaNotificationMessageProducer implements NotificationMessageProducer {
    private final KafkaTemplate<String, NotificationMessage> kafkaTemplate;
    private final Properties kafkaProperties;

    @Override
    public void sendMessage(@NonNull NotificationMessage notification) {
        CompletableFuture<SendResult<String, NotificationMessage>> future = kafkaTemplate.send(kafkaProperties.getProperty("topic"), notification);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.debug("Sent message=[{}] with offset=[{}]", notification, result.getRecordMetadata().offset());
            } else {
                log.debug("Unable to send message=[{}] due to : {}", notification, ex.getMessage());
            }
        });
    }
}
