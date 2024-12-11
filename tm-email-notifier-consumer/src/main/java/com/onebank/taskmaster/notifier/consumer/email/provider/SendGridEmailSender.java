package com.onebank.taskmaster.notifier.consumer.email.provider;

import com.onebank.taskmaster.notifier.consumer.email.config.ConditionalOnSendGridEnabled;
import com.onebank.taskmaster.notifier.consumer.email.model.MessageTemplate;
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
    public void send(@NonNull MessageTemplate messageTemplate) {
        log.debug("Sending [{}] notification with SendGrid Provider", "TASK_CREATED");
    }
}
