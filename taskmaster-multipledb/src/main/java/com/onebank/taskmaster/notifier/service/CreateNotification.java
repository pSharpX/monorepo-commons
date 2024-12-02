package com.onebank.taskmaster.notifier.service;

import com.onebank.taskmaster.notifier.model.CreateTaskNotificationRequest;
import lombok.NonNull;

public interface CreateNotification {
    void create(@NonNull CreateTaskNotificationRequest request);
}
