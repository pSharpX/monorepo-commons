package com.onebank.taskmaster.controlplane.service;

import com.onebank.taskmaster.controlplane.config.ConditionalOnMockEnabled;
import com.onebank.taskmaster.controlplane.model.TaskStatus;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@ConditionalOnMockEnabled
public class UpdateFakeTaskStatusService implements UpdateTaskStatus {
    @Override
    public void changeStatus(@NonNull Long taskId, @NonNull TaskStatus taskStatus) {
        log.info("Updating task [{}] status to [{}]", taskId, taskStatus.getName());
    }
}
