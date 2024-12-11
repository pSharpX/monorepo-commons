package com.onebank.taskmaster.notifier.consumer.email.provider;

import com.onebank.taskmaster.notifier.consumer.email.config.ConditionalOnMailgunEnabled;
import com.onebank.taskmaster.notifier.consumer.email.model.MessageTemplate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@ConditionalOnMailgunEnabled
@Slf4j
public class MailgunEmailSender implements EmailSender {
    @Override
    public void send(@NonNull MessageTemplate messageTemplate) {
        log.debug("Sending [{}] notification with Mailgun Provider", "TASK_CREATED");
    }
}
