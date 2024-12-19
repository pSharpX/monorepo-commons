package com.onebank.taskmaster.controlplane.provider;

import com.onebank.taskmaster.controlplane.config.ConditionalOnNotificationEnabled;
import com.onebank.taskmaster.controlplane.model.notification.TaskNotificationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@ConditionalOnNotificationEnabled
@Slf4j
public class NotificationSenderService implements NotificationSender {
    private final NotificationClient notificationClient;

    @Override
    public void send(TaskNotificationRequest request) {
        log.debug("Sending [{}] notification = {}", request.getType(), request.getTitle());
        notificationClient.send(request);
    }
}
