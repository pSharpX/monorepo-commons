package com.onebank.taskmaster.notifier.service;

import com.onebank.taskmaster.notifier.model.TaskNotificationRequest;
import lombok.NonNull;

public interface CreateNotification {
    void create(@NonNull TaskNotificationRequest request);
}
