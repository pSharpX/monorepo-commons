package com.onebank.taskmaster.notifier.service.builders;

import com.onebank.taskmaster.notifier.model.TaskCreatedNotificationRequest;
import com.onebank.taskmaster.notifier.model.senders.NotificationMessage;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskCreatedNotificationBuilderService implements BuildNotification<TaskCreatedNotificationRequest> {
    @Override
    public NotificationMessage build(@NonNull TaskCreatedNotificationRequest request) {
        log.debug("Building {} notification", request.getType());
        log.debug("Retrieving details of task with ID = {}", request.getTaskId());
        throw new UnsupportedOperationException();
    }
}
