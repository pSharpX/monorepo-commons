package com.onebank.taskmaster.notifier.service.builders;

import com.onebank.taskmaster.notifier.model.TaskCompletedNotificationRequest;
import com.onebank.taskmaster.notifier.model.senders.NotificationMessage;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskCompletedNotificationBuilderService implements BuildNotification<TaskCompletedNotificationRequest> {
    @Override
    public NotificationMessage build(@NonNull TaskCompletedNotificationRequest request) {
        log.debug("Building {} notification", request.getType());
        throw new UnsupportedOperationException();
    }
}
