package com.onebank.taskmaster.notifier.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "TaskCompletionReminder Request")
@EqualsAndHashCode(callSuper = true)
@Data
public class TaskCompletionReminderNotificationRequest extends TaskNotificationRequest {
    @NotNull
    private Long taskId;
    @NotEmpty
    private String taskTitle;
}
