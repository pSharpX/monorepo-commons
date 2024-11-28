package com.onebank.taskmaster.controlplane.service;

import com.onebank.taskmaster.controlplane.model.CreateTaskRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class CreatePersistentTaskService implements CreateTask {
	@Override
	public String createNewTask(@NonNull CreateTaskRequest task) {
		return UUID.randomUUID().toString();
	}
}
