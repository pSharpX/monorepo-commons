package com.onebank.taskmaster.notifier.service;

import com.onebank.taskmaster.notifier.model.NotificationChannel;
import com.onebank.taskmaster.notifier.service.senders.EmailNotificationSenderService;
import com.onebank.taskmaster.notifier.service.senders.InAppNotificationSenderService;
import com.onebank.taskmaster.notifier.service.senders.PushNotificationSenderService;
import com.onebank.taskmaster.notifier.service.senders.SendNotification;
import com.onebank.taskmaster.notifier.service.senders.SmsNotificationSenderService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@SuppressWarnings("rawtypes")
public class ChannelResolverService implements ChannelResolver {
    private final EmailNotificationSenderService emailNotificationSenderService;
    private final PushNotificationSenderService pushNotificationSenderService;
    private final SmsNotificationSenderService smsNotificationSenderService;
    private final InAppNotificationSenderService inAppNotificationSenderService;

    @Override
    public SendNotification resolve(@NonNull NotificationChannel channel) {
        return switch (channel) {
            case EMAIL -> emailNotificationSenderService;
            case PUSH -> pushNotificationSenderService;
            case SMS -> smsNotificationSenderService;
            case IN_APP -> inAppNotificationSenderService;
        };
    }
}
