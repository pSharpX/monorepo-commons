package com.onebank.security.encryption.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ConditionalOnExpression("!T(org.springframework.util.StringUtils).isEmpty('${encryptor-decryptor.provider.cloud-kms.serviceAccountKeyPath:}')")
public @interface ConditionalOnServiceAccountKey {
    String value() default "";
}
