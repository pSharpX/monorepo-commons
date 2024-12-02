package com.onebank.taskmaster.notifier.service;

import com.onebank.taskmaster.converter.ConvertTo;
import com.onebank.taskmaster.notifier.entity.NotificationEntity;
import com.onebank.taskmaster.notifier.model.CreateTaskNotificationRequest;
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
    private final BuilderResolver builderResolver;
    private final ChannelResolver channelResolver;
    private final ConvertTo<CreateTaskNotificationRequest, NotificationEntity> converter;

    @Override
    @Transactional
    public void create(@NonNull CreateTaskNotificationRequest request) {
        log.debug("Creating new notification with title [{}]", request.getTitle());
        NotificationEntity notificationEntity = notificationRepository.save(converter.convert(request));
        request.setId(notificationEntity.getId());

        NotificationMessage notification = builderResolver.resolve(notificationEntity.getNotificationType()).build(request);
        channelResolver.resolve(notificationEntity.getChannel()).send(notification);
    }
}
