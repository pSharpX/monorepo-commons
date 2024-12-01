package com.onebank.taskmaster.notifier.service.senders;

import com.onebank.taskmaster.notifier.model.senders.EmailNotificationMessage;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailNotificationSenderService implements SendNotification<EmailNotificationMessage> {

    @Override
    public void send(@NonNull EmailNotificationMessage notification) {
        throw new UnsupportedOperationException();
    }
}
