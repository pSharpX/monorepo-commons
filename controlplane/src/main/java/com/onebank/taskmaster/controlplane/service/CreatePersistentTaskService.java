package com.onebank.taskmaster.controlplane.service;

import com.onebank.taskmaster.controlplane.converter.ConvertTo;
import com.onebank.taskmaster.controlplane.entity.TagEntity;
import com.onebank.taskmaster.controlplane.entity.TaskEntity;
import com.onebank.taskmaster.controlplane.model.CreateTaskRequest;
import com.onebank.taskmaster.controlplane.repository.TagRepository;
import com.onebank.taskmaster.controlplane.repository.TaskRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CreatePersistentTaskService implements CreateTask {
	private final TaskRepository taskRepository;
	private final TagRepository tagRepository;
	private final ConvertTo<CreateTaskRequest, TaskEntity> converter;

	@Override
	@Transactional
	public String createNewTask(@NonNull CreateTaskRequest task) {
		TaskEntity entity = taskRepository.save(converter.convert(task));
		Set<TagEntity> tags = task.getTags().stream()
				.map(tagName -> tagRepository.findByName(tagName)
						.orElse(new TagEntity(tagName)))
				.collect(Collectors.toSet());
		entity.setTags(tags);
		taskRepository.save(entity);
		return String.valueOf(entity.getId());
	}
}