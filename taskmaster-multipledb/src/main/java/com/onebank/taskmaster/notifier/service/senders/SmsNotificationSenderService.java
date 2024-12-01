package com.onebank.taskmaster.notifier.service.senders;

import com.onebank.taskmaster.notifier.model.senders.SmsNotificationMessage;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SmsNotificationSenderService implements SendNotification<SmsNotificationMessage> {

    @Override
    public void send(@NonNull SmsNotificationMessage notification) {
        throw new UnsupportedOperationException();
    }
}
