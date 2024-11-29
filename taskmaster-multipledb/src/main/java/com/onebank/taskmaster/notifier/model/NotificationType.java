package com.onebank.taskmaster.notifier.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum NotificationType {
    EMAIL("EMAIL"),
    PUSH("PUSH"),
    SMS("SMS"),
    IN_APP("IN_APP");

    private final String name;
}
