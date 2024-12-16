package com.onebank.taskmaster.notifier.service.providers;

import com.onebank.taskmaster.notifier.model.TaskCreatedNotificationRequest;
import com.onebank.taskmaster.notifier.model.TaskNotificationType;
import com.onebank.taskmaster.notifier.model.senders.EmailNotificationMessage;
import com.onebank.taskmaster.notifier.model.senders.InAppNotificationMessage;
import com.onebank.taskmaster.notifier.model.senders.PushNotificationMessage;
import com.onebank.taskmaster.notifier.model.senders.SmsNotificationMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskCreatedContentProvider implements MessageContentProvider<TaskCreatedNotificationRequest> {

    @Override
    public EmailNotificationMessage getEmailMessageContent(TaskCreatedNotificationRequest request) {
        EmailNotificationMessage notificationMessage = new EmailNotificationMessage();
        notificationMessage.setId(request.getId());
        notificationMessage.setType(TaskNotificationType.TASK_CREATED);
        notificationMessage.setUser(request.getUser());
        notificationMessage.setRecipientEmail(request.getUser());
        notificationMessage.setRecipientName("Christian Rivera");
        notificationMessage.setTitle(request.getTitle());
        notificationMessage.setMessage(request.getMessage());
        notificationMessage.setTemplateName("TEMPLATE_NAME");
        notificationMessage.setVars(Map.of(
                "application_name", "",
                "current_year", "",
                "username", "Christian Rivera"
        ));
        return notificationMessage;
    }

    @Override
    public PushNotificationMessage getPushMessageContent(TaskCreatedNotificationRequest request) {
        throw new UnsupportedOperationException();
    }

    @Override
    public SmsNotificationMessage getSmsMessageContent(TaskCreatedNotificationRequest request) {
        throw new UnsupportedOperationException();
    }

    @Override
    public InAppNotificationMessage getInAppMessageContent(TaskCreatedNotificationRequest request) {
        throw new UnsupportedOperationException();
    }
}
