package com.onebank.taskmaster.notifier.repository.converters;

import com.onebank.taskmaster.notifier.model.NotificationChannel;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Objects;

@Converter(autoApply = true)
public class NotificationChannelConverter implements AttributeConverter<NotificationChannel, String> {
    @Override
    public String convertToDatabaseColumn(NotificationChannel notificationChannel) {
        Objects.requireNonNull(notificationChannel, "notificationChannel property must be not null");
        return notificationChannel.getName();
    }

    @Override
    public NotificationChannel convertToEntityAttribute(String columnValue) {
        return NotificationChannel.getByName(columnValue);
    }
}
