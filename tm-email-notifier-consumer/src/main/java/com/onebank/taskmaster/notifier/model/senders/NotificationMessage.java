package com.onebank.taskmaster.notifier.model.senders;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.onebank.taskmaster.notifier.model.AbstractMessage;
import com.onebank.taskmaster.notifier.model.NotificationChannel;
import com.onebank.taskmaster.notifier.model.TaskNotificationType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(callSuper = true)
@Data
@RequiredArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TaskCreatedNotificationMessage.class, name = "TASK_CREATED"),
        @JsonSubTypes.Type(value = TaskDeletedNotificationMessage.class, names = "TASK_DELETED"),
        @JsonSubTypes.Type(value = TaskCompletedNotificationMessage.class, names = "TASK_COMPLETED")
})
public abstract class NotificationMessage extends AbstractMessage {
    private Long id;
    private NotificationChannel channel;
    @Setter(AccessLevel.NONE)
    private final TaskNotificationType type;
    private String user;
    private String title;
    private String message;
}
