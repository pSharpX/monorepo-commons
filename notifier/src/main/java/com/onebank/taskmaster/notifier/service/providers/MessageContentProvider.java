package com.onebank.taskmaster.notifier.service.providers;

import com.onebank.taskmaster.notifier.model.TaskNotificationRequest;
import com.onebank.taskmaster.notifier.model.senders.NotificationMessage;
import lombok.NonNull;

public interface MessageContentProvider<T extends TaskNotificationRequest> {
    NotificationMessage getContent(@NonNull T request);
}
