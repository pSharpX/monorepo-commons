package com.onebank.taskmaster.controlplane.service;

import com.onebank.taskmaster.config.ConditionalOnMockEnabled;
import com.onebank.taskmaster.controlplane.model.CreateTaskRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@ConditionalOnMockEnabled
public class CreateFakeTaskService implements CreateTask {
	@Override
	public String createNewTask(@NonNull CreateTaskRequest task) {
		return UUID.randomUUID().toString();
	}
}
