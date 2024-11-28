package com.onebank.taskmaster.controlplane.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ToggleTaskStatusService implements ToggleTaskStatus {
    @Override
    public void toggle(@NonNull String taskId) {
        throw new UnsupportedOperationException();
    }
}
