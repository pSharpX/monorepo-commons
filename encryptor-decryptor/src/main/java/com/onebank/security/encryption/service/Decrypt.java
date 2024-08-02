package com.onebank.security.encryption.service;

import java.io.IOException;

public interface Decrypt {
    String decryptSymmetric(byte[] ciphertext) throws IOException;
}
