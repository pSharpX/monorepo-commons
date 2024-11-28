package com.onebank.taskmaster.controlplane.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum TaskStatus {
	TODO("TODO"),
	IN_PROGRESS("IN_PROGRESS"),
	DONE("DONE");
	private final String name;

	public static TaskStatus getByName(@NonNull String name) {
		return Stream.of(values()).filter(taskStatus -> taskStatus.getName().equalsIgnoreCase(name))
				.findFirst()
				.orElse(null);
	}

	public static boolean isValid(String name) {
		return Stream.of(values()).anyMatch(taskStatus -> taskStatus.getName().equals(name));
	}
}
