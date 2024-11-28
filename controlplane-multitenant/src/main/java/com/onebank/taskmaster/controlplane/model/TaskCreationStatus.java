package com.onebank.taskmaster.controlplane.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TaskCreationStatus {
	PENDING("PENDING"),
	CREATED("CREATED"),
	DELETED("DELETED");

	private final String name;
}
