package com.onebank.security.encryption.service;

import java.io.IOException;

public interface Encrypt {
    byte[] encryptSymmetric(String plainText)  throws IOException;
}
