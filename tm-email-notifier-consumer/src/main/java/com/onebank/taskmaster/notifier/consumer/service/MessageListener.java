package com.onebank.taskmaster.notifier.consumer.service;

import com.onebank.taskmaster.notifier.model.AbstractMessage;
import lombok.NonNull;

public interface MessageListener<T extends AbstractMessage> {
    void listen(@NonNull T message);
}
