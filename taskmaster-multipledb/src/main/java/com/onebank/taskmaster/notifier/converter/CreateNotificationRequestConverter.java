package com.onebank.taskmaster.notifier.converter;

import com.onebank.taskmaster.converter.ConvertTo;
import com.onebank.taskmaster.notifier.entity.NotificationEntity;
import com.onebank.taskmaster.notifier.model.CreateTaskNotificationRequest;
import com.onebank.taskmaster.notifier.model.NotificationChannel;
import com.onebank.taskmaster.notifier.model.TaskNotificationType;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class CreateNotificationRequestConverter implements ConvertTo<CreateTaskNotificationRequest, NotificationEntity> {
    @Override
    public NotificationEntity convert(@NonNull CreateTaskNotificationRequest input) {
        return NotificationEntity.builder()
                .userIdentifier(input.getUser())
                .title(input.getTitle())
                .message(input.getMessage())
                .notificationType(TaskNotificationType.getByName(input.getType()))
                .channel(NotificationChannel.getByName(input.getChannel()))
                .status(input.getStatus())
                .build();
    }
}
