package com.onebank.taskmaster.notifier.async.pubsub;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.cloud.pubsub.v1.TopicAdminSettings;
import com.google.cloud.spring.pubsub.support.converter.JacksonPubSubMessageConverter;
import com.google.cloud.spring.pubsub.support.converter.PubSubMessageConverter;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.onebank.taskmaster.notifier.config.ConditionalOnPubSubEnabled;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.io.IOException;
import java.util.Properties;

@Configuration
@ConditionalOnPubSubEnabled
public class PubSubConfig {

    @Bean
    public ProjectSubscriptionName projectSubscription(@Qualifier("cloudPubSubProperties") Properties properties) {
        return ProjectSubscriptionName.of(properties.getProperty("projectId"), properties.getProperty("subscriptionId"));
    }

    @Bean
    public PubSubMessageConverter pubSubMessageConverter(ObjectMapper objectMapper) {
        return new JacksonPubSubMessageConverter(objectMapper);
    }

    @Bean
    @ConditionalOnMissingBean
    public TopicAdminClient topicAdminClient(CredentialsProvider defaultCredentialsProvider) throws IOException {
        TopicAdminSettings topicAdminSettings = TopicAdminSettings.newBuilder()
                .setCredentialsProvider(defaultCredentialsProvider)
                .setTransportChannelProvider(defaultTransportChannelProvider())
                .build();

        return TopicAdminClient.create(topicAdminSettings);
    }

    @Bean
    public TransportChannelProvider defaultTransportChannelProvider() {
        return InstantiatingGrpcChannelProvider.newBuilder()
                .setHeaderProvider(FixedHeaderProvider.create("user-agent", "spring-cloud-gcp"))
                .build();
    }

    @Bean(name = "pubsubSubscriberThreadPool")
    public ThreadPoolTaskScheduler pubsubSubscriberThreadPool() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(4);
        taskScheduler.setThreadNamePrefix("pubsub-subscriber-thread-");
        taskScheduler.setDaemon(false); // Non-daemon threads will keep the application running
        return taskScheduler;
    }

}
