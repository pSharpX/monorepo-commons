package com.onebank.taskmaster.notifier.service.senders;

import com.onebank.taskmaster.notifier.model.senders.InAppNotificationMessage;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class InAppNotificationSenderService implements SendNotification<InAppNotificationMessage> {

    @Override
    public void send(@NonNull InAppNotificationMessage notification) {
        throw new UnsupportedOperationException();
    }
}
