package com.onebank.taskmaster.controlplane.repository.converters;

import com.onebank.taskmaster.controlplane.model.TaskStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Objects;

@Converter(autoApply = true)
public class TaskStatusConverter implements AttributeConverter<TaskStatus, String> {
    @Override
    public String convertToDatabaseColumn(TaskStatus taskStatus) {
        Objects.requireNonNull(taskStatus, "taskStatus property must be not null");
        return taskStatus.getName();
    }

    @Override
    public TaskStatus convertToEntityAttribute(String columnValue) {
        return TaskStatus.getByName(columnValue);
    }
}
