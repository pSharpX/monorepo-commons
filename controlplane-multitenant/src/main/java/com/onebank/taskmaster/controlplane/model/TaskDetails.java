package com.onebank.taskmaster.controlplane.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
}
