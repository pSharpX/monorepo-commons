package com.onebank.taskmaster.notifier.consumer.email.provider;

import com.onebank.taskmaster.notifier.consumer.email.config.ConditionalOnMailChimpEnabled;
import com.onebank.taskmaster.notifier.consumer.email.model.MessageTemplate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@ConditionalOnMailChimpEnabled
@Slf4j
public class MailChimpEmailSender implements EmailSender {
    @Override
    public void send(@NonNull MessageTemplate messageTemplate) {
        log.debug("Sending [{}] notification with MailChimp Provider", "TASK_CREATED");
    }
}
