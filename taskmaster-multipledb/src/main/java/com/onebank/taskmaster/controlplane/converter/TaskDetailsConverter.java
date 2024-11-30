package com.onebank.taskmaster.controlplane.converter;

import com.onebank.taskmaster.controlplane.entity.TagEntity;
import com.onebank.taskmaster.controlplane.entity.TaskEntity;
import com.onebank.taskmaster.controlplane.model.TaskDetails;
import com.onebank.taskmaster.converter.ConvertTo;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class TaskDetailsConverter implements ConvertTo<TaskEntity, TaskDetails> {
    @Override
    public TaskDetails convert(@NonNull TaskEntity input) {
        return TaskDetails.builder()
                .taskTitle(input.getTitle())
                .taskDescription(input.getDescription())
                .weight(input.getWeight())
                .tags(input.getTags().stream().map(TagEntity::getName).toList())
                .status(input.getProgressStatus())
                .build();
    }
}
