package com.onebank.security.encryption.service;

import com.google.cloud.kms.v1.CryptoKeyName;
import com.google.cloud.kms.v1.EncryptResponse;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.protobuf.ByteString;
import com.onebank.security.encryption.config.CloudKMSConfigProperties;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EncryptSymmetricService implements Encrypt {

    private final KeyManagementServiceClient client;
    private final CloudKMSConfigProperties configProperties;

    @Override
    public byte[] encryptSymmetric(String plaintext) {
        CryptoKeyName keyName = CryptoKeyName.of(configProperties.getProjectId(), configProperties.getLocationId(), configProperties.getKeyRingId(), configProperties.getKeyId());
        EncryptResponse response = client.encrypt(keyName, ByteString.copyFromUtf8(plaintext));
        return response.getCiphertext().toByteArray();
    }

}