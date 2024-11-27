package com.onebank.taskmaster.controlplane.service;

import lombok.NonNull;

public interface DeleteTask {
    void delete(@NonNull Long taskId);
}
