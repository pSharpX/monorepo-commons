package com.onebank.taskmaster.notifier.service.producers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.spring.pubsub.core.publisher.PubSubPublisherTemplate;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.ProjectTopicName;
import com.google.pubsub.v1.PubsubMessage;
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
    private final ObjectMapper objectMapper;

    private static final String TYPE_ATTRIBUTE = "type";

    @Override
    public void sendMessage(@NonNull NotificationMessage notification) {
        try {
            PubsubMessage pubsubMessage = PubsubMessage.newBuilder()
                    .setData(ByteString.copyFromUtf8(objectMapper.writeValueAsString(notification)))
                    .putAttributes(TYPE_ATTRIBUTE, notification.getChannel().getName())
                    .build();
            publisherTemplate.publish(topicName.toString(), pubsubMessage);
        } catch (JsonProcessingException e) {
            log.error("Error occurred while publishing message");
            throw new RuntimeException(e);
        }
    }
}
