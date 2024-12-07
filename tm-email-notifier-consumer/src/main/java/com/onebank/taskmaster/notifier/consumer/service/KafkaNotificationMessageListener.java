package com.onebank.taskmaster.notifier.consumer.service;

import com.onebank.taskmaster.notifier.config.ConditionalOnKafkaEnabled;
import com.onebank.taskmaster.notifier.model.senders.NotificationMessage;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@ConditionalOnKafkaEnabled
@Slf4j
public class KafkaNotificationMessageListener implements NotificationMessageListener {
    private final NotificationMessageConsumer notificationMessageSender;

    @Override
    @KafkaListener(id = "onebank-taskmaster-notifications", topics = "${task-master.notification.kafka.consumer.topic}")
    public void listen(@NonNull NotificationMessage message) {
        log.debug("Receiving notification message with id =[{}], channel = [{}], type = [{}]", message.getId(), message.getChannel().getName(), message.getType().getName());
        notificationMessageSender.send(message);
    }
}
