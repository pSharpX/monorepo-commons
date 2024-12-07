package com.onebank.taskmaster.notifier.model.senders;

import com.onebank.taskmaster.notifier.model.TaskNotificationType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskCompletedNotificationMessage extends NotificationMessage {
    private Long taskId;
    private String taskTitle;

    public TaskCompletedNotificationMessage() {
        super(TaskNotificationType.TASK_COMPLETED);
    }
}
