package com.onebank.taskmaster.notifier.service.senders;

import com.onebank.taskmaster.notifier.model.senders.NotificationMessage;
import com.onebank.taskmaster.notifier.service.producers.NotificationMessageProducer;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class InAppNotificationSenderService implements SendNotification {
    private final NotificationMessageProducer notificationMessageProducer;

    @Override
    public void send(@NonNull NotificationMessage notification) {
        log.debug("Producing {} notification with ID = {}", notification.getChannel().getName(), notification.getId());
        notificationMessageProducer.sendMessage(notification);
    }
}
