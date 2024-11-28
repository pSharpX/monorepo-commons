package com.onebank.taskmaster.controlplane.controller.interceptor;

import com.onebank.taskmaster.controlplane.config.OnDatabaseIntegration;
import com.onebank.taskmaster.controlplane.config.TenantContext;
import com.onebank.taskmaster.controlplane.model.AppIdentifier;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Optional;

@Order(1)
@Component
@OnDatabaseIntegration
public class TenantInterceptor implements HandlerInterceptor {
    private static final String APPLICATION_ID_HEADER_NAME = "x-application-id";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        AppIdentifier tenant = Optional.ofNullable(request.getHeader(APPLICATION_ID_HEADER_NAME))
                .map(AppIdentifier::getByCode)
                .orElse(AppIdentifier.CONTROL_PLANE_1);
        TenantContext.setCurrentTenant(tenant);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        TenantContext.clear();
    }
}
