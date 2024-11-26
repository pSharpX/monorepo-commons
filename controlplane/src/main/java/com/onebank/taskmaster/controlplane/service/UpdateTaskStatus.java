package com.onebank.taskmaster.controlplane.service;

import com.onebank.taskmaster.controlplane.model.TaskStatus;
import lombok.NonNull;

public interface UpdateTaskStatus {
    void changeStatus(@NonNull String taskId, @NonNull TaskStatus taskStatus);
}
