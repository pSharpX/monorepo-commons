package com.onebank.taskmaster.notifier.service.senders;

import com.onebank.taskmaster.notifier.model.senders.NotificationMessage;
import lombok.NonNull;

public interface SendNotification<T extends NotificationMessage> {
    void send(@NonNull T notification);
}
