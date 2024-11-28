package com.onebank.taskmaster.controlplane.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchTaskResponse {
	private List<TaskDetails> tasks;
}
