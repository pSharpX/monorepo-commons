package com.onebank.taskmaster.controlplane.service;

import com.onebank.taskmaster.controlplane.model.CreateTaskRequest;
import lombok.NonNull;

public interface CreateTask {
	String createNewTask(@NonNull CreateTaskRequest task);
}
