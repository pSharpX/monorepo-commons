package com.onebank.taskmaster.controlplane.service;

import lombok.NonNull;

public interface ToggleTaskStatus {
    void toggle(@NonNull String taskId);
}
