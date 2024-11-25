package com.onebank.taskmaster.controlplane.model;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchTaskParam {
	@NotBlank
	private String title;
	private List<String> tags;
	private String status;
}
