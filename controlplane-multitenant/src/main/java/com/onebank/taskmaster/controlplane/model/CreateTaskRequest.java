package com.onebank.taskmaster.controlplane.model;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTaskRequest {
	@NotBlank
	private String taskTitle;
	@NotBlank
	private String taskDescription;
	private List<String> tags;
	private Integer weight = 0;
	@Setter(AccessLevel.NONE)
	private TaskCreationStatus status = TaskCreationStatus.PENDING;
}
