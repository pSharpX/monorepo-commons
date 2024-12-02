package com.onebank.taskmaster.notifier.controller;

import com.onebank.taskmaster.notifier.model.CreateTaskNotificationRequest;
import com.onebank.taskmaster.notifier.service.CreateNotification;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class TaskMasterNotifierController {

	private final CreateNotification createNotification;

	@PostMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void createNotification(@Valid @RequestBody CreateTaskNotificationRequest request) {
		createNotification.create(request);
	}
}
