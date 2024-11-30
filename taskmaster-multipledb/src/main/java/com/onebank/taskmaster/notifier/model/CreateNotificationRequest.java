package com.onebank.taskmaster.notifier.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateNotificationRequest {
    private String channel = NotificationChannel.EMAIL.getName();
    @NotEmpty
    private String user;
    @NotEmpty
    private String title;
    @NotEmpty
    private String message;
    @Setter(AccessLevel.NONE)
    private NotificationStatus status = NotificationStatus.CREATED;
}
