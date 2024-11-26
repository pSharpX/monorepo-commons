package com.onebank.taskmaster.controlplane.service;

import com.onebank.taskmaster.controlplane.model.UpdateTaskRequest;
import lombok.NonNull;

public interface UpdateTask {
    void update(@NonNull UpdateTaskRequest request);
}
