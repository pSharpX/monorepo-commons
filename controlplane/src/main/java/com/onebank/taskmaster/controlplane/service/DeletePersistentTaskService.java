package com.onebank.taskmaster.controlplane.service;

import com.onebank.taskmaster.controlplane.config.ConditionalOnDatabaseEnabled;
import com.onebank.taskmaster.controlplane.entity.TaskEntity;
import com.onebank.taskmaster.controlplane.exceptions.ResourceNotFoundException;
import com.onebank.taskmaster.controlplane.exceptions.utils.ExceptionConstantsUtils;
import com.onebank.taskmaster.controlplane.repository.TaskRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@ConditionalOnDatabaseEnabled
@Slf4j
public class DeletePersistentTaskService implements DeleteTask {
    private final TaskRepository taskRepository;

    @Override
    @Transactional
    public void delete(@NonNull Long taskId) {
        TaskEntity taskEntity = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException(ExceptionConstantsUtils.NOT_FOUND, ExceptionConstantsUtils.TASK_RESOURCE_NOT_FOUND_MESSAGE));

        log.info("Deleting task with id [{}]", taskId);
        taskRepository.delete(taskEntity);
    }
}
