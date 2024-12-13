package com.onebank.taskmaster.notifier.service.builders;

import com.onebank.taskmaster.notifier.model.NotificationChannel;
import com.onebank.taskmaster.notifier.model.TaskCreatedNotificationRequest;
import com.onebank.taskmaster.notifier.model.senders.NotificationMessage;
import com.onebank.taskmaster.notifier.model.senders.TaskCreatedNotificationMessage;
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
        TaskCreatedNotificationMessage notificationMessage = new TaskCreatedNotificationMessage();
        notificationMessage.setId(request.getId());
        notificationMessage.setUser(request.getUser());
        notificationMessage.setTaskId(request.getTaskId());
        notificationMessage.setTaskTitle(request.getTaskTitle());
        notificationMessage.setTitle(request.getTitle());
        notificationMessage.setMessage(request.getMessage());
        notificationMessage.setChannel(NotificationChannel.getByName(request.getChannel()));
        return notificationMessage;
    }
}
