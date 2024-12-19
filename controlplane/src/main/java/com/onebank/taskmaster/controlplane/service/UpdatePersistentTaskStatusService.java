package com.onebank.taskmaster.controlplane.service;

import com.onebank.taskmaster.controlplane.config.ConditionalOnDatabaseEnabled;
import com.onebank.taskmaster.controlplane.entity.TaskEntity;
import com.onebank.taskmaster.controlplane.exceptions.ResourceNotFoundException;
import com.onebank.taskmaster.controlplane.exceptions.utils.ExceptionConstantsUtils;
import com.onebank.taskmaster.controlplane.model.TaskStatus;
import com.onebank.taskmaster.controlplane.repository.TaskRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@ConditionalOnDatabaseEnabled
@Slf4j
public class UpdatePersistentTaskStatusService implements UpdateTaskStatus {
    private final TaskRepository taskRepository;

    @Override
    public void changeStatus(@NonNull Long taskId, @NonNull TaskStatus taskStatus) {
        TaskEntity taskEntity = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException(ExceptionConstantsUtils.NOT_FOUND, "task was not found"));

        log.debug("Updating task [{}] status to [{}]", taskId, taskStatus.getName());
        taskEntity.setProgressStatus(taskStatus);
        taskRepository.save(taskEntity);
    }
}
