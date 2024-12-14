package com.onebank.taskmaster.notifier.consumer.email.service.sender;

import com.onebank.taskmaster.notifier.consumer.email.config.ConditionalOnSendGridEnabled;
import com.onebank.taskmaster.notifier.model.senders.EmailNotificationMessage;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@ConditionalOnSendGridEnabled
@Slf4j
public class SendGridEmailSender implements EmailSender {
    @Override
    public void send(@NonNull EmailNotificationMessage notificationMessage) {
        log.debug("Sending [{}] notification with SendGrid Provider", notificationMessage.getChannel().getName());
    }
}
