package com.onebank.taskmaster.controlplane.config;

import org.springframework.context.annotation.ComponentScan;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ComponentScan(basePackages = "com.onebank.taskmaster.controlplane")
public @interface EnableControlPlane {
}
