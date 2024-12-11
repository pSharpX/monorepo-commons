package com.onebank.taskmaster.notifier.consumer.service;

import com.onebank.taskmaster.notifier.config.ConditionalOnPubSubEnabled;
import com.onebank.taskmaster.notifier.model.senders.NotificationMessage;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@ConditionalOnPubSubEnabled
@Slf4j
public class PubSubNotificationMessageListener implements NotificationMessageListener {
    private final NotificationMessageConsumer notificationMessageSender;

    @Override
    public void listen(@NonNull NotificationMessage message) {
        log.debug("Receiving notification message with id =[{}], channel = [{}], type = [{}]", message.getId(), message.getChannel().getName(), message.getType().getName());
        notificationMessageSender.send(message);
    }
}
