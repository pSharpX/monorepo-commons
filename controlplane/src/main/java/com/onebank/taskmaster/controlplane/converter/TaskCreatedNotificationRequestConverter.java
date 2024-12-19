package com.onebank.taskmaster.controlplane.converter;

import com.onebank.taskmaster.controlplane.entity.TaskEntity;
import com.onebank.taskmaster.controlplane.model.notification.NotificationChannel;
import com.onebank.taskmaster.controlplane.model.notification.TaskCreatedNotificationRequest;
import com.onebank.taskmaster.controlplane.model.notification.TaskNotificationType;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
public class TaskCreatedNotificationRequestConverter implements ConvertTo<TaskEntity, TaskCreatedNotificationRequest> {
    @Override
    public TaskCreatedNotificationRequest convert(@NonNull TaskEntity input) {
        TaskCreatedNotificationRequest request = new TaskCreatedNotificationRequest();
        request.setChannel(NotificationChannel.EMAIL.getName());
        request.setType(TaskNotificationType.TASK_CREATED.getName());
        // TODO: User management integration
        request.setUser("your_email_here"); //
        request.setTitle(input.getTitle());
        request.setMessage(input.getDescription());
        request.setTaskId(input.getId());
        request.setTaskTitle(input.getTitle());
        request.setTaskDescription(input.getDescription());
        request.setTaskDueDate(Optional.ofNullable(input.getDueDate()).map(LocalDate::toString).orElse(null));
        request.setTaskPriority(String.valueOf(input.getWeight()));
        return request;
    }
}
