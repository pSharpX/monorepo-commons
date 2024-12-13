package com.onebank.taskmaster.notifier.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task-notifications")
@RequiredArgsConstructor
public class TaskNotifierController {



	@PostMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void notifyTaskChange(@Valid @RequestBody String ss) {

	}

}
