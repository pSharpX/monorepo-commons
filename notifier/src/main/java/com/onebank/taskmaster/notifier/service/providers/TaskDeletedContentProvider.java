package com.onebank.taskmaster.notifier.service.providers;

import com.onebank.taskmaster.notifier.model.TaskDeletedNotificationRequest;
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
public class TaskDeletedContentProvider implements MessageContentProvider<TaskDeletedNotificationRequest> {

    @Override
    public EmailNotificationMessage getEmailMessageContent(TaskDeletedNotificationRequest request) {
        throw new UnsupportedOperationException();
    }

    @Override
    public PushNotificationMessage getPushMessageContent(TaskDeletedNotificationRequest request) {
        throw new UnsupportedOperationException();
    }

    @Override
    public SmsNotificationMessage getSmsMessageContent(TaskDeletedNotificationRequest request) {
        throw new UnsupportedOperationException();
    }

    @Override
    public InAppNotificationMessage getInAppMessageContent(TaskDeletedNotificationRequest request) {
        throw new UnsupportedOperationException();
    }
}
