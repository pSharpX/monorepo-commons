package com.onebank.taskmaster.notifier.service.providers;

import com.onebank.taskmaster.notifier.model.NotificationChannel;
import com.onebank.taskmaster.notifier.model.TaskNotificationRequest;
import com.onebank.taskmaster.notifier.model.senders.EmailNotificationMessage;
import com.onebank.taskmaster.notifier.model.senders.InAppNotificationMessage;
import com.onebank.taskmaster.notifier.model.senders.NotificationMessage;
import com.onebank.taskmaster.notifier.model.senders.PushNotificationMessage;
import com.onebank.taskmaster.notifier.model.senders.SmsNotificationMessage;
import lombok.NonNull;

public interface MessageContentProvider<T extends TaskNotificationRequest> {

    default NotificationMessage getContent(@NonNull T request) {
        return switch (NotificationChannel.getByName(request.getChannel())) {
            case EMAIL -> getEmailMessageContent(request);
            case SMS -> getSmsMessageContent(request);
            case PUSH -> getPushMessageContent(request);
            case IN_APP -> getInAppMessageContent(request);
        };
    }
    EmailNotificationMessage getEmailMessageContent(T request);
    PushNotificationMessage getPushMessageContent(T request);
    SmsNotificationMessage getSmsMessageContent(T request);
    InAppNotificationMessage getInAppMessageContent(T request);
}
