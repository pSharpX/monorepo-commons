package com.onebank.security.encryption.config;

import com.onebank.security.encryption.service.Decrypt;
import com.onebank.security.encryption.service.Encrypt;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;

@Configuration
public class DefaultConfig {

    @Bean
    @ConditionalOnMissingBean
    public Decrypt defaultDecryptSymmetricService() {
        return (byte[] cipherText) -> "Plain text";
    }

    @Bean
    @ConditionalOnMissingBean
    public Encrypt defaultEncryptSymmetricService() {
        return (String plainText) -> plainText.getBytes(StandardCharsets.UTF_8);
    }

}
