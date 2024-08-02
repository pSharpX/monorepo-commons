package com.onebank.security.encryption.config;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@ConfigurationProperties(prefix = "encryptor-decryptor.provider.cloud-kms")
@Validated
public class CloudKMSConfigProperties {
    private boolean enabled;
    @NotBlank
    private String projectId;
    @NotBlank
    private String locationId;
    @NotBlank
    private String keyRingId;
    @NotBlank
    private String keyId;
    private String serviceAccountKeyPath;
}
