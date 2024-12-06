package com.onebank.taskmaster.notifier.async;

import com.onebank.taskmaster.config.ConditionalOnNotificationEnabled;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ConditionalOnNotificationEnabled
@ConditionalOnProperty(name = "task-master.notification.engine", havingValue = "rabbitmq")
public @interface ConditionalOnRabbitEnabled {
}
