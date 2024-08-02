package com.onebank.security.encryption.config;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.cloud.kms.v1.KeyManagementServiceSettings;
import com.onebank.security.encryption.service.Decrypt;
import com.onebank.security.encryption.service.DecryptSymmetricService;
import com.onebank.security.encryption.service.Encrypt;
import com.onebank.security.encryption.service.EncryptSymmetricService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;

@Configuration
@ConditionalOnCloudKMSEnabled
@EnableConfigurationProperties(CloudKMSConfigProperties.class)
public class CloudKMSConfig {

    @Bean
    @ConditionalOnServiceAccountKey
    public GoogleCredentials fixedGoogleCredentials(ResourceLoader resourceLoader, CloudKMSConfigProperties configProperties) throws IOException {
        return GoogleCredentials.fromStream(resourceLoader.getResource(configProperties.getServiceAccountKeyPath()).getInputStream());
    }

    @Bean
    @ConditionalOnMissingBean
    public GoogleCredentials defaultGoogleCredentials(ResourceLoader resourceLoader, CloudKMSConfigProperties configProperties) throws IOException {
        return GoogleCredentials.getApplicationDefault();
    }

    @Bean
    public KeyManagementServiceSettings keyManagementServiceSettings(GoogleCredentials googleCredentials) throws IOException {
        return KeyManagementServiceSettings.newBuilder()
                .setCredentialsProvider(FixedCredentialsProvider.create(googleCredentials))
                .build();
    }

    @Bean
    public KeyManagementServiceClient keyManagementServiceClient(KeyManagementServiceSettings keyManagementServiceSettings) throws IOException {
        return KeyManagementServiceClient.create(keyManagementServiceSettings);
    }

    @Bean
    @ConditionalOnMissingBean
    public Decrypt cloudKmsDecryptSymmetricService(KeyManagementServiceClient client, CloudKMSConfigProperties configProperties) {
        return new DecryptSymmetricService(client, configProperties);
    }

    @Bean
    @ConditionalOnMissingBean
    public Encrypt cloudKmsEncryptSymmetricService(KeyManagementServiceClient client, CloudKMSConfigProperties configProperties) {
        return new EncryptSymmetricService(client, configProperties);
    }

}
