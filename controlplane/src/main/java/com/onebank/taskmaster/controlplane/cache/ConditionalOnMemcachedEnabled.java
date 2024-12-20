package com.onebank.taskmaster.controlplane.cache;

import com.onebank.taskmaster.controlplane.config.ConditionalOnCacheEnabled;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ConditionalOnCacheEnabled
@ConditionalOnProperty(name = "control-plane.cache.engine", havingValue = "memcached")
public @interface ConditionalOnMemcachedEnabled {
    String value() default "";
}
