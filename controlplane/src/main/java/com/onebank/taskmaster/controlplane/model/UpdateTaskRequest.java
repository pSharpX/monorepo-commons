package com.onebank.taskmaster.controlplane.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTaskRequest {
	@JsonIgnore
	private Long id;
	@NotBlank
	private String taskTitle;
	@NotBlank
	private String taskDescription;
	private List<@NotBlank String> tags = new ArrayList<>();
	private Integer weight = 0;
}
