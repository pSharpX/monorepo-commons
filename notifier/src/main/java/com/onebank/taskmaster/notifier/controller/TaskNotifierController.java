package com.onebank.taskmaster.notifier.controller;

import com.onebank.taskmaster.notifier.model.TaskNotificationRequest;
import com.onebank.taskmaster.notifier.service.CreateNotification;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
public class TaskNotifierController {

	private final CreateNotification createNotification;

	@Operation(
			summary = "Create a Notification Message",
			description = "Returns a user for a given ID.",
			responses = {
					@ApiResponse(
							responseCode = "202",
							description = "Notification creation accepted",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = TaskNotificationRequest.class))
					)
			}
	)
	@PostMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void createNotification(@Valid @RequestBody TaskNotificationRequest request) {
		createNotification.create(request);
	}
}
