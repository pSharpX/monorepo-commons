package com.onebank.taskmaster.controlplane.service;

import com.onebank.taskmaster.controlplane.config.ConditionalOnMockEnabled;
import com.onebank.taskmaster.controlplane.model.UpdateTaskRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@ConditionalOnMockEnabled
public class UpdateFakeTaskService implements UpdateTask {
    @Override
    public void update(@NonNull UpdateTaskRequest request) {
        log.info("Updating task [{}] with title [{}]", request.getId(), request.getTaskTitle());
    }
}
