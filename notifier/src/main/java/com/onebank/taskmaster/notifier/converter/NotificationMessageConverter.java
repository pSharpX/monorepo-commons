package com.onebank.taskmaster.notifier.converter;

import com.onebank.taskmaster.converter.ConvertTo;
import com.onebank.taskmaster.notifier.entity.NotificationEntity;
import com.onebank.taskmaster.notifier.model.senders.NotificationMessage;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class NotificationMessageConverter implements ConvertTo<NotificationEntity, NotificationMessage> {
    @Override
    public NotificationMessage convert(@NonNull NotificationEntity input) {
//        return NotificationMessage.builder()
//                .id(input.getId())
//                .user(input.getUser())
//                .title(input.getTitle())
//                .message(input.getMessage())
//                .status(input.getStatus())
//                .build();
        return null;
    }
}
