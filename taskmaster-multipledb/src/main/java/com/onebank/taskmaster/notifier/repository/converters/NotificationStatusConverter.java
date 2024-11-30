package com.onebank.taskmaster.notifier.repository.converters;

import com.onebank.taskmaster.notifier.model.NotificationStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Objects;

@Converter(autoApply = true)
public class NotificationStatusConverter implements AttributeConverter<NotificationStatus, String> {
    @Override
    public String convertToDatabaseColumn(NotificationStatus notificationStatus) {
        if (Objects.isNull(notificationStatus)) {
            return null;
        }
        return notificationStatus.getName();
    }

    @Override
    public NotificationStatus convertToEntityAttribute(String columnValue) {
        return NotificationStatus.getByName(columnValue);
    }
}
