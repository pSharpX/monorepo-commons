package com.onebank.taskmaster.controlplane.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchTaskResponse {
	private List<TaskDetails> tasks;
}
