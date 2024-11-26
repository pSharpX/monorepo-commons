package com.onebank.taskmaster.controlplane.entity.listeners;

import com.onebank.taskmaster.controlplane.entity.TaskEntity;
import jakarta.persistence.PrePersist;

public class TaskCreationListener {
    @PrePersist
    public void onPrePersist(final TaskEntity taskEntity) {
        taskEntity.setEnabled(true);
    }
}
