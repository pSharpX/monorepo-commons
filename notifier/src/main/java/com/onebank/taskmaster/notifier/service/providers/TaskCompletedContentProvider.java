package com.onebank.taskmaster.notifier.service.providers;

import com.onebank.taskmaster.notifier.model.NotificationTemplateDetails;
import com.onebank.taskmaster.notifier.model.TaskCompletedNotificationRequest;
import com.onebank.taskmaster.notifier.model.senders.EmailNotificationMessage;
import com.onebank.taskmaster.notifier.model.senders.InAppNotificationMessage;
import com.onebank.taskmaster.notifier.model.senders.PushNotificationMessage;
import com.onebank.taskmaster.notifier.model.senders.SmsNotificationMessage;
import com.onebank.taskmaster.notifier.service.NotificationTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TaskCompletedContentProvider extends TaskMessageContentProvider<TaskCompletedNotificationRequest> {

    @Autowired
    public TaskCompletedContentProvider(NotificationTemplateService templateService) {
        super(templateService);
    }

    @Override
    public EmailNotificationMessage getEmailMessageContent(TaskCompletedNotificationRequest request, NotificationTemplateDetails templateDetails) {
        return super.getEmailMessageContent(request, templateDetails);
    }

    @Override
    public PushNotificationMessage getPushMessageContent(TaskCompletedNotificationRequest request, NotificationTemplateDetails templateDetails) {
        return super.getPushMessageContent(request, templateDetails);
    }

    @Override
    public SmsNotificationMessage getSmsMessageContent(TaskCompletedNotificationRequest request, NotificationTemplateDetails templateDetails) {
        return super.getSmsMessageContent(request, templateDetails);
    }

    @Override
    public InAppNotificationMessage getInAppMessageContent(TaskCompletedNotificationRequest request, NotificationTemplateDetails templateDetails) {
        return super.getInAppMessageContent(request, templateDetails);
    }
}
