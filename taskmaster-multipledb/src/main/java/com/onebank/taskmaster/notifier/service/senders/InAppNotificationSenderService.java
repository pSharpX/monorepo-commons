package com.onebank.taskmaster.notifier.service.senders;

import com.onebank.taskmaster.notifier.model.senders.InAppNotification;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class InAppNotificationSenderService implements SendNotification<InAppNotification> {

    @Override
    public void send(@NonNull InAppNotification notification) {
        throw new UnsupportedOperationException();
    }
}
