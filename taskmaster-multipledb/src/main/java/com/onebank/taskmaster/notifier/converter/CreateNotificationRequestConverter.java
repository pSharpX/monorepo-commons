package com.onebank.taskmaster.notifier.converter;

import com.onebank.taskmaster.converter.ConvertTo;
import com.onebank.taskmaster.notifier.entity.NotificationEntity;
import com.onebank.taskmaster.notifier.model.CreateNotificationRequest;
import com.onebank.taskmaster.notifier.model.NotificationChannel;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class CreateNotificationRequestConverter implements ConvertTo<CreateNotificationRequest, NotificationEntity> {
    @Override
    public NotificationEntity convert(@NonNull CreateNotificationRequest input) {
        return NotificationEntity.builder()
                .user(input.getUser())
                .title(input.getTitle())
                .message(input.getMessage())
                .channel(NotificationChannel.getByName(input.getChannel()))
                .status(input.getStatus())
                .build();
    }
}
