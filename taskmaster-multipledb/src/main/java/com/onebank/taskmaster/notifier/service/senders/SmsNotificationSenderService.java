package com.onebank.taskmaster.notifier.service.senders;

import com.onebank.taskmaster.notifier.model.senders.SmsNotification;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SmsNotificationSenderService implements SendNotification<SmsNotification> {

    @Override
    public void send(@NonNull SmsNotification notification) {
        throw new UnsupportedOperationException();
    }
}
