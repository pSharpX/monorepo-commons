package com.onebank.taskmaster.notifier.service.senders;

import com.onebank.taskmaster.notifier.model.senders.PushNotificationMessage;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PushNotificationSenderService implements SendNotification<PushNotificationMessage> {

    @Override
    public void send(@NonNull PushNotificationMessage notification) {
        throw new UnsupportedOperationException();
    }
}
