package com.onebank.taskmaster.controlplane.converter;

import com.onebank.taskmaster.controlplane.entity.TaskEntity;
import com.onebank.taskmaster.controlplane.model.CreateTaskRequest;
import com.onebank.taskmaster.controlplane.model.TaskStatus;
import com.onebank.taskmaster.converter.ConvertTo;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class CreateTaskRequestConverter implements ConvertTo<CreateTaskRequest, TaskEntity> {
    @Override
    public TaskEntity convert(@NonNull CreateTaskRequest input) {
        return TaskEntity.builder()
                .title(input.getTaskTitle())
                .description(input.getTaskDescription())
                .weight(input.getWeight())
                .progressStatus(TaskStatus.TODO)
                .status(input.getStatus())
                .build();
    }
}
