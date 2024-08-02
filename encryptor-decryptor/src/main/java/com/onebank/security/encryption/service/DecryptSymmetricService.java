package com.onebank.security.encryption.service;

import com.google.cloud.kms.v1.CryptoKeyName;
import com.google.cloud.kms.v1.DecryptResponse;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.protobuf.ByteString;
import com.onebank.security.encryption.config.CloudKMSConfigProperties;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DecryptSymmetricService implements Decrypt {

    private final KeyManagementServiceClient client;
    private final CloudKMSConfigProperties configProperties;

    @Override
    public String decryptSymmetric(byte[] ciphertext) {
        CryptoKeyName keyName = CryptoKeyName.of(configProperties.getProjectId(), configProperties.getLocationId(), configProperties.getKeyRingId(), configProperties.getKeyId());
        DecryptResponse response = client.decrypt(keyName, ByteString.copyFrom(ciphertext));
        return response.getPlaintext().toStringUtf8();
    }

}
