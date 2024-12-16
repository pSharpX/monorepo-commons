package com.onebank.taskmaster.notifier.service.providers;

import com.onebank.taskmaster.notifier.model.TaskCompletedNotificationRequest;
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
public class TaskCompletedContentProvider implements MessageContentProvider<TaskCompletedNotificationRequest> {

    @Override
    public EmailNotificationMessage getEmailMessageContent(TaskCompletedNotificationRequest request) {
        throw new UnsupportedOperationException();
    }

    @Override
    public PushNotificationMessage getPushMessageContent(TaskCompletedNotificationRequest request) {
        throw new UnsupportedOperationException();
    }

    @Override
    public SmsNotificationMessage getSmsMessageContent(TaskCompletedNotificationRequest request) {
        throw new UnsupportedOperationException();
    }

    @Override
    public InAppNotificationMessage getInAppMessageContent(TaskCompletedNotificationRequest request) {
        throw new UnsupportedOperationException();
    }
}
