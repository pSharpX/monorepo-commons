package com.onebank.taskmaster.controlplane.config;

import com.onebank.taskmaster.controlplane.model.AppIdentifier;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.Optional;

public class TenantRoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return Optional.ofNullable(TenantContext.getCurrentTenant())
                .orElse(AppIdentifier.CONTROL_PLANE_1);
    }
}
