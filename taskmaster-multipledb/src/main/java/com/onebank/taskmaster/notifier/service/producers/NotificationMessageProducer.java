package com.onebank.taskmaster.notifier.service.producers;

import com.onebank.taskmaster.notifier.model.senders.NotificationMessage;
import lombok.NonNull;

public interface NotificationMessageProducer extends MessageProducer<NotificationMessage> {
    void sendMessage(@NonNull NotificationMessage notification);
}
