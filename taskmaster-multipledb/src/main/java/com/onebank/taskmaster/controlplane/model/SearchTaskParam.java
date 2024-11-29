package com.onebank.taskmaster.controlplane.model;

import com.onebank.taskmaster.controlplane.model.validators.TaskStatusCode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
