package com.onebank.taskmaster.notifier.service;

import com.onebank.taskmaster.notifier.model.TaskNotificationType;
import com.onebank.taskmaster.notifier.service.builders.BuildNotification;
import com.onebank.taskmaster.notifier.service.builders.TaskCompletedNotificationBuilderService;
import com.onebank.taskmaster.notifier.service.builders.TaskCreatedNotificationBuilderService;
import com.onebank.taskmaster.notifier.service.builders.TaskDeletedNotificationBuilderService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@SuppressWarnings("rawtypes")
public class BuilderResolverService implements BuilderResolver {
    private final TaskCreatedNotificationBuilderService taskCreatedNotificationBuilderService;
    private final TaskDeletedNotificationBuilderService taskDeletedNotificationBuilderService;
    private final TaskCompletedNotificationBuilderService taskCompletedNotificationBuilderService;

    @Override
    public BuildNotification resolve(@NonNull TaskNotificationType notificationType) {
        return switch (notificationType) {
            case TASK_CREATED -> taskCreatedNotificationBuilderService;
            case TASK_DELETED -> taskDeletedNotificationBuilderService;
            case TASK_COMPLETED -> taskCompletedNotificationBuilderService;
            case TASK_COMPLETION_REMINDER, TASK_REMINDER_CONFIGURED -> throw new UnsupportedOperationException();
        };
    }
}
