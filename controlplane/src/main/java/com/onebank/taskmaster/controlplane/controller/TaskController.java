package com.onebank.taskmaster.controlplane.controller;

import com.onebank.taskmaster.controlplane.model.CreateTaskRequest;
import com.onebank.taskmaster.controlplane.model.SearchTaskParam;
import com.onebank.taskmaster.controlplane.model.SearchTaskResponse;
import com.onebank.taskmaster.controlplane.service.CreateTask;
import com.onebank.taskmaster.controlplane.service.SearchTask;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

	private final CreateTask createTaskService;
	private final SearchTask searchTaskService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String createNewTask(@Valid @RequestBody CreateTaskRequest request) {
		return createTaskService.createNewTask(request);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public SearchTaskResponse searchTasks(@Valid SearchTaskParam param) {
		return searchTaskService.search(param);
	}

}
