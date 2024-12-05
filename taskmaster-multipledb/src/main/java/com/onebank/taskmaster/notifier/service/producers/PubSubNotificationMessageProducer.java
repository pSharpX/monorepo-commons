package com.onebank.taskmaster.notifier.service.producers;

import com.google.cloud.spring.pubsub.core.publisher.PubSubPublisherTemplate;
import com.google.pubsub.v1.ProjectTopicName;
import com.onebank.taskmaster.notifier.async.ConditionalOnPubSubEnabled;
import com.onebank.taskmaster.notifier.model.senders.NotificationMessage;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@ConditionalOnPubSubEnabled
public class PubSubNotificationMessageProducer implements NotificationMessageProducer {
    private final PubSubPublisherTemplate publisherTemplate;
    private final ProjectTopicName topicName;

    @Override
    public void sendMessage(@NonNull NotificationMessage notification) {
        publisherTemplate.publish(topicName.toString(), notification);
    }
}
