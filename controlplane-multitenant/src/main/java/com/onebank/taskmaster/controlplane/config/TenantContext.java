package com.onebank.taskmaster.controlplane.config;

import com.onebank.taskmaster.controlplane.model.AppIdentifier;

public class TenantContext {
    private static final ThreadLocal<AppIdentifier> CONTEXT = new ThreadLocal<>();

    public static void setCurrentTenant(AppIdentifier appIdentifier) {
        CONTEXT.set(appIdentifier);
    }

    public static AppIdentifier getCurrentTenant() {
        return CONTEXT.get();
    }

    public static void clear() {
        CONTEXT.remove();
    }
}
