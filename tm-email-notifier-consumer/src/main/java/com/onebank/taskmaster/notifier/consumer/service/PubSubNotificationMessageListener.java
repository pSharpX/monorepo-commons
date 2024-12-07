package com.onebank.taskmaster.notifier.consumer.service;

import com.onebank.taskmaster.notifier.config.ConditionalOnPubSubEnabled;
import com.onebank.taskmaster.notifier.model.senders.NotificationMessage;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@ConditionalOnPubSubEnabled
public class PubSubNotificationMessageListener implements NotificationMessageListener {
    @Override
    public void listen(@NonNull NotificationMessage message) {
        throw new UnsupportedOperationException();
    }
}
