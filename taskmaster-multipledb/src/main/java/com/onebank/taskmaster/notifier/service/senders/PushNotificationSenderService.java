package com.onebank.taskmaster.notifier.service.senders;

import com.onebank.taskmaster.notifier.model.senders.PushNotification;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PushNotificationSenderService implements SendNotification<PushNotification> {

    @Override
    public void send(@NonNull PushNotification notification) {
        throw new UnsupportedOperationException();
    }
}
