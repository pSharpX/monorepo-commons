package com.onebank.taskmaster.notifier.consumer.email.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TaskChangeNotificationType {
    CREATED("CREATED"),
    IN_CREATION("IN_CREATION"),
    DELETED("DELETED"),
    IN_DELETION("IN_DELETION"),
    IN_PROGRESS("IN_PROGRESS"),
    EXPIRED("EXPIRED"),
    DONE("DONE");
    private final String name;
}
