package com.onebank.taskmaster.controlplane.service;

import java.util.UUID;

import com.onebank.taskmaster.controlplane.model.CreateTaskRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateFakeTaskService implements CreateTask {
	@Override
	public String createNewTask(@NonNull CreateTaskRequest task) {
		return UUID.randomUUID().toString();
	}
}
