package com.onebank.taskmaster.notifier.service;

import com.onebank.taskmaster.notifier.model.CreateNotificationRequest;
import lombok.NonNull;

public interface CreateNotification {
    void create(@NonNull CreateNotificationRequest request);
}
