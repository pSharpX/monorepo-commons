package com.onebank.taskmaster.notifier.service;

import com.onebank.taskmaster.notifier.model.TaskNotificationType;
import com.onebank.taskmaster.notifier.service.builders.NotificationMessageBuilder;
import com.onebank.taskmaster.notifier.service.builders.TaskCompletedMessageBuilderService;
import com.onebank.taskmaster.notifier.service.builders.TaskCompletionReminderMessageBuilderService;
import com.onebank.taskmaster.notifier.service.builders.TaskCreatedMessageBuilderService;
import com.onebank.taskmaster.notifier.service.builders.TaskDeletedMessageBuilderService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@SuppressWarnings("rawtypes")
public class BuilderResolverService implements BuilderResolver {
    private final TaskCreatedMessageBuilderService taskCreatedMessageBuilderService;
    private final TaskDeletedMessageBuilderService taskDeletedMessageBuilderService;
    private final TaskCompletedMessageBuilderService taskCompletedMessageBuilderService;
    private final TaskCompletionReminderMessageBuilderService taskCompletionReminderMessageBuilderService;

    @Override
    public NotificationMessageBuilder resolve(@NonNull TaskNotificationType notificationType) {
        return switch (notificationType) {
            case TASK_CREATED -> taskCreatedMessageBuilderService;
            case TASK_DELETED -> taskDeletedMessageBuilderService;
            case TASK_COMPLETED -> taskCompletedMessageBuilderService;
            case TASK_COMPLETION_REMINDER -> taskCompletionReminderMessageBuilderService;
            case TASK_REMINDER_CONFIGURED -> throw new UnsupportedOperationException();
        };
    }
}
