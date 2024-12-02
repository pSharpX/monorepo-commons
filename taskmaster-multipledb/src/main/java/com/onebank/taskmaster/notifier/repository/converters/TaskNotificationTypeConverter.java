package com.onebank.taskmaster.notifier.repository.converters;

import com.onebank.taskmaster.notifier.model.TaskNotificationType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Objects;

@Converter(autoApply = true)
public class TaskNotificationTypeConverter implements AttributeConverter<TaskNotificationType, String> {
    @Override
    public String convertToDatabaseColumn(TaskNotificationType taskNotificationType) {
        if (Objects.isNull(taskNotificationType)) {
            return null;
        }
        return taskNotificationType.getName();
    }

    @Override
    public TaskNotificationType convertToEntityAttribute(String columnValue) {
        return TaskNotificationType.getByName(columnValue);
    }
}
