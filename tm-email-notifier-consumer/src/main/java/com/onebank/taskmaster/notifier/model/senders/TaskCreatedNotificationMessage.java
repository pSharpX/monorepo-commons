package com.onebank.taskmaster.notifier.model.senders;

import com.onebank.taskmaster.notifier.model.TaskNotificationType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskCreatedNotificationMessage extends NotificationMessage {
    private Long taskId;
    private String taskTitle;

    public TaskCreatedNotificationMessage() {
        super(TaskNotificationType.TASK_CREATED);
    }
}
