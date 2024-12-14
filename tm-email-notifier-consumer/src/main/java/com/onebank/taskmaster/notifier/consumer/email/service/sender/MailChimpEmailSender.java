package com.onebank.taskmaster.notifier.consumer.email.service.sender;

import com.onebank.taskmaster.notifier.consumer.email.config.ConditionalOnMailChimpEnabled;
import com.onebank.taskmaster.notifier.consumer.email.provider.mailchimp.MailChimpClient;
import com.onebank.taskmaster.notifier.model.senders.EmailNotificationMessage;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@ConditionalOnMailChimpEnabled
@Slf4j
public class MailChimpEmailSender implements EmailSender {
    private final MailChimpClient mailChimpClient;

    @Override
    public void send(@NonNull EmailNotificationMessage notificationMessage) {
        log.debug("Sending [{}] notification with MailChimp Provider", notificationMessage.getChannel().getName());
    }
}
