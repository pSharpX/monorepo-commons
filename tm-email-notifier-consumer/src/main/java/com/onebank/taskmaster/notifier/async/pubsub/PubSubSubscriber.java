package com.onebank.taskmaster.notifier.async.pubsub;

import com.google.cloud.spring.pubsub.core.subscriber.PubSubSubscriberTemplate;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.onebank.taskmaster.notifier.config.ConditionalOnPubSubEnabled;
import com.onebank.taskmaster.notifier.consumer.service.NotificationMessageListener;
import com.onebank.taskmaster.notifier.model.senders.NotificationMessage;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@ConditionalOnPubSubEnabled
public class PubSubSubscriber {
    private final ProjectSubscriptionName subscriptionName;
    private final PubSubSubscriberTemplate subscriberTemplate;
    private final NotificationMessageListener notificationMessageListener;

    @PostConstruct
    private void onPostConstruct() {
        subscriberTemplate.subscribeAndConvert(subscriptionName.toString(), (message) -> {
            notificationMessageListener.listen(message.getPayload());
            message.ack();
        } , NotificationMessage.class);
    }
}
