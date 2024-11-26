package com.onebank.taskmaster.controlplane.controller;

import com.onebank.taskmaster.controlplane.model.CreateTaskRequest;
import com.onebank.taskmaster.controlplane.model.SearchTaskParam;
import com.onebank.taskmaster.controlplane.model.SearchTaskResponse;
import com.onebank.taskmaster.controlplane.model.TaskStatus;
import com.onebank.taskmaster.controlplane.model.UpdateTaskRequest;
import com.onebank.taskmaster.controlplane.model.validators.TaskStatusCode;
import com.onebank.taskmaster.controlplane.service.CreateTask;
import com.onebank.taskmaster.controlplane.service.SearchTaskFacade;
import com.onebank.taskmaster.controlplane.service.UpdateTask;
import com.onebank.taskmaster.controlplane.service.UpdateTaskStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

	private final CreateTask createTaskService;
	private final SearchTaskFacade searchTaskFacadeService;
	private final UpdateTaskStatus updateTaskStatus;
	private final UpdateTask updateTask;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String createNewTask(@Valid @RequestBody CreateTaskRequest request) {
		return createTaskService.createNewTask(request);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public SearchTaskResponse searchTasks(@Valid SearchTaskParam param) {
		return searchTaskFacadeService.search(param);
	}

	@PatchMapping("/{taskId}/status/{taskStatus}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void toggleTaskStatus(@PathVariable Long taskId, @Valid @PathVariable @NotNull @TaskStatusCode String taskStatus) {
		this.updateTaskStatus.changeStatus(taskId, TaskStatus.getByName(taskStatus));
	}

	@PutMapping("/{taskId}")
	@ResponseStatus(HttpStatus.OK)
	public void updateTask(@PathVariable @NotNull Long taskId, @RequestBody UpdateTaskRequest request) {
		request.setId(taskId);
		this.updateTask.update(request);
	}

	@DeleteMapping("/{taskId}")
	@ResponseStatus(HttpStatus.OK)
	public String deleteTask(@PathVariable String taskId) {
		return "task deleted successfully";
	}

}
