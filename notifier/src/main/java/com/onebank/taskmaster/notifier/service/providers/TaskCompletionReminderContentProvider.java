package com.onebank.taskmaster.notifier.service.providers;

import com.onebank.taskmaster.notifier.model.TaskCompletionReminderNotificationRequest;
import com.onebank.taskmaster.notifier.model.senders.EmailNotificationMessage;
import com.onebank.taskmaster.notifier.model.senders.InAppNotificationMessage;
import com.onebank.taskmaster.notifier.model.senders.PushNotificationMessage;
import com.onebank.taskmaster.notifier.model.senders.SmsNotificationMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskCompletionReminderContentProvider implements MessageContentProvider<TaskCompletionReminderNotificationRequest> {

    @Override
    public EmailNotificationMessage getEmailMessageContent(TaskCompletionReminderNotificationRequest request) {
        throw new UnsupportedOperationException();
    }

    @Override
    public PushNotificationMessage getPushMessageContent(TaskCompletionReminderNotificationRequest request) {
        throw new UnsupportedOperationException();
    }

    @Override
    public SmsNotificationMessage getSmsMessageContent(TaskCompletionReminderNotificationRequest request) {
        throw new UnsupportedOperationException();
    }

    @Override
    public InAppNotificationMessage getInAppMessageContent(TaskCompletionReminderNotificationRequest request) {
        throw new UnsupportedOperationException();
    }
}
