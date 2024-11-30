package com.onebank.taskmaster.notifier.service.senders;

import com.onebank.taskmaster.notifier.model.senders.Notification;
import lombok.NonNull;

public interface SendNotification<T extends Notification> {
    void send(@NonNull T notification);
}
