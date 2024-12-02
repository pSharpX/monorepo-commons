package com.onebank.taskmaster.notifier.service.builders;

import com.onebank.taskmaster.notifier.model.CreateTaskNotificationRequest;
import com.onebank.taskmaster.notifier.model.senders.NotificationMessage;
import lombok.NonNull;

public interface BuildNotification <T extends CreateTaskNotificationRequest> {
    NotificationMessage build(@NonNull T request);
}
