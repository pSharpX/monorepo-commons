package com.onebank.taskmaster.notifier.async.pubsub;

import com.onebank.taskmaster.notifier.config.ConditionalOnPubSubEnabled;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnPubSubEnabled
public class PubSubConfig {
}
