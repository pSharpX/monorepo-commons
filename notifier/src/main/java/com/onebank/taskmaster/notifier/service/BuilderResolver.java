package com.onebank.taskmaster.notifier.service;

import com.onebank.taskmaster.notifier.model.TaskNotificationType;
import com.onebank.taskmaster.notifier.service.builders.NotificationMessageBuilder;
import lombok.NonNull;

@SuppressWarnings("rawtypes")
public interface BuilderResolver {
    NotificationMessageBuilder resolve(@NonNull TaskNotificationType notificationType);
}
