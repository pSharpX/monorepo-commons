package com.onebank.taskmaster.notifier.model.senders;

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
public abstract class NotificationMessage extends AbstractMessage {
    private Long id;
    private NotificationChannel channel;
    @Setter(AccessLevel.NONE)
    private final TaskNotificationType type;
    private String user;
    private String title;
    private String message;
}
