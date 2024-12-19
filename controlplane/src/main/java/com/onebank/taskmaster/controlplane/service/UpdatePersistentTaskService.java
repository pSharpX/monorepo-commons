package com.onebank.taskmaster.controlplane.service;

import com.onebank.taskmaster.controlplane.config.ConditionalOnDatabaseEnabled;
import com.onebank.taskmaster.controlplane.entity.TagEntity;
import com.onebank.taskmaster.controlplane.entity.TaskEntity;
import com.onebank.taskmaster.controlplane.exceptions.ResourceNotFoundException;
import com.onebank.taskmaster.controlplane.exceptions.utils.ExceptionConstantsUtils;
import com.onebank.taskmaster.controlplane.model.UpdateTaskRequest;
import com.onebank.taskmaster.controlplane.repository.TagRepository;
import com.onebank.taskmaster.controlplane.repository.TaskRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@ConditionalOnDatabaseEnabled
@Slf4j
public class UpdatePersistentTaskService implements UpdateTask {
    private final TaskRepository taskRepository;
    private final TagRepository tagRepository;

    @Override
    @Transactional
    public void update(@NonNull UpdateTaskRequest request) {
        TaskEntity taskEntity = taskRepository.findById(request.getId())
                .orElseThrow(() -> new ResourceNotFoundException(ExceptionConstantsUtils.NOT_FOUND, ExceptionConstantsUtils.TASK_RESOURCE_NOT_FOUND_MESSAGE));

        log.debug("Updating task [{}] with title [{}]", request.getId(), request.getTaskTitle());
        taskEntity.setTitle(request.getTaskTitle());
        taskEntity.setDescription(request.getTaskDescription());
        taskEntity.setWeight(request.getWeight());
        taskEntity.setTags(request.getTags().stream()
                .map(name -> tagRepository.findByName(name)
                        .orElse(new TagEntity(name)))
                .collect(Collectors.toSet()));
        taskRepository.save(taskEntity);
    }
}
