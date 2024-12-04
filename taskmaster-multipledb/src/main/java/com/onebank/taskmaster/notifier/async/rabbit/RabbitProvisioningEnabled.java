package com.onebank.taskmaster.notifier.async.rabbit;

import com.onebank.taskmaster.notifier.async.ConditionalOnRabbitEnabled;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ConditionalOnRabbitEnabled
@ConditionalOnProperty(name = "task-master.notification.provisioned", havingValue = "true")
public @interface RabbitProvisioningEnabled {
}
