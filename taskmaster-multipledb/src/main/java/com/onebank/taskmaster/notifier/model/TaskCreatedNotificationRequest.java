package com.onebank.taskmaster.notifier.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TaskCreatedNotificationRequest extends CreateTaskNotificationRequest {
    @NotNull
    private Long taskId;
    @NotEmpty
    private String taskTitle;
}
