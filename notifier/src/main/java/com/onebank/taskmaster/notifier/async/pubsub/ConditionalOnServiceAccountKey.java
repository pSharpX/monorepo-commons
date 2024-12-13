package com.onebank.taskmaster.notifier.async.pubsub;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ConditionalOnExpression("!T(org.springframework.util.StringUtils).isEmpty('${task-master.notification.pubsub.serviceAccountKeyPath:}')")
public @interface ConditionalOnServiceAccountKey {
    String value() default "";
}
