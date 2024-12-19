package com.onebank.taskmaster.controlplane.model.notification;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskNotificationRequest {
    private String channel;
    @NotNull
    private String type;
    @NotEmpty
    private String user;
    @NotEmpty
    private String title;
    @NotEmpty
    private String message;
}
