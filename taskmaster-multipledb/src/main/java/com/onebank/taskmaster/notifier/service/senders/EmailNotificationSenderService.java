package com.onebank.taskmaster.notifier.service.senders;

import com.onebank.taskmaster.notifier.model.senders.EmailNotification;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailNotificationSenderService implements SendNotification<EmailNotification> {

    @Override
    public void send(@NonNull EmailNotification notification) {
        throw new UnsupportedOperationException();
    }
}
