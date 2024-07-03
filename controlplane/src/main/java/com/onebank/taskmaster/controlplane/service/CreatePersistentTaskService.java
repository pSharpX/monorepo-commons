package com.onebank.taskmaster.controlplane.service;

import com.onebank.taskmaster.controlplane.converter.ConvertTo;
import com.onebank.taskmaster.controlplane.entity.TaskEntity;
import com.onebank.taskmaster.controlplane.model.CreateTaskRequest;
import com.onebank.taskmaster.controlplane.repository.TaskRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreatePersistentTaskService implements CreateTask {
	private final TaskRepository taskRepository;
	private final ConvertTo<CreateTaskRequest, TaskEntity> converter;

	@Override
	public String createNewTask(@NonNull CreateTaskRequest task) {
		TaskEntity entity = taskRepository.save(converter.convert(task));
		return String.valueOf(entity.getId());
	}
}