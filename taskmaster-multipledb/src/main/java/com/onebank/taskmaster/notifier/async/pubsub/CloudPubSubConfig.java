package com.onebank.taskmaster.notifier.async.pubsub;

import com.google.auth.oauth2.GoogleCredentials;
import com.onebank.taskmaster.notifier.async.ConditionalOnPubSubEnabled;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.util.Properties;

@Configuration
@ConditionalOnPubSubEnabled
public class CloudPubSubConfig {

    @Bean(name = "cloudPubSubProperties")
    @ConfigurationProperties(prefix = "task-master.notification.pubsub")
    private Properties cloudPubSubProperties() {
        return new Properties();
    }

    @Bean
    @ConditionalOnServiceAccountKey
    public GoogleCredentials fixedGoogleCredentials(ResourceLoader resourceLoader, @Qualifier("cloudPubSubProperties") Properties cloudPubSubProperties) throws IOException {
        return GoogleCredentials.fromStream(resourceLoader.getResource(cloudPubSubProperties.getProperty("serviceAccountKeyPath")).getInputStream());
    }

    @Bean
    @ConditionalOnMissingBean
    public GoogleCredentials defaultGoogleCredentials() throws IOException {
        return GoogleCredentials.getApplicationDefault();
    }
}
