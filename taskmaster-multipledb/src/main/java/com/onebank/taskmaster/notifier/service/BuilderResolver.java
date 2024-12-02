package com.onebank.taskmaster.notifier.service;

import com.onebank.taskmaster.notifier.model.TaskNotificationType;
import com.onebank.taskmaster.notifier.service.builders.BuildNotification;
import lombok.NonNull;

@SuppressWarnings("rawtypes")
public interface BuilderResolver {
    BuildNotification resolve(@NonNull TaskNotificationType notificationType);
}
