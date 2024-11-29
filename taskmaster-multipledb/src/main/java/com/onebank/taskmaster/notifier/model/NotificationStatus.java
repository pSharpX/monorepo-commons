package com.onebank.taskmaster.notifier.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum NotificationStatus {
    CREATED("CREATED"),
    PENDING("PENDING"),
    SENT("SENT"),
    RECEIVED("RECEIVED");

    private final String name;
}
