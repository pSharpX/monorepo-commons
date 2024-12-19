package com.onebank.taskmaster.controlplane.service;

import com.onebank.taskmaster.controlplane.config.ConditionalOnMockEnabled;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@ConditionalOnMockEnabled
@Slf4j
public class DeleteFakeTaskService implements DeleteTask {
    @Override
    public void delete(@NonNull Long taskId) {
        log.info("Deleting task with id [{}]", taskId);
    }
}
