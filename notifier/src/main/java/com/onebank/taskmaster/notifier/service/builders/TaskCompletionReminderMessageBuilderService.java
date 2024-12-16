package com.onebank.taskmaster.notifier.service.builders;

import com.onebank.taskmaster.notifier.model.TaskCompletionReminderNotificationRequest;
import com.onebank.taskmaster.notifier.model.TaskNotificationType;
import com.onebank.taskmaster.notifier.model.senders.NotificationMessage;
import com.onebank.taskmaster.notifier.service.ContentProviderResolver;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@SuppressWarnings("unchecked")
public class TaskCompletionReminderMessageBuilderService implements NotificationMessageBuilder<TaskCompletionReminderNotificationRequest> {
    private final ContentProviderResolver contentProviderResolver;

    @Override
    public NotificationMessage build(@NonNull TaskCompletionReminderNotificationRequest request) {
        return contentProviderResolver.resolve(TaskNotificationType.TASK_COMPLETION_REMINDER).getContent(request);
    }
}
