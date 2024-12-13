package com.onebank.taskmaster.notifier.service.builders;

import com.onebank.taskmaster.notifier.model.NotificationChannel;
import com.onebank.taskmaster.notifier.model.TaskDeletedNotificationRequest;
import com.onebank.taskmaster.notifier.model.senders.NotificationMessage;
import com.onebank.taskmaster.notifier.model.senders.TaskDeletedNotificationMessage;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskDeletedNotificationBuilderService implements BuildNotification<TaskDeletedNotificationRequest> {
    @Override
    public NotificationMessage build(@NonNull TaskDeletedNotificationRequest request) {
        log.debug("Building {} notification", request.getType());
        TaskDeletedNotificationMessage notificationMessage = new TaskDeletedNotificationMessage();
        notificationMessage.setId(request.getId());
        notificationMessage.setUser(request.getUser());
        notificationMessage.setTaskTitle(request.getTaskTitle());
        notificationMessage.setTitle(request.getTitle());
        notificationMessage.setMessage(request.getMessage());
        notificationMessage.setChannel(NotificationChannel.getByName(request.getChannel()));
        return notificationMessage;
    }
}
