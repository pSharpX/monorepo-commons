package com.onebank.taskmaster.controlplane.model.notification;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TaskDeletedNotificationRequest extends TaskNotificationRequest {
    private String taskTitle;
}
