package com.onebank.taskmaster.notifier.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TaskDeletedNotificationRequest extends CreateTaskNotificationRequest {
    private String taskTitle;
}
