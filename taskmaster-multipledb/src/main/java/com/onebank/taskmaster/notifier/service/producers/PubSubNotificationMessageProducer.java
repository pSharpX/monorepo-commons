package com.onebank.taskmaster.notifier.service.producers;

import com.onebank.taskmaster.notifier.model.senders.NotificationMessage;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PubSubNotificationMessageProducer implements NotificationMessageProducer {
    @Override
    public void sendMessage(@NonNull NotificationMessage notification) {
        throw new UnsupportedOperationException();
    }
}
