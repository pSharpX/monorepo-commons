package com.onebank.taskmaster.notifier.service.producers;

import com.onebank.taskmaster.notifier.model.AbstractMessage;

public interface MessageProducer<T extends AbstractMessage> {
    void sendMessage(T message);
}
