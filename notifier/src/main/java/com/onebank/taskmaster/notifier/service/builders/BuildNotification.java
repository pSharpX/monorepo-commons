package com.onebank.taskmaster.notifier.service.builders;

import com.onebank.taskmaster.notifier.model.TaskNotificationRequest;
import com.onebank.taskmaster.notifier.model.senders.NotificationMessage;
import lombok.NonNull;

public interface BuildNotification <T extends TaskNotificationRequest> {
    NotificationMessage build(@NonNull T request);
}
