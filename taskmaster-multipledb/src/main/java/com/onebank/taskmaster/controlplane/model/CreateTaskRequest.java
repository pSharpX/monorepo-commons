package com.onebank.taskmaster.controlplane.model;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTaskRequest {
	@NotBlank
	private String taskTitle;
	@NotBlank
	private String taskDescription;
	@FutureOrPresent
	private LocalDate dueDate;
	private List<@NotBlank String> tags = new ArrayList<>();
	private Integer weight = 0;
	@Setter(AccessLevel.NONE)
	private TaskCreationStatus status = TaskCreationStatus.PENDING;
}
