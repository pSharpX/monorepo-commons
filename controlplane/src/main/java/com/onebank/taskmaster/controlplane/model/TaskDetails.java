package com.onebank.taskmaster.controlplane.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDetails {
	private String taskTitle;
	private String taskDescription;
	private List<String> tags;
	private Integer weight;
	private TaskStatus status;
	private LocalDate dueDate;
	private LocalDateTime completionDate;
}
