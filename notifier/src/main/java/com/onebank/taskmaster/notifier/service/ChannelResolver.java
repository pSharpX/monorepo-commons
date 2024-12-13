package com.onebank.taskmaster.notifier.service;

import com.onebank.taskmaster.notifier.model.NotificationChannel;
import com.onebank.taskmaster.notifier.service.senders.SendNotification;
import lombok.NonNull;

public interface ChannelResolver {
    SendNotification resolve(@NonNull NotificationChannel channel);
}
