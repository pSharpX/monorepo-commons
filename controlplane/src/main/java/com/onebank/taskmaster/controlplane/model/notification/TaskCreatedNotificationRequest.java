package com.onebank.taskmaster.controlplane.model.notification;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TaskCreatedNotificationRequest extends TaskNotificationRequest {
    @NotNull
    private Long taskId;
    @NotEmpty
    private String taskTitle;
    private String taskDescription;
    private String taskDueDate;
    private String taskPriority;
}
