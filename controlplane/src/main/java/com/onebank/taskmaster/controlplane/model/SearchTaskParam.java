package com.onebank.taskmaster.controlplane.model;

import java.util.List;

import com.onebank.taskmaster.controlplane.model.validators.TaskStatusCode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchTaskParam {
	@NotBlank
	private String title;
	private List<@NotEmpty String> tags;
	@TaskStatusCode
	private String status;
}
