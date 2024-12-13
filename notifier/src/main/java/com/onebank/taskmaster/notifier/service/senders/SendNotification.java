package com.onebank.taskmaster.notifier.service.senders;

import com.onebank.taskmaster.notifier.model.senders.NotificationMessage;
import lombok.NonNull;

public interface SendNotification {
    void send(@NonNull NotificationMessage notification);
}
