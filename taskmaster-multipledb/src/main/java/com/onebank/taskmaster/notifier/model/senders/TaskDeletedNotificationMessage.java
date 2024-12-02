package com.onebank.taskmaster.notifier.model.senders;

import com.onebank.taskmaster.notifier.model.TaskNotificationType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDeletedNotificationMessage extends NotificationMessage {
    private String taskTitle;

    public TaskDeletedNotificationMessage() {
        super(TaskNotificationType.TASK_DELETED);
    }
}
