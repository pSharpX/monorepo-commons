package com.onebank.taskmaster.notifier.entity.listeners;

import com.onebank.taskmaster.notifier.entity.NotificationEntity;
import jakarta.persistence.PrePersist;

public class NotificationCreationListener {
    @PrePersist
    public void onPrePersist(final NotificationEntity notificationEntity) {
        notificationEntity.setEnabled(true);
    }
}
