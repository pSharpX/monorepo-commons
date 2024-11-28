package com.onebank.taskmaster.controlplane.service;

import com.onebank.taskmaster.controlplane.config.OnDatabaseIntegration;
import com.onebank.taskmaster.controlplane.converter.ConvertTo;
import com.onebank.taskmaster.controlplane.entity.TaskEntity;
import com.onebank.taskmaster.controlplane.model.SearchTaskParam;
import com.onebank.taskmaster.controlplane.model.SearchTaskResponse;
import com.onebank.taskmaster.controlplane.model.TaskDetails;
import com.onebank.taskmaster.controlplane.model.TaskStatus;
import com.onebank.taskmaster.controlplane.repository.TaskRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@OnDatabaseIntegration
@Slf4j
public class SearchPersistentTaskService implements SearchTask {
	private final TaskRepository taskRepository;
	private final ConvertTo<TaskEntity, TaskDetails> converter;

	@Override
	public SearchTaskResponse search(@NonNull SearchTaskParam param) {
		TaskStatus taskStatus = Optional.ofNullable(param.getStatus())
				.map(TaskStatus::getByName)
				.orElse(null);
		return new SearchTaskResponse(taskRepository.findByProgressStatusAndTitleContainingIgnoreCase(taskStatus , param.getTitle())
				.stream().map(converter::convert).toList());
	}
}
