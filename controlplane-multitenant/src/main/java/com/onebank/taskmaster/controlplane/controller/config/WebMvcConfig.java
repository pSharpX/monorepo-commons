package com.onebank.taskmaster.controlplane.controller.config;

import com.onebank.taskmaster.controlplane.config.OnDatabaseIntegration;
import com.onebank.taskmaster.controlplane.controller.interceptor.TenantInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
@OnDatabaseIntegration
public class WebMvcConfig implements WebMvcConfigurer {
    private final TenantInterceptor tenantInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.tenantInterceptor);
    }

}
