package com.onebank.taskmaster.controlplane.provider;

import com.onebank.taskmaster.controlplane.model.notification.TaskNotificationRequest;

public interface NotificationSender {
    void send(TaskNotificationRequest request);
}
