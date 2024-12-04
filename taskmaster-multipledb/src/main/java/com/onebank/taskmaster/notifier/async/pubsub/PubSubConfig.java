package com.onebank.taskmaster.notifier.async.pubsub;

import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.ProjectTopicName;
import com.onebank.taskmaster.notifier.async.ConditionalOnPubSubEnabled;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
@ConditionalOnPubSubEnabled
public class PubSubConfig {

    @Bean
    public ProjectSubscriptionName projectSubscription(@Qualifier("cloudPubSubProperties") Properties properties) {
        return ProjectSubscriptionName.of(properties.getProperty("projectId"), properties.getProperty("subscriptionId"));
    }

    @Bean
    public ProjectTopicName projectTopic(@Qualifier("cloudPubSubProperties") Properties properties) {
        return ProjectTopicName.of(properties.getProperty("projectId"), properties.getProperty("topic"));
    }
}
