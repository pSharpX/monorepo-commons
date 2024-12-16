package com.onebank.taskmaster.notifier.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "TaskDeleted Request")
@EqualsAndHashCode(callSuper = true)
@Data
public class TaskDeletedNotificationRequest extends TaskNotificationRequest {
    private String taskTitle;
}
