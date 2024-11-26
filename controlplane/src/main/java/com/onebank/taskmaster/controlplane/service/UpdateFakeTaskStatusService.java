package com.onebank.taskmaster.controlplane.service;

import com.onebank.taskmaster.controlplane.model.TaskStatus;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UpdateFakeTaskStatusService implements UpdateTaskStatus {
    @Override
    public void changeStatus(@NonNull String taskId, @NonNull TaskStatus taskStatus) {
        log.info("Updating task [{}] status to [{}]", taskId, taskStatus.getName());
    }
}
