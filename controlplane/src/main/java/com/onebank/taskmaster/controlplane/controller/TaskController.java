package com.onebank.taskmaster.controlplane.controller;

import com.onebank.taskmaster.controlplane.model.CreateTaskRequest;
import com.onebank.taskmaster.controlplane.model.SearchTaskParam;
import com.onebank.taskmaster.controlplane.model.SearchTaskResponse;
import com.onebank.taskmaster.controlplane.service.CreateTask;
import com.onebank.taskmaster.controlplane.service.SearchTask;
import com.onebank.taskmaster.controlplane.service.ToggleTaskStatus;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	private final ToggleTaskStatus toggleTaskStatus;

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

	@PutMapping("/{taskId}")
	@ResponseStatus(HttpStatus.OK)
	public void toggleTaskStatus(@PathVariable String taskId) {
		this.toggleTaskStatus.toggle(taskId);
	}

	@DeleteMapping("/{taskId}")
	@ResponseStatus(HttpStatus.OK)
	public String deleteTask(@PathVariable String taskId) {
		return "task deleted successfully";
	}

}
