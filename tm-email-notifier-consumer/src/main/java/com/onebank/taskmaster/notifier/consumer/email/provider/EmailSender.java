package com.onebank.taskmaster.notifier.consumer.email.provider;

import com.onebank.taskmaster.notifier.consumer.email.model.MessageTemplate;
import lombok.NonNull;

public interface EmailSender {
    void send(@NonNull MessageTemplate messageTemplate);
}
