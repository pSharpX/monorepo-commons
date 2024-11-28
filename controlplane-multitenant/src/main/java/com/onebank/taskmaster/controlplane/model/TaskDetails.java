package com.onebank.taskmaster.controlplane.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDetails {
	private String taskTitle;
	private String taskDescription;
	private List<String> tags;
	private Integer weight;
	private TaskStatus status;
}
