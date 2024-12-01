package com.onebank.taskmaster.notifier.service;

import com.onebank.taskmaster.converter.ConvertTo;
import com.onebank.taskmaster.notifier.entity.NotificationEntity;
import com.onebank.taskmaster.notifier.model.CreateNotificationRequest;
import com.onebank.taskmaster.notifier.model.senders.EmailNotificationMessage;
import com.onebank.taskmaster.notifier.model.senders.NotificationMessage;
import com.onebank.taskmaster.notifier.repository.NotificationRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@SuppressWarnings("unchecked")
public class CreateNotificationService implements CreateNotification {
    private final NotificationRepository notificationRepository;
    private final ChannelResolver channelResolver;
    private final ConvertTo<CreateNotificationRequest, NotificationEntity> converter;

    @Override
    @Transactional
    public void create(@NonNull CreateNotificationRequest request) {
        log.debug("Creating new notification[{}] with title [{}]", request.getChannel(), request.getTitle());
        NotificationEntity notificationEntity = notificationRepository.save(converter.convert(request));

        NotificationMessage notification = new EmailNotificationMessage();
        channelResolver.resolve(notificationEntity.getChannel()).send(notification);
    }
}
